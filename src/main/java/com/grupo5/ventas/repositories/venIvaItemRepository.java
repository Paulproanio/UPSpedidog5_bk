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

import com.grupo5.ventas.entities.venIvaItem;

import java.util.Optional;

@Repository
public interface venIvaItemRepository extends JpaRepository<venIvaItem, Long> {

	Optional <venIvaItem> findByIdIvaItem(Long idIvaItem);
	
	void deleteByIdIvaItem(Long idIvaItem);
	
}
