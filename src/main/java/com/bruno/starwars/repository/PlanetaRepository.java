package com.bruno.starwars.repository;

import org.springframework.stereotype.Repository;

import com.bruno.starwars.domain.Planeta;

/**
 * Repositorio de operações de CRUD para planeta
 * 
 * @author Bruno
 *
 */
@Repository
public interface PlanetaRepository extends RepositoryInterface<Planeta, String> {

	Planeta findByNomeIgnoringCase(String nome);
}
