package com.example.demo.farmacia.repo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

public class DetalleFactura {
	
	@Id
	@Column(name = "detalle_fatura_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_fatura_id_seq")
	@SequenceGenerator(name = "detalle_fatura_id_seq", sequenceName = "detalle_fatura_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "detalle_fatura_cantidad")
	private Integer cantidad;

	@Column(name = "detalle_fatura_valor_unidad")
	private BigDecimal valor_unidad;

	@Column(name = "detalle_fatura_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name = "detalle_factura_item_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "detalle_factura_venta_id")
	private Factura factura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValor_unidad() {
		return valor_unidad;
	}

	public void setValor_unidad(BigDecimal valor_unidad) {
		this.valor_unidad = valor_unidad;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getItem() {
		return producto;
	}

	public void setItem(Producto item) {
		this.producto = item;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", valor_unidad=" + valor_unidad + ", subtotal="
				+ subtotal + "]";
	}
	
	
	
	

}
