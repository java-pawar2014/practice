package com.spring.aop.tx.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.spring.aop.tx.bean.Product;

/**
 * @author bpawar
 *
 */
@Component
public class ProductDAO {

	private final String SELECT_PRODUCT_ALL = "FROM Product";
	private final String DELETE_PRODUCT = "DELETE FROM Product where productId=?";
	// Dependency injection to an EntityManager
	@PersistenceContext // JPA annotation
	private EntityManager entityManager;

	// Save single product entity
	public void save(Product product) {
		entityManager.setFlushMode(FlushModeType.COMMIT);
		entityManager.persist(product);
	}

	// Return all products as list
	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return entityManager.createQuery(SELECT_PRODUCT_ALL).getResultList();
	}

	// Return product for given id
	public Product findById(Integer productId) {
		return entityManager.find(Product.class, productId);
	}

	public void removeById(Integer productId) {
		Query query = entityManager.createQuery(DELETE_PRODUCT);
		query.setParameter(1, productId);
		query.executeUpdate();
	}
}
