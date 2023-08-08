package com.example.demo.farmacia.repo;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.example.demo.farmacia.repo.modelo.DetalleFactura;

public interface IDetalleFacturaRepo {
	
	public void insertar(DetalleFactura detalleFactura);
	public void actualizar(DetalleFactura detalleFactura);
	public List<DetalleFactura> buscarPorVenta(String numero);
	public Item buscarPorItem(String codBarras);
}
