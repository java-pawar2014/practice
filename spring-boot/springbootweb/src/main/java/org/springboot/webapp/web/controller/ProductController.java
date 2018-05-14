package org.springboot.webapp.web.controller;

import java.util.List;

import org.springboot.webapp.service.IProductService;
import org.springboot.webapp.web.bean.ProductDTO;
import org.springboot.webapp.web.response.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/product")
@Api(value = "Product online store")
public class ProductController {

	@Autowired
	private IProductService productService;

	@ApiOperation(value = "Search a product with an ID")
	@GetMapping(path = { "/search/{productId}" }, produces = { MediaType.TEXT_PLAIN_VALUE,
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> find(@PathVariable Integer productId) {

		ResponseEntity<?> productResponse = null;
		ProductDTO product = null;
		if (productId != null) {
			product = productService.find(productId);
			if (product != null) {
				productResponse = new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
			} else {
				productResponse = new ResponseEntity<String>("No product information found for ID " + productId,
						HttpStatus.NO_CONTENT);
			}
		} else {
			productResponse = new ResponseEntity<String>("Provide Product ID", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return productResponse;
	}

	@ApiOperation(value = "View a list of available products", response = ClientResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 204, message = "There are no products available"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = { "/search/all" }, produces = { MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ClientResponse find() {

		List<ProductDTO> products = null;

		products = (List<ProductDTO>) productService.listAll();
		ClientResponse response = new ClientResponse();
		if (products.isEmpty()) {
			response.setMessage("No products found");
			response.setStatus(HttpStatus.NO_CONTENT);
		} else {
			response.setMessage("Products fetched successfully");
			response.setResponse(products);
			response.setStatus(HttpStatus.OK);
		}
		return response;
	}

	@ApiOperation(value = "Add a new product")
	@PostMapping(path = { "/add" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE,
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ClientResponse save(@RequestBody ProductDTO product) {
		ProductDTO savedProduct = null;

		ClientResponse response = new ClientResponse();
		response.setStatus(HttpStatus.OK);
		if (product != null) {
			try {
				savedProduct = productService.save(product);
				if (savedProduct != null) {
					response.setMessage("Product saved successfully");
					response.setResponse(savedProduct);
				} else {
					response.setMessage("Failed to save product information, data might be inappropriate");
					response.setResponse(product);
				}
			} catch (Throwable cause) {
				response.setMessage("Failed to save product information, data might be inappropriate");
				response.setResponse(product);
			}
		} else {
			response.setMessage("Provide product information to save");
			response.setResponse(product);
		}
		return response;
	}

	@ApiOperation(value = "Delete a product")
	@DeleteMapping(path = { "/delete/{productId}" }, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> delete(Integer productId) {
		ResponseEntity<?> deleteResponse = null;

		boolean isProductDeleted = productService.deleteProduct(productId);
		if (isProductDeleted)
			deleteResponse = new ResponseEntity<String>("Product with ID " + productId + " is deleted successfully",
					HttpStatus.OK);
		else
			deleteResponse = new ResponseEntity<String>("Failed to delete product with ID " + productId, HttpStatus.OK);
		return deleteResponse;
	}

	@ApiOperation(value = "Update a existing product")
	@PutMapping(path = { "/update/{productId}" }, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updateProduct(@PathVariable Integer productId, @RequestBody ProductDTO product) {
		ResponseEntity<?> updateResponse = null;

		ProductDTO storedProduct = productService.find(productId);
		if (storedProduct != null) {
			storedProduct.setDescription(product.getDescription());
			storedProduct.setImageUrl(product.getImageUrl());
			storedProduct.setPrice(product.getPrice());
			ProductDTO savedProduct = productService.save(storedProduct);
			if (savedProduct != null) {
				updateResponse = new ResponseEntity<String>("Product with ID " + productId + " is updated successfully",
						HttpStatus.OK);
			} else {
				updateResponse = new ResponseEntity<String>("Failed to update product with ID " + productId,
						HttpStatus.OK);
			}
		} else {
			updateResponse = new ResponseEntity<String>("Product with ID " + productId + " is not found to update",
					HttpStatus.OK);
		}
		return updateResponse;
	}
}
