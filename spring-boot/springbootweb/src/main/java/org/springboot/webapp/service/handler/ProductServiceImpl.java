package org.springboot.webapp.service.handler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.webapp.data.bean.ProductEntity;
import org.springboot.webapp.data.repository.ProductRepository;
import org.springboot.webapp.service.IProductService;
import org.springboot.webapp.util.BeanConverters;
import org.springboot.webapp.web.bean.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl() {
	}

	@Override
	public Iterable<ProductDTO> listAll() {
		logger.info("Invoked listAll() to find all products");
		List<ProductDTO> products = null;
		List<ProductEntity> productEntities = null;

		productEntities = (List<ProductEntity>) productRepository.findAll();
		products = BeanConverters.ProductBeanConverter.entitiesToDtos(productEntities);
		logger.info("Returning from listAll() with " + products.size() + " products");
		return products;
	}

	@Override
	public ProductDTO find(Integer productId) {
		logger.info("Invoked find(Integer) with product ID " + productId);
		ProductDTO product = null;
		ProductEntity entity = null;
		try {
			entity = productRepository.findById(productId).get();
		} catch (Exception e) {
		}
		product = BeanConverters.ProductBeanConverter.entityToDto(entity);
		return product;
	}

	@Override
	public ProductDTO save(ProductDTO product) {
		logger.info("Invoked save(ProductDTO) to save " + product);
		ProductEntity entity = null;
		ProductDTO savedProduct = null;

		entity = BeanConverters.ProductBeanConverter.dtoToEntity(product);
		if (entity != null) {
			if (entity.getProductId() == null || entity.getProductId().isEmpty()) {
				entity.setProductId(UUID.randomUUID().toString());
			}
			ProductEntity productEntity = productRepository.save(entity);
			logger.info("Product saved " + productEntity);
			savedProduct = BeanConverters.ProductBeanConverter.entityToDto(productEntity);
		}
		logger.info("Returning save(ProductDTO) with + " + savedProduct);
		return savedProduct;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		logger.info("Deleting product of ID " + productId);
		Optional<ProductEntity> product = productRepository.findById(productId);
		if (product.isPresent()) {
			productRepository.deleteById(productId);
			return true;
		}
		return false;
	}
}
