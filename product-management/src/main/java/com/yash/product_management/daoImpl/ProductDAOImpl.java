package com.yash.product_management.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.product_management.dao.ProductDAO;
import com.yash.product_management.model.Product;
import com.yash.product_management.util.JDBCUtil;

public class ProductDAOImpl implements ProductDAO
{

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<Product>();
        try
        {
            //typical jdbc coding
            Connection conn = JDBCUtil.getConnection();
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while(rs.next())
            {
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
                productList.add(product);
            }
            conn.close();  //close connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return productList;
	}

	@Override
	public Product getProductByid(String productId) {
		Product product = null;
        try
        {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            //iterate through result
            while(rs.next())
            {
                product = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("price"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return product;
	}

	@Override
	public int save(Product product) {
		 int status = 0;
	       try
	       {
	           Connection conn = JDBCUtil.getConnection();
	           PreparedStatement ps = conn.prepareStatement("INSERT INTO products VALUES(?,?,?)");
	           //set parameters of query here but using the values for the product object
	           ps.setInt(1, product.getId());
	           ps.setString(2, product.getName());
	           ps.setString(3, product.getPrice());
	           status = ps.executeUpdate();  //if successful status should return 1
	       }
	       catch(Exception e)
	       {
	           e.printStackTrace();
	       }
	       return status;
	}

	@Override
	public int update(Product product) {
		int status = 0;
		   try
		   {
		       Connection conn = JDBCUtil.getConnection();
		       PreparedStatement ps = conn.prepareStatement("UPDATE products SET id=?, name=? WHERE price=?");
		       //set parameters of query here but using the values for the product object
		       ps.setInt(1, product.getId());
		       ps.setString(2, product.getName());
		       ps.setString(3, product.getPrice());
		       status = ps.executeUpdate();  //if successful status should return 1
		   }
		   catch(Exception e)
		   {
		       e.printStackTrace();
		   }
		   return status;
	}

	@Override
	public int delete(int productId) {
	
		int status = 0;
		try
		{
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete from  products where id= ?");
			ps.setInt(1, productId);
			status = ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
}



















