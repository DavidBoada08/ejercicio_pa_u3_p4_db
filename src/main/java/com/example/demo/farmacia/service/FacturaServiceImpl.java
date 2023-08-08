package com.example.demo.farmacia.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.farmacia.repo.IFacturaRepo;
import com.example.demo.farmacia.repo.IProductoRepo;
import com.example.demo.farmacia.repo.modelo.DetalleFactura;
import com.example.demo.farmacia.repo.modelo.Factura;
import com.example.demo.farmacia.repo.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepo iFacturaRepo;

	@Autowired
	private IDetalleFacturaService iDetalleFacturaService;

	@Autowired
	private IProductoRepo iProductoRepo; 

	@Override
	///																	numero de factura
	public void realizarFactura(List<Producto> producto, String cedula, String numeroFactura) {
		// TODO Auto-generated method stub
		
		Factura fac = new Factura();
		fac.setCedula(cedula);
		fac.setFecha(LocalDate.now());
		
		BigDecimal total=new BigDecimal(0);
		List<DetalleFactura> detalleFactura=new ArrayList<DetalleFactura>();
		
		for(Producto prod: producto) {
			Producto encontrarProducto=this.iProductoRepo.buscar(prod.getCodBarras());
			BigDecimal valor=new BigDecimal(0);
			DetalleFactura detalle=new DetalleFactura();
			
			if(encontrarProducto.getStock()==0) {
				LOG.info("El stock del producto esta en cero");
			}else {
				if(encontrarProducto.getStock()<=prod.getStock()) {
					detalle.setCantidad(encontrarProducto.getStock());
					valor.add(encontrarProducto.getPrecio().multiply(new BigDecimal(encontrarProducto.getStock())));
					detalle.setSubtotal(valor);
					encontrarProducto.setStock(0);
					this.iProductoRepo.actualizar(encontrarProducto);
				}else {
					detalle.setCantidad(encontrarProducto.getStock()-prod.getStock());
					valor.add(encontrarProducto.getPrecio().multiply(new BigDecimal(encontrarProducto.getStock()-prod.getStock())));
					detalle.setSubtotal(valor);
					encontrarProducto.setStock(encontrarProducto.getStock()-prod.getStock());
					this.iProductoRepo.actualizar(encontrarProducto);
				}
			}
			detalle.setItem(encontrarProducto);
			detalle.setValor_unidad(encontrarProducto.getPrecio());
			total.add(valor);
			detalleFactura.add(detalle);
		}
		fac.setTotalFactura(total);
		this.iFacturaRepo.insertar(fac);
		//															numero deFactura
		this.iDetalleFacturaService.insertarDetalle(detalleFactura, numeroFactura);
		
		

	}

}
