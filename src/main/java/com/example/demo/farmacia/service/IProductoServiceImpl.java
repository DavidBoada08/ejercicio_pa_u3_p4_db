package com.example.demo.farmacia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.farmacia.repo.IProductoRepo;
import com.example.demo.farmacia.repo.modelo.Producto;

@Service
public class IProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo iProductoRepo;

	@Override
	public void ingresar(Producto producto) {
		if (this.iProductoRepo.buscarProductoExistente(producto.getCodBarras())) {

			Producto productoExistente = this.iProductoRepo.buscar(producto.getCodBarras());

			Integer stockAterior = productoExistente.getStock();
			Integer stockNuevo = stockAterior + producto.getStock();
			productoExistente.setStock(stockNuevo);
			this.iProductoRepo.actualizar(productoExistente);

		} else {
			this.iProductoRepo.insertar(producto);
		}
	}

	@Override
	public Producto encontrar(String codBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepo.buscar(codBarras);
	}

}
