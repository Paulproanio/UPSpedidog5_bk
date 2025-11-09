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

import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venDetallePedido;
import com.grupo5.ventas.repositories.venDetallePedidoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venDetallePedidoService {

	@Autowired
	venDetallePedidoRepository repo;

	public List<venDetallePedido> getAll(){
		List<venDetallePedido> venDetallePedidoList = repo.findAll();
		if(venDetallePedidoList.size() > 0) {
			return venDetallePedidoList;
		} else {
			return new ArrayList<venDetallePedido>();
		}
	}
     		
	public venDetallePedido findByIdDetallePedido(Long idDetallePedido) throws RecordNotFoundException{
		Optional<venDetallePedido> venDetallePedido = repo.findByIdDetallePedido(idDetallePedido);
		if(venDetallePedido.isPresent()) {
			return venDetallePedido.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venDetallePedido createvenDetallePedido(venDetallePedido venDetallePedido){
		return repo.save(venDetallePedido);
	}

	public venDetallePedido updatevenDetallePedido(venDetallePedido venDetallePedido) throws RecordNotFoundException {
		Optional<venDetallePedido> venDetallePedidoTemp = repo.findByIdDetallePedido(venDetallePedido.getIdDetallePedido());
	
		if(venDetallePedidoTemp.isPresent()){
			return repo.save(venDetallePedido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenDetallePedidoByIdDetallePedido(Long idDetallePedido) throws RecordNotFoundException{
		Optional<venDetallePedido> venDetallePedido = repo.findByIdDetallePedido(idDetallePedido);
		if(venDetallePedido.isPresent()) {
		repo.deleteByIdDetallePedido(idDetallePedido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
