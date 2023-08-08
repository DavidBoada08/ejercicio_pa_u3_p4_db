package com.example.demo.farmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.farmacia.repo.IDetalleFacturaRepo;
import com.example.demo.farmacia.repo.IFacturaRepo;
import com.example.demo.farmacia.repo.modelo.DetalleFactura;
import com.example.demo.farmacia.repo.modelo.Factura;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {
	@Autowired
	private IDetalleFacturaRepo iDetalleFacturaRepo;
	
	@Autowired
	private IFacturaRepo iFacturaRepo;
	

	@Override
	public void insertarDetalle(List<DetalleFactura> detalleFactura, String numeroFactura) {
		Factura fac1=this.iFacturaRepo.buscar(numeroFactura);
		for(DetalleFactura df: detalleFactura){
			df.setFactura(fac1);
			this.iDetalleFacturaRepo.insertar(df);;
		}
		
	}
	
	

}
