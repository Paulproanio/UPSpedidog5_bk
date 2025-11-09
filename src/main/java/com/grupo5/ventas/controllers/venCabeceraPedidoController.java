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
package com.grupo5.ventas.controllers;

import com.grupo5.ventas.services.venCabeceraPedidoService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCabeceraPedido;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class venCabeceraPedidoController {
	@Autowired
	venCabeceraPedidoService service;
	
	@GetMapping("/venCabeceraPedido")
	public ResponseEntity<List<venCabeceraPedido>> getAll() {
		List<venCabeceraPedido> list = service.getAll();
		return new ResponseEntity<List<venCabeceraPedido>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venCabeceraPedido/{id}")
	public ResponseEntity<venCabeceraPedido> getvenCabeceraPedidoByIdPedido(@PathVariable("id") Long idPedido) throws RecordNotFoundException {
		venCabeceraPedido entity = service.findByIdPedido(idPedido);
		return new ResponseEntity<venCabeceraPedido>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venCabeceraPedido")
	public ResponseEntity<venCabeceraPedido> createvenCabeceraPedido(@RequestBody venCabeceraPedido venCabeceraPedido){
		service.createvenCabeceraPedido(venCabeceraPedido);
		return new ResponseEntity<venCabeceraPedido>(venCabeceraPedido, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venCabeceraPedido")
	public ResponseEntity<venCabeceraPedido> updatevenCabeceraPedido(@RequestBody venCabeceraPedido venCabeceraPedido) throws RecordNotFoundException{
		service.updatevenCabeceraPedido(venCabeceraPedido);
		return new ResponseEntity<venCabeceraPedido>(venCabeceraPedido, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venCabeceraPedido/{id}")
	public HttpStatus deletevenCabeceraPedidoByIdPedido(@PathVariable("id") Long idPedido) throws RecordNotFoundException {
		service.deletevenCabeceraPedidoByIdPedido(idPedido);
		return HttpStatus.OK;
	}
}				
