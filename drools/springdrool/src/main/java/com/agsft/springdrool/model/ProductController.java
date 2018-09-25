/**
 * 
 */
package com.agsft.springdrool.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.springdrool.service.ProductService;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	public ProductController() {
	}

	@GetMapping(path = { "/product/discount" }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> getDiscount(String type) {
		return ResponseEntity.ok(productService.getProductDiscount(type));
	}

}
