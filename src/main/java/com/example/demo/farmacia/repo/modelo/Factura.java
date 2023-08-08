package com.example.demo.farmacia.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {
	

	@Id
	@Column(name = "fatura_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fatura_id_seq")
	@SequenceGenerator(name = "atura_id_seq", sequenceName = "fatura_id_seq", allocationSize = 1)
	private Integer id;
	
	
	@Column(name = "fatura_fecha")
	private LocalDate fecha;
	@Column(name = "fatura_cedula")
	private String cedula;
	@Column(name = "fatura_factura")
	private BigDecimal totalFactura;
	
	@OneToMany(mappedBy = "venta",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DetalleFactura> detallesFactura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public BigDecimal getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(BigDecimal totalFactura) {
		this.totalFactura = totalFactura;
	}

	public List<DetalleFactura> getDetallesFactura() {
		return detallesFactura;
	}

	public void setDetallesFactura(List<DetalleFactura> detallesFactura) {
		this.detallesFactura = detallesFactura;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", cedula=" + cedula + ", totalFactura=" + totalFactura + "]";
	}
	
	
	
	
	
	
	
	

	
	

}
