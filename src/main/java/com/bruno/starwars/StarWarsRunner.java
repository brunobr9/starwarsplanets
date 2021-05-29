package com.bruno.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bruno.starwars.domain.Planeta;
import com.bruno.starwars.service.PlanetaService;

@Component
public class StarWarsRunner implements CommandLineRunner {

	@Autowired
	private PlanetaService planetaService;

	@Override
	public void run(String... args) throws Exception {

		planetaService.insert(Planeta.builder().nome("Tatooine").clima("Arid").terreno("Dessert").build());
		planetaService.insert(Planeta.builder().nome("Marte").clima("Arid").terreno("Dessert").build());
		planetaService.insert(Planeta.builder().nome("Jupter").clima("Arid").terreno("Dessert").build());

	}

}
