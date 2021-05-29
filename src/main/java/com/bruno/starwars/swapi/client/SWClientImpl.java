package com.bruno.starwars.swapi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SWClientImpl implements SWApiClient {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public SWResponse searchByNome(String nome, SWUriTypeSearch objectTypeSearch) {
		final String url = URL_BASE + objectTypeSearch.getUri() + URL_SUFIX;

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url).queryParam("search", nome);

		return restTemplate.exchange(uri.toUriString(), HttpMethod.GET, new HttpEntity<>(headers), SWResponse.class)
				.getBody();
	}

}
