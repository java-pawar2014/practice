package com.smarttech.store.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smarttech.store.accessor.ProductAccessor;
import com.smarttech.store.service.ProductService;
import com.smarttech.store.service.impl.ProductServiceImpl;
import com.smarttech.store.util.DatabaseConnectionProvider;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
@WebServlet(urlPatterns = { "/deleteProduct" })
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1859596463105889397L;

	private ProductService productService;

	public DeleteProductServlet() throws Exception {
		super();
		ProductAccessor productAccessor = new ProductAccessor(DatabaseConnectionProvider.getConnection());
		productService = new ProductServiceImpl(productAccessor);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idText = (String) request.getParameter("id");
		try {
			if (idText == null || idText.isEmpty()) {
				throw new Exception("Please provide valid product ID.");
			}
			long id = Long.parseLong(idText);
			productService.remove(id);
		} catch (Exception cause) {
			request.setAttribute("error", cause.getMessage());
		} finally {
			request.getRequestDispatcher("/products").forward(request, response);
		}

	}
}
