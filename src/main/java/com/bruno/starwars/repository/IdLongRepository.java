package com.bruno.starwars.repository;

import org.springframework.data.repository.NoRepositoryBean;

import com.bruno.starwars.domain.IdEntity;

@NoRepositoryBean
public interface IdLongRepository<T extends IdEntity<Long>> extends RepositoryInterface<T, Long> {

}
