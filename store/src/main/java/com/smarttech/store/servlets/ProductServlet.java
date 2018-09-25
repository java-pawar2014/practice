package com.smarttech.store.servlets;

import java.io.IOException;
import java.util.Objects;

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
@WebServlet(urlPatterns = { "/product" })
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 4043630205004250369L;

	private ProductService productService;

	public ProductServlet() throws Exception {
		super();
		ProductAccessor productAccessor = new ProductAccessor(DatabaseConnectionProvider.getConnection());
		productService = new ProductServiceImpl(productAccessor);

	}

	/**
	 * Method to get product information, provide product ID as a query
	 * parameter. After fetching the product object, forward the request to
	 * show-product.jsp page
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idString = request.getParameter("id");
		try {
			if (Objects.nonNull(idString) && !idString.isEmpty()) {
				Product product = productService.get(Long.parseLong(idString));
				request.setAttribute("product", product);
				request.getRequestDispatcher("show-product.jsp").forward(request, response);
			} else {
				throw new Exception("Please provide valid ID");
			}
		} catch (Exception cause) {
			cause.printStackTrace();
			request.setAttribute("error", cause.getMessage());
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}


}
