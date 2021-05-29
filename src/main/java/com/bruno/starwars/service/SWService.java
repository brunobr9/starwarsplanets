package com.bruno.starwars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.starwars.swapi.client.SWApiClient;
import com.bruno.starwars.swapi.client.SWResponse;
import com.bruno.starwars.swapi.client.SWResult;
import com.bruno.starwars.swapi.client.SWUriTypeSearch;

@Service
public class SWService {

	@Autowired
	private SWApiClient swApiClient;

	public SWResponse getPlaneta(String nome) {
		return swApiClient.searchByNome(nome, SWUriTypeSearch.PLANETS);
	}

	public SWResponse getPessoa(String nome) {
		return swApiClient.searchByNome(nome, SWUriTypeSearch.PEOPLE);
	}

	public int getQtdFilmesPlaneta(String nome) {
		SWResult[] results = getPlaneta(nome).getResults();
		return results.length > 0 ? results[0].getFilms().length : 0;
	}
}
