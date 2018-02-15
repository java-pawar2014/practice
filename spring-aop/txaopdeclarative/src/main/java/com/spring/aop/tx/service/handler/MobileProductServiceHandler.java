package com.spring.aop.tx.service.handler;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.aop.tx.bean.Product;
import com.spring.aop.tx.persistence.ProductDAO;
import com.spring.aop.tx.service.ProductService;

/**
 * @author bpawar
 *
 */
@Component
public class MobileProductServiceHandler implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public void add(Product product) {
		if (product != null)
			productDao.save(product);
	}

	@Override
	public void addAll(Collection<Product> products) {

		if (products != null & products.size() > 0)
			for (Product product : products)
				if (product != null)
					productDao.save(product);

	}

	@Override
	public Product getProduct(Integer productId) {

		return productDao.findById(productId);
	}

	@Override
	public List<Product> getAllProducts() {

		return productDao.findAll();
	}

	@Override
	public void delete(Integer productId) {
		productDao.removeById(productId);
	}
}
