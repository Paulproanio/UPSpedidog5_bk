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

import com.grupo5.ventas.services.venClienteService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCliente;

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
public class venClienteController {
	@Autowired
	venClienteService service;
	
	@GetMapping("/venCliente")
	public ResponseEntity<List<venCliente>> getAll() {
		List<venCliente> list = service.getAll();
		return new ResponseEntity<List<venCliente>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venCliente/{id}")
	public ResponseEntity<venCliente> getvenClienteByIdCliente(@PathVariable("id") Long idCliente) throws RecordNotFoundException {
		venCliente entity = service.findByIdCliente(idCliente);
		return new ResponseEntity<venCliente>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venCliente")
	public ResponseEntity<venCliente> createvenCliente(@RequestBody venCliente venCliente){
		service.createvenCliente(venCliente);
		return new ResponseEntity<venCliente>(venCliente, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venCliente")
	public ResponseEntity<venCliente> updatevenCliente(@RequestBody venCliente venCliente) throws RecordNotFoundException{
		service.updatevenCliente(venCliente);
		return new ResponseEntity<venCliente>(venCliente, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venCliente/{id}")
	public HttpStatus deletevenClienteByIdCliente(@PathVariable("id") Long idCliente) throws RecordNotFoundException {
		service.deletevenClienteByIdCliente(idCliente);
		return HttpStatus.OK;
	}
}				
