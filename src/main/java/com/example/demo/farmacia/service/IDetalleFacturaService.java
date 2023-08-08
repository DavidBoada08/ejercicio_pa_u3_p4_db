package com.example.demo.farmacia.service;

import java.util.List;

import com.example.demo.farmacia.repo.modelo.DetalleFactura;

public interface IDetalleFacturaService {
	
	public void insertarDetalle(List<DetalleFactura> detalles, String numero);

}
