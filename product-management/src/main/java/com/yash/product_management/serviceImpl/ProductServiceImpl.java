package com.yash.product_management.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.yash.product_management.daoImpl.ProductDAOImpl;
import com.yash.product_management.model.Product;
import com.yash.product_management.service.ProductService;

public  class ProductServiceImpl implements  ProductService{
	static ProductDAOImpl dao = new ProductDAOImpl();
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public void viewProducts() {
		System.out.println("-----------------------------------------------");

        //get all the product from the dao getallProducts() method and store
        //them to a Product type productList
        List<Product> productList = dao.getAllProducts();
        for(Product product: productList)
        {
            //display product one by one
            displayProduct(product);
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\n");
		
	}

	@Override
	public void addProduct() throws NumberFormatException, IOException {
		 System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        int productId = Integer.parseInt(br.readLine());
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product Name:");
	        System.out.println("------------------------------------------------");
	        String productName = br.readLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter Product Price:");
	        System.out.println("------------------------------------------------");
	        String productPrice = br.readLine();
	        //after user enters values, store them in a Product variable
	        Product product = new Product(productId, productName,productPrice);
	        int status = dao.save(product);
	        if(status ==1 )
	        {
	            System.out.println("Product added successfully");
	        }
	        else
	        {
	            System.out.println("ERROR while adding product");
	        }
	        System.out.println("\n");
		
	}

	@Override
	public void updateProduct() throws NumberFormatException, IOException {
		 System.out.println("------------------------------------------------");
	        System.out.println("Enter Product ID:");
	        System.out.println("------------------------------------------------");
	        int productId = Integer.parseInt(br.readLine());
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter New Product Name:");
	        System.out.println("------------------------------------------------");
	        String productName = br.readLine();
	        System.out.println("------------------------------------------------");
	        System.out.println("Enter New Product Price:");
	        System.out.println("------------------------------------------------");
	        String productPrice = br.readLine();
	        //after user enters values, store them in a Product variable
	        Product product = new Product(productId, productName,productPrice);
	        int status = dao.update(product);
	        if(status ==1 )
	        {
	            System.out.println("Product updated successfully");
	        }
	        else
	        {
	            System.out.println("ERROR while updating product");
	        }
	        System.out.println("\n");
		
	}

	@Override
	public void deleteProduct() throws IOException {
		System.out.println("------------------------------------------------");
        System.out.println("Enter Product ID:");
        System.out.println("------------------------------------------------");
        int productId = Integer.parseInt(br.readLine());
        int status = dao.delete(productId);
        if(status == 1 )
        {
            System.out.println("Product deleted successfully");
        }
        else
        {
            System.out.println("ERROR while deleting product");
        }
        System.out.println("\n");
		
	}

	@Override
	public void searchProduct() throws IOException {
		System.out.println("------------------------------------------------");
        System.out.println("Enter Product ID:");
        System.out.println("------------------------------------------------");
        String productId = br.readLine();
        Product product = dao.getProductByid(productId);
        displayProduct(product);
        System.out.println("\n");
		
	}

	@Override
	public void displayProduct(Product product) {
		 System.out.println("Product ID: "+product.getId());
	        System.out.println("Product Name: "+product.getName());
	        System.out.println("Product Price: "+product.getPrice());
	        System.out.println("\n");
		
	}
	
}
