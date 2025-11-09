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

import com.grupo5.ventas.services.venUnidadItemService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venUnidadItem;

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
public class venUnidadItemController {
	@Autowired
	venUnidadItemService service;
	
	@GetMapping("/venUnidadItem")
	public ResponseEntity<List<venUnidadItem>> getAll() {
		List<venUnidadItem> list = service.getAll();
		return new ResponseEntity<List<venUnidadItem>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venUnidadItem/{id}")
	public ResponseEntity<venUnidadItem> getvenUnidadItemByIdUnidadItem(@PathVariable("id") Long idUnidadItem) throws RecordNotFoundException {
		venUnidadItem entity = service.findByIdUnidadItem(idUnidadItem);
		return new ResponseEntity<venUnidadItem>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venUnidadItem")
	public ResponseEntity<venUnidadItem> createvenUnidadItem(@RequestBody venUnidadItem venUnidadItem){
		service.createvenUnidadItem(venUnidadItem);
		return new ResponseEntity<venUnidadItem>(venUnidadItem, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venUnidadItem")
	public ResponseEntity<venUnidadItem> updatevenUnidadItem(@RequestBody venUnidadItem venUnidadItem) throws RecordNotFoundException{
		service.updatevenUnidadItem(venUnidadItem);
		return new ResponseEntity<venUnidadItem>(venUnidadItem, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venUnidadItem/{id}")
	public HttpStatus deletevenUnidadItemByIdUnidadItem(@PathVariable("id") Long idUnidadItem) throws RecordNotFoundException {
		service.deletevenUnidadItemByIdUnidadItem(idUnidadItem);
		return HttpStatus.OK;
	}
}				
