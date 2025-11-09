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

import com.grupo5.ventas.services.venItemService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venItem;

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
public class venItemController {
	@Autowired
	venItemService service;
	
	@GetMapping("/venItem")
	public ResponseEntity<List<venItem>> getAll() {
		List<venItem> list = service.getAll();
		return new ResponseEntity<List<venItem>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venItem/{id}")
	public ResponseEntity<venItem> getvenItemByIdItem(@PathVariable("id") Long idItem) throws RecordNotFoundException {
		venItem entity = service.findByIdItem(idItem);
		return new ResponseEntity<venItem>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venItem")
	public ResponseEntity<venItem> createvenItem(@RequestBody venItem venItem){
		service.createvenItem(venItem);
		return new ResponseEntity<venItem>(venItem, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venItem")
	public ResponseEntity<venItem> updatevenItem(@RequestBody venItem venItem) throws RecordNotFoundException{
		service.updatevenItem(venItem);
		return new ResponseEntity<venItem>(venItem, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venItem/{id}")
	public HttpStatus deletevenItemByIdItem(@PathVariable("id") Long idItem) throws RecordNotFoundException {
		service.deletevenItemByIdItem(idItem);
		return HttpStatus.OK;
	}
}				
