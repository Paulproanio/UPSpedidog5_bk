																/*
 -------------------------------------------------------------------
|
| PATRONES DE DISEÑO DE API'S
| UNIVERSIDAD POLITECNICA SALESIANA
| Author: FABRICIO BORJA, JHON LLIVICOTA, KEVIN JAPA, PAUL PROAÑO (2025)
| File Date: Sat November 08 22:55:27 ECT 2025
| 
 -------------------------------------------------------------------
																*/
package com.grupo5.ventas.entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "venItem")
public class venItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItem;
	private Double precioItem;
	private String nombreItem;
	
	
	@ManyToOne
	@JoinColumn(name="idUnidadItem")
	private venUnidadItem venUnidadItem;
	
	@ManyToOne
	@JoinColumn(name="idIvaItem")
	private venIvaItem venIvaItem;
	
	
	public Long getIdItem() {
		return idItem;
	}
	
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	
	public String getNombreItem() {
		return nombreItem;
	}
	
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}

	public venUnidadItem getVenUnidadItem() {
		return venUnidadItem;
	}

	public void setVenUnidadItem(venUnidadItem venUnidadItem) {
		this.venUnidadItem = venUnidadItem;
	}

	public venIvaItem getVenIvaItem() {
		return venIvaItem;
	}

	public void setVenIvaItem(venIvaItem venIvaItem) {
		this.venIvaItem = venIvaItem;
	}

	public Double getPrecioItem() {
		return precioItem;
	}

	public void setPrecioItem(Double precioItem) {
		this.precioItem = precioItem;
	}

}
