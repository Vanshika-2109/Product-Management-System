package com.yash.product_management.service;

import java.io.IOException;
import com.yash.product_management.model.Product;

public interface ProductService 
{

	/**
	 * used for showing the products which are already stored in db
	 */
	public void viewProducts();
	
	
	/**
	 * This method is used for adding products
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void addProduct() throws NumberFormatException, IOException;
	
	/**
	 * used for updating product
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void updateProduct() throws NumberFormatException, IOException;
	
	/**
	 * Used for deleting a entry in product table
	 * @throws IOException
	 */
	public void deleteProduct() throws IOException;
	
	/**
	 * used to search a product by id
	 * @throws IOException
	 */
	public void searchProduct() throws IOException;
	
	
	/**
	 * used to display products
	 * @param product
	 */
	public void displayProduct(Product product);
	
}