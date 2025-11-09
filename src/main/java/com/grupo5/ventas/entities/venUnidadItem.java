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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
	
@Entity
@Table(name = "venUnidadItem")
public class venUnidadItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUnidadItem;
	
	private String nombreUnidadItem;
	
	public Long getIdUnidadItem() {
		return idUnidadItem;
	}
	
	public void setIdUnidadItem(Long idUnidadItem) {
		this.idUnidadItem = idUnidadItem;
	}
	
	public String getNombreUnidadItem() {
		return nombreUnidadItem;
	}
	
	public void setNombreUnidadItem(String nombreUnidadItem) {
		this.nombreUnidadItem = nombreUnidadItem;
	}
	
}
