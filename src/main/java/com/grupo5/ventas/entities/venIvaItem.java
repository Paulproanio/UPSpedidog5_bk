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
@Table(name = "venIvaItem")
public class venIvaItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIvaItem;
	
	private Long valorIvaItem;
	
	public Long getIdIvaItem() {
		return idIvaItem;
	}
	
	public void setIdIvaItem(Long idIvaItem) {
		this.idIvaItem = idIvaItem;
	}
	
	public Long getValorIvaItem() {
		return valorIvaItem;
	}
	
	public void setValorIvaItem(Long valorIvaItem) {
		this.valorIvaItem = valorIvaItem;
	}
	
}
