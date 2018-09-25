/**
 * 
 */
package com.smarttech.store.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarttech.store.accessor.ProductAccessor;
import com.smarttech.store.model.Product;
import com.smarttech.store.service.ProductService;
import com.smarttech.store.service.impl.ProductServiceImpl;
import com.smarttech.store.util.DatabaseConnectionProvider;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
@WebServlet(urlPatterns = { "/addProduct" })
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1989676956759739357L;

	private ProductService productService;

	public AddProductServlet() throws Exception {
		super();
		ProductAccessor productAccessor = new ProductAccessor(DatabaseConnectionProvider.getConnection());
		productService = new ProductServiceImpl(productAccessor);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		request.getRequestDispatcher("add-product.jsp").forward(request, response);
	}

	/**
	 * Method to add new product, send product information (name, price) in POST
	 * request. After adding the product forward the request to /products for list
	 * of all products.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nameText = (String) request.getAttribute("name");
		String priceTest = (String) request.getAttribute("price");
		try {
			if (nameText == null || priceTest == null || nameText.isEmpty() || priceTest.isEmpty()) {
				throw new Exception("Invalid values, please enter valid values.");
			}
			long price = Long.parseLong(priceTest);
			Product product = new Product(0, nameText, price);
			int saveCount = productService.save(product);
			if (saveCount <= 0) {
				throw new Exception("Failed to save product");
			}
		} catch (Exception cause) {
			request.setAttribute("error", cause.getMessage());
		} finally {
			request.getRequestDispatcher("/products").forward(request, response);
		}
	}
}
