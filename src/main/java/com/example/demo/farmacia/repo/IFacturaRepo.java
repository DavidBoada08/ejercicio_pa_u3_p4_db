package com.example.demo.farmacia.repo;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.farmacia.repo.modelo.Factura;

public interface IFacturaRepo {
	
	public void insertar(Factura factura);
	public void actualizar (Factura factura);
	public Factura buscar(String numero);
	
	public List<Factura> buscarPorFecha(LocalDate fecha);
}
