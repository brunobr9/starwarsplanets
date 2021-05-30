package com.bruno.starwars.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bruno.starwars.service.exception.ServiceException;

/**
 * Api base com métodos básicos de CRUD
 * 
 * @author Bruno
 *
 * @param <T>  dto
 * @param <ID> id
 * 
 */

public interface ApiCrudResources<T, ID> {

	String PATH_ID = "/{id}";
	String LISTAR = "/listar";

	@PostMapping
	ResponseEntity<T> insert(@RequestBody T dto) throws ServiceException;

	@PutMapping(value = PATH_ID)
	ResponseEntity<Void> update(@RequestBody T dto, @PathVariable ID id) throws ServiceException;

	@GetMapping(value = PATH_ID)
	ResponseEntity<T> find(@PathVariable ID id) throws ServiceException;

	@GetMapping(value = LISTAR)
	ResponseEntity<List<T>> findAll();
}
