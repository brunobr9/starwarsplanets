package com.bruno.starwars.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bruno.starwars.dto.PlanetaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Planeta implements IdEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String clima;

	@Column(nullable = false)
	private String terreno;

	public Planeta(PlanetaDTO dto) {
		this.nome = dto.getNome();
		this.clima = dto.getClima();
		this.terreno = dto.getTerreno();
	}

	public Planeta(PlanetaDTO dto, Long id) {
		this(dto);
		this.id = id;
	}
}
