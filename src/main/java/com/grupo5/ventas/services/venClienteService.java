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

import com.grupo5.ventas.repositories.venClienteRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCliente;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venClienteService {

	@Autowired
	venClienteRepository repo;

	public List<venCliente> getAll(){
		List<venCliente> venClienteList = repo.findAll();
		if(venClienteList.size() > 0) {
			return venClienteList;
		} else {
			return new ArrayList<venCliente>();
		}
	}
     		
	public venCliente findByIdCliente(Long idCliente) throws RecordNotFoundException{
		Optional<venCliente> venCliente = repo.findByIdCliente(idCliente);
		if(venCliente.isPresent()) {
			return venCliente.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venCliente createvenCliente(venCliente venCliente){
		return repo.save(venCliente);
	}

	public venCliente updatevenCliente(venCliente venCliente) throws RecordNotFoundException {
		Optional<venCliente> venClienteTemp = repo.findByIdCliente(venCliente.getIdCliente());
	
		if(venClienteTemp.isPresent()){
			return repo.save(venCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenClienteByIdCliente(Long idCliente) throws RecordNotFoundException{
		Optional<venCliente> venCliente = repo.findByIdCliente(idCliente);
		if(venCliente.isPresent()) {
		repo.deleteByIdCliente(idCliente);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
