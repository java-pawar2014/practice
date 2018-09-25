package com.smarttech.store.accessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smarttech.store.model.Product;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public class ProductAccessor {

	private static String SELECT_ALL = "SELECT * FROM product";
	private static String SELECT_BY_ID = "SELECT * FROM product WHERE id = ?";
	private static String CREATE = "INSERT INTO product(name, price) values (?, ?)";
	private static String UPDATE = " UPDATE PRODUCT SET name = ?, price = ? WHERE id = ?";
	private static String DELETE_BY_ID = "DELETE FROM product where id = ?";

	private Connection connection;

	public ProductAccessor(Connection connection) {
		this.connection = connection;
	}

	public Product get(long id) throws Exception {

		PreparedStatement query = connection.prepareStatement(SELECT_BY_ID);
		query.setLong(1, id);
		ResultSet row = query.executeQuery();
		if (row.next()) {
			return extract(row);
		}
		throw new Exception("Product not found for specified ID");
	}

	public List<Product> listAll() throws SQLException {
		Statement query = connection.createStatement();
		ResultSet rows = query.executeQuery(SELECT_ALL);
		List<Product> products = new ArrayList<>();
		while (rows.next()) {
			products.add(this.extract(rows));
		}
		return products;
	}

	public int create(Product product) throws SQLException {

		PreparedStatement query = connection.prepareStatement(CREATE);
		query.setString(1, product.getName());
		query.setLong(2, product.getPrice());
		return query.executeUpdate();
	}

	public int update(Product product) throws SQLException {

		PreparedStatement query = connection.prepareStatement(UPDATE);
		query.setString(1, product.getName());
		query.setLong(2, product.getPrice());
		query.setLong(3, product.getId());
		return query.executeUpdate();
	}

	public int delete(long id) throws SQLException {
		PreparedStatement query = connection.prepareStatement(DELETE_BY_ID);
		query.setLong(1, id);
		return query.executeUpdate();
	}

	private Product extract(ResultSet row) throws SQLException {
		return new Product(row.getLong("id"), row.getString("name"), row.getLong("price"));
	}

}
