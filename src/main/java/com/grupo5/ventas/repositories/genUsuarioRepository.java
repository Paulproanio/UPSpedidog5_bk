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
package com.grupo5.ventas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo5.ventas.entities.genUsuario;

import java.util.Optional;

@Repository
public interface genUsuarioRepository extends JpaRepository<genUsuario, Long> {

	Optional <genUsuario> findByIdUsuario(Long idUsuario);
	
	void deleteByIdUsuario(Long idUsuario);
	
}
