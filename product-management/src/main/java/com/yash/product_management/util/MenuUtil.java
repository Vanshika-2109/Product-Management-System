package com.yash.product_management.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.yash.product_management.serviceImpl.ProductServiceImpl;

public class MenuUtil {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ProductServiceImpl ps = new ProductServiceImpl();
	public  void start() throws IOException
	{
	String option = "";

    do
    {
        System.out.println("A. View Products");
        System.out.println("B. Add Product");
        System.out.println("C. Update Product");
        System.out.println("D. Delete Product");
        System.out.println("E. Search Product");
        System.out.println("F. Exit");
        System.out.println("===========================================");
        System.out.println("Enter an option");
        System.out.println("===========================================");
        option = br.readLine();
        System.out.println("\n");

        switch(option.toUpperCase())
        {
            case "A":
                ps.viewProducts();
                break;

            case "B":
                ps.addProduct();
                break;

            case "C":
                ps.updateProduct();
                break;

            case "D":
                ps.deleteProduct();
                break;

            case "E":
                ps.searchProduct();
                break;

            case "F":
                System.out.println("******************************THANK YOU********************");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Option! Please enter again");
                break;
        }
    }while(!option.equals("F"));
}

}
