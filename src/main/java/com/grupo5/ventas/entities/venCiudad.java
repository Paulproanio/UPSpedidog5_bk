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
@Table(name = "venCiudad_table")
public class venCiudad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCiudad;
	
	private String nombreCiudad;
	
	public Long getIdCiudad() {
		return idCiudad;
	}
	
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	
}
