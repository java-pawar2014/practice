package com.smarttech.store.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.smarttech.store.accessor.ProductAccessor;
import com.smarttech.store.model.Product;
import com.smarttech.store.service.ProductService;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public class ProductServiceImpl implements ProductService {

	private ProductAccessor productAccessor;

	public ProductServiceImpl(ProductAccessor productAccessor) {
		super();
		this.productAccessor = productAccessor;
	}

	@Override
	public Product get(long id) throws Exception {
		return productAccessor.get(id);
	}

	@Override
	public List<Product> getAll() throws SQLException {
		return productAccessor.listAll();
	}

	@Override
	public int save(Product product) throws SQLException {
		return productAccessor.create(product);
	}

	@Override
	public int update(Product product) throws SQLException {
		return productAccessor.update(product);
	}

	@Override
	public int remove(long id) throws SQLException {
		return productAccessor.delete(id);
	}

}
