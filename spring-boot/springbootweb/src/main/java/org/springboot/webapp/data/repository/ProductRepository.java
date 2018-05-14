package org.springboot.webapp.data.repository;

import org.springboot.webapp.data.bean.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
