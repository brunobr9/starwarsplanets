package com.bruno.starwars.swapi.client;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SWResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String[] films;

}
