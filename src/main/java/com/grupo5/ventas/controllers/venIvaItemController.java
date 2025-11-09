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

import com.grupo5.ventas.services.venIvaItemService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venIvaItem;

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
public class venIvaItemController {
	@Autowired
	venIvaItemService service;
	
	@GetMapping("/venIvaItem")
	public ResponseEntity<List<venIvaItem>> getAll() {
		List<venIvaItem> list = service.getAll();
		return new ResponseEntity<List<venIvaItem>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/venIvaItem/{id}")
	public ResponseEntity<venIvaItem> getvenIvaItemByIdIvaItem(@PathVariable("id") Long idIvaItem) throws RecordNotFoundException {
		venIvaItem entity = service.findByIdIvaItem(idIvaItem);
		return new ResponseEntity<venIvaItem>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/venIvaItem")
	public ResponseEntity<venIvaItem> createvenIvaItem(@RequestBody venIvaItem venIvaItem){
		service.createvenIvaItem(venIvaItem);
		return new ResponseEntity<venIvaItem>(venIvaItem, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/venIvaItem")
	public ResponseEntity<venIvaItem> updatevenIvaItem(@RequestBody venIvaItem venIvaItem) throws RecordNotFoundException{
		service.updatevenIvaItem(venIvaItem);
		return new ResponseEntity<venIvaItem>(venIvaItem, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/venIvaItem/{id}")
	public HttpStatus deletevenIvaItemByIdIvaItem(@PathVariable("id") Long idIvaItem) throws RecordNotFoundException {
		service.deletevenIvaItemByIdIvaItem(idIvaItem);
		return HttpStatus.OK;
	}
}				
