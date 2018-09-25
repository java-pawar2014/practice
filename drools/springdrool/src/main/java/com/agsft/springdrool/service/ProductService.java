/**
 * 
 */
package com.agsft.springdrool.service;

import com.agsft.springdrool.model.Product;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public interface ProductService {

	Product getProductDiscount(String type);

}
