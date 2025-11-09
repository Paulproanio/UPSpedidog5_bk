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

import com.grupo5.ventas.repositories.venCabeceraPedidoRepository;
import com.grupo5.ventas.RecordNotFoundException;
import com.grupo5.ventas.entities.venCabeceraPedido;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class venCabeceraPedidoService {

	@Autowired
	venCabeceraPedidoRepository repo;

	public List<venCabeceraPedido> getAll(){
		List<venCabeceraPedido> venCabeceraPedidoList = repo.findAll();
		if(venCabeceraPedidoList.size() > 0) {
			return venCabeceraPedidoList;
		} else {
			return new ArrayList<venCabeceraPedido>();
		}
	}
     		
	public venCabeceraPedido findByIdPedido(Long idPedido) throws RecordNotFoundException{
		Optional<venCabeceraPedido> venCabeceraPedido = repo.findByIdPedido(idPedido);
		if(venCabeceraPedido.isPresent()) {
			return venCabeceraPedido.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public venCabeceraPedido createvenCabeceraPedido(venCabeceraPedido venCabeceraPedido){
		return repo.save(venCabeceraPedido);
	}

	public venCabeceraPedido updatevenCabeceraPedido(venCabeceraPedido venCabeceraPedido) throws RecordNotFoundException {
		Optional<venCabeceraPedido> venCabeceraPedidoTemp = repo.findByIdPedido(venCabeceraPedido.getIdPedido());
	
		if(venCabeceraPedidoTemp.isPresent()){
			return repo.save(venCabeceraPedido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletevenCabeceraPedidoByIdPedido(Long idPedido) throws RecordNotFoundException{
		Optional<venCabeceraPedido> venCabeceraPedido = repo.findByIdPedido(idPedido);
		if(venCabeceraPedido.isPresent()) {
		repo.deleteByIdPedido(idPedido);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
