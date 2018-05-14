package org.springboot.webapp.service;

import org.springboot.webapp.web.bean.ProductDTO;

public interface IProductService {

	Iterable<ProductDTO> listAll();

	ProductDTO find(Integer productId);

	ProductDTO save(ProductDTO product);

	boolean deleteProduct(Integer productId);
}
