package com.co.compras.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDetalleVenta;
	
	@ManyToOne
    @JsonIgnoreProperties(value = "venta", allowSetters = true)
	private Venta venta;
	
    @ManyToOne
    @JsonIgnoreProperties(value = "producto", allowSetters = true)
    private Producto producto;

	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
    
}
