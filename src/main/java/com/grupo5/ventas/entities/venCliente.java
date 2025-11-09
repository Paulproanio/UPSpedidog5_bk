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
@Table(name = "venCliente")
public class venCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	private String nombreCliente;
	private String direccionCliente;
	private String correoCliente;
	private String telefonoCliente;
	private String rucCliente;
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	public String getCorreoCliente() {
		return correoCliente;
	}
	
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	public String getRucCliente() {
		return rucCliente;
	}
	
	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}
	
}
