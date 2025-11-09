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
@Table(name = "venDetallePedido")
public class venDetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetallePedido;
	
	@ManyToOne
	@JoinColumn(name="idPedido")
	private venCabeceraPedido venCabeceraPedido;
	
	private Long cantidadPedido;
	@ManyToOne
	@JoinColumn(name="idItem")
	private venItem venItem;
	
	public Long getIdDetallePedido() {
		return idDetallePedido;
	}
	
	public void setIdDetallePedido(Long idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	
	public Long getCantidadPedido() {
		return cantidadPedido;
	}
	
	public void setCantidadPedido(Long cantidadPedido) {
		this.cantidadPedido = cantidadPedido;
	}

	public venCabeceraPedido getVenCabeceraPedido() {
		return venCabeceraPedido;
	}

	public void setVenCabeceraPedido(venCabeceraPedido venCabeceraPedido) {
		this.venCabeceraPedido = venCabeceraPedido;
	}

	public venItem getVenItem() {
		return venItem;
	}

	public void setVenItem(venItem venItem) {
		this.venItem = venItem;
	}
}
