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
package com.grupo5.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo5.ventas.entities.venItem;

import java.util.Optional;

@Repository
public interface venItemRepository extends JpaRepository<venItem, Long> {

	Optional <venItem> findByIdItem(Long idItem);
	
	void deleteByIdItem(Long idItem);
	
}
