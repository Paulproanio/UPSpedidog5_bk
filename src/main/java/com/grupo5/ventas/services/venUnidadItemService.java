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

import com.grupo5.ventas.repositories.venUnidadItemRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venUnidadItem;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venUnidadItemService {

	@Autowired
	venUnidadItemRepository repo;

	public List<venUnidadItem> getAll(){
		List<venUnidadItem> venUnidadItemList = repo.findAll();
		if(venUnidadItemList.size() > 0) {
			return venUnidadItemList;
		} else {
			return new ArrayList<venUnidadItem>();
		}
	}
     		
	public venUnidadItem findByIdUnidadItem(Long idUnidadItem) throws RecordNotFoundException{
		Optional<venUnidadItem> venUnidadItem = repo.findByIdUnidadItem(idUnidadItem);
		if(venUnidadItem.isPresent()) {
			return venUnidadItem.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venUnidadItem createvenUnidadItem(venUnidadItem venUnidadItem){
		return repo.save(venUnidadItem);
	}

	public venUnidadItem updatevenUnidadItem(venUnidadItem venUnidadItem) throws RecordNotFoundException {
		Optional<venUnidadItem> venUnidadItemTemp = repo.findByIdUnidadItem(venUnidadItem.getIdUnidadItem());
	
		if(venUnidadItemTemp.isPresent()){
			return repo.save(venUnidadItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenUnidadItemByIdUnidadItem(Long idUnidadItem) throws RecordNotFoundException{
		Optional<venUnidadItem> venUnidadItem = repo.findByIdUnidadItem(idUnidadItem);
		if(venUnidadItem.isPresent()) {
		repo.deleteByIdUnidadItem(idUnidadItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
