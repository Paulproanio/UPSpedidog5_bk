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

import com.grupo5.ventas.services.venCiudadService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCiudad;

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
public class venCiudadController {
	@Autowired
	venCiudadService service;
	
	@GetMapping("/venCiudad")
	public ResponseEntity<List<venCiudad>> getAll() {
		List<venCiudad> list = service.getAll();
		return new ResponseEntity<List<venCiudad>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venCiudad/{id}")
	public ResponseEntity<venCiudad> getvenCiudadByIdCiudad(@PathVariable("id") Long idCiudad) throws RecordNotFoundException {
		venCiudad entity = service.findByIdCiudad(idCiudad);
		return new ResponseEntity<venCiudad>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venCiudad")
	public ResponseEntity<venCiudad> createvenCiudad(@RequestBody venCiudad venCiudad){
		service.createvenCiudad(venCiudad);
		return new ResponseEntity<venCiudad>(venCiudad, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venCiudad")
	public ResponseEntity<venCiudad> updatevenCiudad(@RequestBody venCiudad venCiudad) throws RecordNotFoundException{
		service.updatevenCiudad(venCiudad);
		return new ResponseEntity<venCiudad>(venCiudad, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venCiudad/{id}")
	public HttpStatus deletevenCiudadByIdCiudad(@PathVariable("id") Long idCiudad) throws RecordNotFoundException {
		service.deletevenCiudadByIdCiudad(idCiudad);
		return HttpStatus.OK;
	}
}				
