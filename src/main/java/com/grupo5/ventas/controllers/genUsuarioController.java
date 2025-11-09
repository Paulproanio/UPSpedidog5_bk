																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Sun Nov 09 13:23:46 ECT 2025
| 
 -------------------------------------------------------------------
																*/
package com.grupo5.ventas.controllers;

import com.grupo5.ventas.services.genUsuarioService;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.genUsuario;

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
public class genUsuarioController {
	@Autowired
	genUsuarioService service;
	
	@GetMapping("/genUsuario")
	public ResponseEntity<List<genUsuario>> getAll() {
		List<genUsuario> list = service.getAll();
		return new ResponseEntity<List<genUsuario>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/genUsuario/{id}")
	public ResponseEntity<genUsuario> getgenUsuarioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		genUsuario entity = service.findByIdUsuario(idUsuario);
		return new ResponseEntity<genUsuario>(entity, new HttpHeaders(), HttpStatus.OK);
	}



	@PostMapping("/genUsuario")
	public ResponseEntity<genUsuario> creategenUsuario(@RequestBody genUsuario genUsuario){
		service.creategenUsuario(genUsuario);
		return new ResponseEntity<genUsuario>(genUsuario, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/genUsuario")
	public ResponseEntity<genUsuario> updategenUsuario(@RequestBody genUsuario genUsuario) throws RecordNotFoundException{
		service.updategenUsuario(genUsuario);
		return new ResponseEntity<genUsuario>(genUsuario, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/genUsuario/{id}")
	public HttpStatus deletegenUsuarioByIdUsuario(@PathVariable("id") Long idUsuario) throws RecordNotFoundException {
		service.deletegenUsuarioByIdUsuario(idUsuario);
		return HttpStatus.OK;
	}
}				
