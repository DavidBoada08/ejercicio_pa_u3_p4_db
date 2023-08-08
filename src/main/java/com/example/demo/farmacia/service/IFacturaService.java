package com.example.demo.farmacia.service;

import java.util.List;

import com.example.demo.farmacia.repo.modelo.Producto;

public interface IFacturaService {
	
	public void realizarFactura(List<Producto> producto, String cedula, String numeroventa);

}
