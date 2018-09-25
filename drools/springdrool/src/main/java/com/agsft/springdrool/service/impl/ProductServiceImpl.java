/**
 * 
 */
package com.agsft.springdrool.service.impl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.springdrool.model.Product;
import com.agsft.springdrool.service.ProductService;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private KieContainer kieContainer;

	public ProductServiceImpl() {
	}

	@Override
	public Product getProductDiscount(String type) {

		Product product = new Product("Product1", type, 0);
		KieSession kieSession = kieContainer.newKieSession("springdrool-session");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();

		return product;
	}

}
