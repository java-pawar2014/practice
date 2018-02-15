package com.spring.aop.tx.service;

import java.util.Collection;
import java.util.List;

import com.spring.aop.tx.bean.Product;

/**
 * @author bpawar
 *
 */
public interface ProductService {

	void add(Product product);

	void addAll(Collection<Product> products);

	Product getProduct(Integer productId);

	List<Product> getAllProducts();

	void delete(Integer productId);
}
