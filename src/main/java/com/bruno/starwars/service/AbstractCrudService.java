package com.bruno.starwars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.starwars.domain.IdEntity;
import com.bruno.starwars.repository.RepositoryInterface;
import com.bruno.starwars.service.exception.ObjectNotFoundException;
import com.bruno.starwars.service.exception.ServiceException;

/**
 * 
 * Serviço que implementa operações básicas de crud. As operações são
 * transacionadas.
 * 
 * @author Bruno
 *
 * @param <T>
 * @param <ID>
 */
@Transactional(rollbackFor = ServiceException.class, propagation = Propagation.REQUIRES_NEW)
public abstract class AbstractCrudService<T extends IdEntity<ID>, ID> implements ServiceInterface<T, ID> {

	@Autowired
	private RepositoryInterface<T, ID> repositoryInterface;

	@Override
	public T insert(T object) throws ServiceException {
		return repositoryInterface.save(object);
	}

	@Override
	public T update(T object) throws ServiceException {
		return repositoryInterface.save(object);
	}

	@Override
	public void delete(T object) throws ServiceException {
		repositoryInterface.deleteById(object.getId());
	}

	@Override
	public T findById(ID id) throws ServiceException {
		Optional<T> obj = repositoryInterface.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id.toString(), this.getClass().getName()));
	}

	@Override
	public List<T> findAll() {
		return repositoryInterface.findAll();
	}

}
