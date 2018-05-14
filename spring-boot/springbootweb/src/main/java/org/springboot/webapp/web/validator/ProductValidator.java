package org.springboot.webapp.web.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.webapp.web.bean.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

	private Logger logger = LoggerFactory.getLogger(ProductValidator.class);

	public ProductValidator() {
		logger.info("Instantiated ProductValidator");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		logger.info("Invoked supports(Class)");
		return clazz.isAssignableFrom(ProductDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("Invoked validate(Object, Errors)");
		ProductDTO product = (ProductDTO) target;

		if (product.getDescription() == null || StringUtils.isEmpty(product.getDescription())) {
			errors.rejectValue("description", "field.blank");
		}
	}
}
