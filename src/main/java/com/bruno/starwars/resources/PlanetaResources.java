package com.bruno.starwars.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.starwars.domain.Planeta;
import com.bruno.starwars.dto.PlanetaDTO;
import com.bruno.starwars.service.PlanetaService;
import com.bruno.starwars.service.SWService;
import com.bruno.starwars.service.exception.ServiceException;

@RestController
@RequestMapping("/planeta")
public class PlanetaResources implements ApiCrudResources<PlanetaDTO, String> {

	@Autowired
	private PlanetaService planetaService;

	@Autowired
	private SWService swService;

	@Override
	public ResponseEntity<PlanetaDTO> insert(PlanetaDTO dto) throws ServiceException {
		return ResponseEntityUtil.created(planetaService.insert(new Planeta(dto)));
	}

	@Override
	public ResponseEntity<Void> update(PlanetaDTO dto, String id) throws ServiceException {
		planetaService.update(new Planeta(dto, id.toString()));
		return ResponseEntityUtil.noContent();
	}

	@Override
	public ResponseEntity<PlanetaDTO> find(String id) throws ServiceException {
		return ResponseEntityUtil.find(planetaService.findById(id), PlanetaDTO::new);
	}

	@Override
	public ResponseEntity<List<PlanetaDTO>> findAll() {
		return ResponseEntityUtil.list(planetaService.findAll(), PlanetaDTO::new);
	}

	@GetMapping
	public ResponseEntity<PlanetaDTO> findBy(@RequestParam(value = "nome") String nome) throws ServiceException {
		ResponseEntity<PlanetaDTO> responseEntity = ResponseEntityUtil.find(planetaService.findByNome(nome),
				PlanetaDTO::new);

		PlanetaDTO planetaDTO = responseEntity != null ? responseEntity.getBody() : null;

		if (planetaDTO != null) {
			planetaDTO.setQtdFilmes(swService.getQtdFilmesPlaneta(nome));
		}

		return responseEntity;
	}

}
