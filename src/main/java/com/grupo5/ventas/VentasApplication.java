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
package com.grupo5.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class VentasApplication {
	public static void main(String[] args) {
		SpringApplication.run(VentasApplication.class, args);
		System.out.println("Active resources for venCabeceraPedido entity");
		System.out.println("GET");
		System.out.println("/api/v1/venCabeceraPedido");
		System.out.println("/api/v1/venCabeceraPedido/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venCabeceraPedido");
		System.out.println("PUT");
		System.out.println("/api/v1/venCabeceraPedido");
		System.out.println("DELETE");
		System.out.println("/api/v1/venCabeceraPedido/{id}");
		System.out.println("Active resources for venItem entity");
		System.out.println("GET");
		System.out.println("/api/v1/venItem");
		System.out.println("/api/v1/venItem/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venItem");
		System.out.println("PUT");
		System.out.println("/api/v1/venItem");
		System.out.println("DELETE");
		System.out.println("/api/v1/venItem/{id}");
		System.out.println("Active resources for venCliente entity");
		System.out.println("GET");
		System.out.println("/api/v1/venCliente");
		System.out.println("/api/v1/venCliente/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venCliente");
		System.out.println("PUT");
		System.out.println("/api/v1/venCliente");
		System.out.println("DELETE");
		System.out.println("/api/v1/venCliente/{id}");
		System.out.println("Active resources for venCiudad entity");
		System.out.println("GET");
		System.out.println("/api/v1/venCiudad");
		System.out.println("/api/v1/venCiudad/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venCiudad");
		System.out.println("PUT");
		System.out.println("/api/v1/venCiudad");
		System.out.println("DELETE");
		System.out.println("/api/v1/venCiudad/{id}");
		System.out.println("Active resources for venUnidadItem entity");
		System.out.println("GET");
		System.out.println("/api/v1/venUnidadItem");
		System.out.println("/api/v1/venUnidadItem/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venUnidadItem");
		System.out.println("PUT");
		System.out.println("/api/v1/venUnidadItem");
		System.out.println("DELETE");
		System.out.println("/api/v1/venUnidadItem/{id}");
		System.out.println("Active resources for venIvaItem entity");
		System.out.println("GET");
		System.out.println("/api/v1/venIvaItem");
		System.out.println("/api/v1/venIvaItem/{id}");
		System.out.println("POST");
		System.out.println("/api/v1/venIvaItem");
		System.out.println("PUT");
		System.out.println("/api/v1/venIvaItem");
		System.out.println("DELETE");
		System.out.println("/api/v1/venIvaItem/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
