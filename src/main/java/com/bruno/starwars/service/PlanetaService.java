package com.bruno.starwars.service;

import java.util.List;
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
public class PlanetaService extends AbstractCrudService<Planeta, String> {

	@Autowired
	private PlanetaRepository planetaRepository;

	@Autowired
	private SWService swService;

	private void fillQtdFilmes(Planeta planeta) {
		planeta.setQtdFilmes(swService.getQtdFilmesPlaneta(planeta.getNome()));
	}

	public Planeta findByNome(String nome) throws ServiceException {
		Optional<Planeta> objeto = Optional.ofNullable(planetaRepository.findByNomeIgnoringCase(nome));
		Planeta planeta = objeto.orElseThrow(() -> new ObjectNotFoundException(nome, Planeta.class.getName()));
		fillQtdFilmes(planeta);

		return planeta;
	}

	@Override
	public List<Planeta> findAll() {
		List<Planeta> planetas = super.findAll();
		planetas.forEach(this::fillQtdFilmes);
		return planetas;
	}

	@Override
	public Planeta findById(String id) throws ServiceException {
		Planeta planeta = super.findById(id);
		fillQtdFilmes(planeta);
		return planeta;
	}

	@Override
	public Planeta insert(Planeta planeta) throws ServiceException {
		Planeta planetaDB = planetaRepository.findByNomeIgnoringCase(planeta.getNome());
		if (planetaDB != null) {
			throw new ServiceException("Planeta de nome " + planetaDB.getNome().toUpperCase() + " já existe.");
		}

		fillQtdFilmes(planeta);

		return super.insert(planeta);
	}
}
