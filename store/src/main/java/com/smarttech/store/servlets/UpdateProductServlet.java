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
@WebServlet(urlPatterns = { "/updateProduct" })
public class UpdateProductServlet extends HttpServlet {

	private static final long serialVersionUID = 4616794403874403267L;

	private ProductService productService;

	public UpdateProductServlet() throws Exception {
		super();
		ProductAccessor productAccessor = new ProductAccessor(DatabaseConnectionProvider.getConnection());
		productService = new ProductServiceImpl(productAccessor);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idText = (String) request.getAttribute("id");
		String nameText = (String) request.getAttribute("name");
		String priceTest = (String) request.getAttribute("price");
		try {
			if (nameText == null || priceTest == null || idText == null || nameText.isEmpty() || priceTest.isEmpty()
					|| idText.isEmpty()) {
				throw new Exception("Invalid values, please enter valid values.");
			}
			long id = Long.parseLong(idText);
			long price = Long.parseLong(priceTest);
			Product product = new Product(id, nameText, price);
			int updateCount = productService.update(product);
			if (updateCount <= 0) {
				throw new Exception("Failed to update product");
			}
		} catch (Exception cause) {
			request.setAttribute("error", cause.getMessage());
		} finally {
			request.getRequestDispatcher("/products").forward(request, response);
		}
	}
}
