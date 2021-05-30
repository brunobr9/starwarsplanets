package com.bruno.starwars.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.bruno.starwars.domain.IdEntity;

/**
 * Interface padrão para repositorios.
 * 
 * @author Bruno
 *
 * @param <T>  tipo objeto
 * @param <ID> tipo do ID
 */
@NoRepositoryBean
public interface RepositoryInterface<T extends IdEntity<ID>, ID> extends MongoRepository<T, ID> {

}
