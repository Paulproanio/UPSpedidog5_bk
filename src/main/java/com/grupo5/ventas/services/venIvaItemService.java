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

import com.grupo5.ventas.repositories.venIvaItemRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venIvaItem;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venIvaItemService {

	@Autowired
	venIvaItemRepository repo;

	public List<venIvaItem> getAll(){
		List<venIvaItem> venIvaItemList = repo.findAll();
		if(venIvaItemList.size() > 0) {
			return venIvaItemList;
		} else {
			return new ArrayList<venIvaItem>();
		}
	}
     		
	public venIvaItem findByIdIvaItem(Long idIvaItem) throws RecordNotFoundException{
		Optional<venIvaItem> venIvaItem = repo.findByIdIvaItem(idIvaItem);
		if(venIvaItem.isPresent()) {
			return venIvaItem.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venIvaItem createvenIvaItem(venIvaItem venIvaItem){
		return repo.save(venIvaItem);
	}

	public venIvaItem updatevenIvaItem(venIvaItem venIvaItem) throws RecordNotFoundException {
		Optional<venIvaItem> venIvaItemTemp = repo.findByIdIvaItem(venIvaItem.getIdIvaItem());
	
		if(venIvaItemTemp.isPresent()){
			return repo.save(venIvaItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenIvaItemByIdIvaItem(Long idIvaItem) throws RecordNotFoundException{
		Optional<venIvaItem> venIvaItem = repo.findByIdIvaItem(idIvaItem);
		if(venIvaItem.isPresent()) {
		repo.deleteByIdIvaItem(idIvaItem);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
