package com.bruno.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface RepositoryInterface<T extends IdEntity<ID>, ID> extends JpaRepository<T, ID> {

}
