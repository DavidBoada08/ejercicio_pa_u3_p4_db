package com.example.demo.farmacia.repo;

import java.util.List;

import com.example.demo.farmacia.repo.modelo.Producto;

public interface IProductoRepo {
	
	public void insertar(Producto producto);
	public void actualizar (Producto producto);
	public Producto buscar(String codBarras);
	public boolean buscarProductoExistente(String codBarras);
	public List<Producto> buscarPortipo(String tipo);
	

}
