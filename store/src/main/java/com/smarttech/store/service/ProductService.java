package com.smarttech.store.service;

import java.util.List;

import com.smarttech.store.model.Product;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public interface ProductService {

	Product get(long id) throws Exception;

	List<Product> getAll() throws Exception;

	int save(Product product) throws Exception;

	int remove(long id) throws Exception;

	int update(Product product) throws Exception;

}
