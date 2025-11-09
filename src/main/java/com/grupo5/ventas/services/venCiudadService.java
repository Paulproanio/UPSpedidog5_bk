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
package com.grupo5.ventas.services;

import com.grupo5.ventas.repositories.venCiudadRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCiudad;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venCiudadService {

	@Autowired
	venCiudadRepository repo;

	public List<venCiudad> getAll(){
		List<venCiudad> venCiudadList = repo.findAll();
		if(venCiudadList.size() > 0) {
			return venCiudadList;
		} else {
			return new ArrayList<venCiudad>();
		}
	}
     		
	public venCiudad findByIdCiudad(Long idCiudad) throws RecordNotFoundException{
		Optional<venCiudad> venCiudad = repo.findByIdCiudad(idCiudad);
		if(venCiudad.isPresent()) {
			return venCiudad.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venCiudad createvenCiudad(venCiudad venCiudad){
		return repo.save(venCiudad);
	}

	public venCiudad updatevenCiudad(venCiudad venCiudad) throws RecordNotFoundException {
		Optional<venCiudad> venCiudadTemp = repo.findByIdCiudad(venCiudad.getIdCiudad());
	
		if(venCiudadTemp.isPresent()){
			return repo.save(venCiudad);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenCiudadByIdCiudad(Long idCiudad) throws RecordNotFoundException{
		Optional<venCiudad> venCiudad = repo.findByIdCiudad(idCiudad);
		if(venCiudad.isPresent()) {
		repo.deleteByIdCiudad(idCiudad);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
