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
package com.grupo5.ventas.services;

import com.grupo5.ventas.repositories.genUsuarioRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.genUsuario;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class genUsuarioService {

	@Autowired
	genUsuarioRepository repo;

	public List<genUsuario> getAll(){
		List<genUsuario> genUsuarioList = repo.findAll();
		if(genUsuarioList.size() > 0) {
			return genUsuarioList;
		} else {
			return new ArrayList<genUsuario>();
		}
	}
     		
	public genUsuario findByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<genUsuario> genUsuario = repo.findByIdUsuario(idUsuario);
		if(genUsuario.isPresent()) {
			return genUsuario.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public genUsuario creategenUsuario(genUsuario genUsuario){
		return repo.save(genUsuario);
	}

	public genUsuario updategenUsuario(genUsuario genUsuario) throws RecordNotFoundException {
		Optional<genUsuario> genUsuarioTemp = repo.findByIdUsuario(genUsuario.getIdUsuario());
	
		if(genUsuarioTemp.isPresent()){
			return repo.save(genUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletegenUsuarioByIdUsuario(Long idUsuario) throws RecordNotFoundException{
		Optional<genUsuario> genUsuario = repo.findByIdUsuario(idUsuario);
		if(genUsuario.isPresent()) {
		repo.deleteByIdUsuario(idUsuario);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
