package com.smarttech.store.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet(urlPatterns = { "/products" })
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService;

	public ListProductServlet() throws Exception {
		super();
		productService = new ProductServiceImpl(new ProductAccessor(DatabaseConnectionProvider.getConnection()));
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = null;
		try {
			products = (List<Product>) request.getAttribute("products");
			if (products == null || products.isEmpty()) {
				products = productService.getAll();
			}
		} catch (Exception cause) {
			cause.printStackTrace();
		} finally {
			if (products == null) {
				products = new ArrayList<>();
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("products.jsp").forward(request, response);
		}
	}
}
