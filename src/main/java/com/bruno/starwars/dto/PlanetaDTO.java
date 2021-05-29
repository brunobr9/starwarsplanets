package com.bruno.starwars.dto;

import com.bruno.starwars.domain.Planeta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PlanetaDTO implements IdEntityDTO<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String clima;
	private String terreno;
	private int qtdFilmes;

	public PlanetaDTO(Planeta planeta) {
		this.id = planeta.getId();
		this.nome = planeta.getNome();
		this.clima = planeta.getClima();
		this.terreno = planeta.getTerreno();
	}
}
