package com.example.demo.farmacia.service;

import com.example.demo.farmacia.repo.modelo.Producto;

public interface IProductoService {
	
	public void ingresar(Producto producto);
	public Producto encontrar(String codBarras);
	

}
