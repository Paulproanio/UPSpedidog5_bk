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
import java.sql.Date;
import javax.persistence.Basic;
	
@Entity
@Table(name = "venCabeceraPedido")
public class venCabeceraPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	@Basic
	private Date fechaPedido;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private venCliente venCliente;
	
	@ManyToOne
	@JoinColumn(name="idCiudad")
	private venCiudad venCiudad;
	
	public Long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
	public Date getFechaPedido() {
		return fechaPedido;
	}
	
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public venCliente getVenCliente() {
		return venCliente;
	}

	public void setVenCliente(venCliente venCliente) {
		this.venCliente = venCliente;
	}

	public venCiudad getVenCiudad() {
		return venCiudad;
	}

	public void setVenCiudad(venCiudad venCiudad) {
		this.venCiudad = venCiudad;
	}
}
