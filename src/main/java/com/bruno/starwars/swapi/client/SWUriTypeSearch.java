package com.bruno.starwars.swapi.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SWUriTypeSearch {
	PLANETS("/planets"), PEOPLE("/people");

	private String uri;
}
