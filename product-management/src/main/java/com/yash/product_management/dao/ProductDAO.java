package com.yash.product_management.dao;

import java.util.List;

import com.yash.product_management.model.Product;

public interface ProductDAO {
	
	/**
	 * Returns a list of products
	 * @return
	 */
	public List<Product> getAllProducts();
	
	/**
	 * gets the product by id
	 * @param productId
	 * @return
	 */
	public Product getProductByid(String productId);
	
	/**
	 * used for saving products
	 * @param product
	 * @return
	 */
	public int save(Product product);
	
	/**
	 * used for updating product details
	 * @param product
	 * @return
	 */
	public int update(Product product);
	
	/**
	 * deleting a product
	 * @param productId
	 * @return
	 */
	public int delete(int productId);

}
