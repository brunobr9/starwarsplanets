package com.bruno.starwars.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bruno.starwars.dto.PlanetaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Planeta")
public class Planeta implements IdEntity<String> {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String nome;

	private String clima;

	private String terreno;

	public Planeta(PlanetaDTO dto) {
		this.nome = dto.getNome();
		this.clima = dto.getClima();
		this.terreno = dto.getTerreno();
	}

	public Planeta(PlanetaDTO dto, String id) {
		this(dto);
		this.id = id;
	}
}
