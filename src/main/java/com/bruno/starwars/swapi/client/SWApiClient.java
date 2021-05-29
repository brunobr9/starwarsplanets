package com.bruno.starwars.swapi.client;

public interface SWApiClient {

	String URL_BASE = "https://swapi.dev/api";
	String URL_SUFIX = "/";

	/**
	 * Realiza uma busca por nome da api https://swapi.dev/
	 * 
	 * @param nome          parametro de busca nome
	 * @param uriTypeSearch indica a uri tipo de objeto a ser buscado na api
	 * @return objeto de resposta da swapi
	 */
	SWResponse searchByNome(String nome, SWUriTypeSearch uriTypeSearch);
}
