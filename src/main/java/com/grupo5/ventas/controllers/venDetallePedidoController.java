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

import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venDetallePedido;
import com.grupo5.ventas.services.venDetallePedidoService;

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
public class venDetallePedidoController {
	@Autowired
	venDetallePedidoService service;
	
	@GetMapping("/venDetallePedido")
	public ResponseEntity<List<venDetallePedido>> getAll() {
		List<venDetallePedido> list = service.getAll();
		return new ResponseEntity<List<venDetallePedido>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venDetallePedido/{id}")
	public ResponseEntity<venDetallePedido> getvenDetallePedidoByIdDetallePedido(@PathVariable("id") Long idDetallePedido) throws RecordNotFoundException {
		venDetallePedido entity = service.findByIdDetallePedido(idDetallePedido);
		return new ResponseEntity<venDetallePedido>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venDetallePedido")
	public ResponseEntity<venDetallePedido> createvenDetallePedido(@RequestBody venDetallePedido venDetallePedido){
		service.createvenDetallePedido(venDetallePedido);
		return new ResponseEntity<venDetallePedido>(venDetallePedido, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venDetallePedido")
	public ResponseEntity<venDetallePedido> updatevenDetallePedido(@RequestBody venDetallePedido venDetallePedido) throws RecordNotFoundException{
		service.updatevenDetallePedido(venDetallePedido);
		return new ResponseEntity<venDetallePedido>(venDetallePedido, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venDetallePedido/{id}")
	public HttpStatus deletevenDetallePedidoByIdDetallePedido(@PathVariable("id") Long idDetallePedido) throws RecordNotFoundException {
		service.deletevenDetallePedidoByIdDetallePedido(idDetallePedido);
		return HttpStatus.OK;
	}
}				
