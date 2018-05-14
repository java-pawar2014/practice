package org.springboot.webapp.util;

import java.util.ArrayList;
import java.util.List;

import org.springboot.webapp.data.bean.ProductEntity;
import org.springboot.webapp.web.bean.ProductDTO;

public interface BeanConverters {

	public static class ProductBeanConverter {

		public static ProductDTO entityToDto(ProductEntity entity) {
			ProductDTO product = null;
			if (entity != null) {
				product = new ProductDTO();
				product.setId(entity.getId());
				product.setProductId(entity.getProductId());
				product.setDescription(entity.getDescription());
				product.setImageUrl(entity.getImageUrl());
				product.setPrice(entity.getPrice());
				product.setVersion(entity.getVersion());
			}
			return product;
		}

		public static List<ProductDTO> entitiesToDtos(List<ProductEntity> entities) {
			List<ProductDTO> products = null;

			products = new ArrayList<ProductDTO>();
			for (ProductEntity entity : entities) {
				ProductDTO product = entityToDto(entity);
				products.add(product);
			}
			return products;
		}

		public static ProductEntity dtoToEntity(ProductDTO product) {
			ProductEntity entity = null;
			if (product != null) {
				entity = new ProductEntity();
				entity.setId(product.getId());
				entity.setProductId(product.getProductId());
				entity.setDescription(product.getDescription());
				entity.setImageUrl(product.getImageUrl());
				entity.setPrice(product.getPrice());
				entity.setVersion(product.getVersion());
			}
			return entity;
		}

		public static List<ProductEntity> dtosToEntities(List<ProductDTO> products) {
			List<ProductEntity> entities = null;

			entities = new ArrayList<ProductEntity>();
			for (ProductDTO product : products) {
				ProductEntity entity = dtoToEntity(product);
				entities.add(entity);
			}
			return entities;
		}
	}
}
