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

import com.grupo5.ventas.repositories.venItemRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venItem;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venItemService {

	@Autowired
	venItemRepository repo;

	public List<venItem> getAll(){
		List<venItem> venItemList = repo.findAll();
		if(venItemList.size() > 0) {
			return venItemList;
		} else {
			return new ArrayList<venItem>();
		}
	}
     		
	public venItem findByIdItem(Long idItem) throws RecordNotFoundException{
		Optional<venItem> venItem = repo.findByIdItem(idItem);
		if(venItem.isPresent()) {
			return venItem.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venItem createvenItem(venItem venItem){
		return repo.save(venItem);
	}

	public venItem updatevenItem(venItem venItem) throws RecordNotFoundException {
		Optional<venItem> venItemTemp = repo.findByIdItem(venItem.getIdItem());
	
		if(venItemTemp.isPresent()){
			return repo.save(venItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenItemByIdItem(Long idItem) throws RecordNotFoundException{
		Optional<venItem> venItem = repo.findByIdItem(idItem);
		if(venItem.isPresent()) {
		repo.deleteByIdItem(idItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
