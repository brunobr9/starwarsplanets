package com.bruno.starwars.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;

import com.bruno.starwars.domain.IdEntity;
import com.bruno.starwars.service.exception.ServiceException;

public interface ServiceInterface<T extends IdEntity<ID>, ID> {

	T insert(T object) throws ServiceException;

	T update(T object) throws ServiceException;

	void delete(T object) throws ServiceException;

	T findById(ID id) throws ObjectNotFoundException, ServiceException;

	List<T> findAll();
}
