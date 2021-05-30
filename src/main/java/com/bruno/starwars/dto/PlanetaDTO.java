package com.bruno.starwars.dto;

import com.bruno.starwars.domain.Planeta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PlanetaDTO implements IdEntityDTO<String> {

	private static final long serialVersionUID = 1L;

	private String id;
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
