package com.bruno.starwars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.starwars.domain.Planeta;
import com.bruno.starwars.repository.PlanetaRepository;
import com.bruno.starwars.service.exception.ObjectNotFoundException;
import com.bruno.starwars.service.exception.ServiceException;

/**
 * Service que acessa o repositório de Planeta.
 * 
 * @author Bruno
 *
 */
@Service
public class PlanetaService extends AbstractCrudService<Planeta, Long> {

	@Autowired
	private PlanetaRepository planetaRepository;

	public Planeta findByNome(String nome) throws ServiceException {
		Optional<Planeta> objeto = Optional.ofNullable(planetaRepository.findByNomeIgnoringCase(nome));

		return objeto.orElseThrow(() -> new ObjectNotFoundException(nome, Planeta.class.getName()));
	}

}
