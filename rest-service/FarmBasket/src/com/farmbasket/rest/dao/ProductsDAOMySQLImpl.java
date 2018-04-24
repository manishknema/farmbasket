package com.farmbasket.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.farmbasket.model.Product;


public class ProductsDAOMySQLImpl implements ProductsDAO {

	DataSource datasource = null;
	String imagePath = "/";
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public ProductsDAOMySQLImpl(DataSource ds,String imagePath){
		this.datasource = ds;
		this.imagePath = imagePath;
	}
	@Override
	public Response getAllProducts() {
		if(this.datasource==null){
			log.error("datasource is null or empty");
			return Response.status(500).entity("Internal Error ds").build();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Product> productsList = new ArrayList<Product>();
		String sql = "select product_id, internal_id, product_name, hindi_name, "
				+ "category, other_name, image_available from products ";
		try {
			conn = datasource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int i=0;
			while(rs.next()){
				Product p = new Product();
				p.setPrice(0);
				
				p.setDb_product_id(rs.getInt("product_id"));
				p.setInternal_product_id(rs.getInt("internal_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductNameHindi(rs.getString("hindi_name"));
				p.setCategory(rs.getString("category"));
				p.setOtherName(rs.getString("other_name"));
				
				String imgAvail = rs.getString("image_available");
				if(imgAvail!=null && imgAvail.trim().length()!=0){
					
					imgAvail = imgAvail.trim().toLowerCase();
					if(imgAvail.equals("yes"))
					{
						String imageUrl = this.imagePath+ p.getInternal_product_id()+"-"+p.getProductName().trim().toLowerCase()+".jpg";
						p.setImageUrl(imageUrl);
					}
				}
				else
				{
					imgAvail = "no";
					p.setImageUrl(this.imagePath+"/default.jpg");
				}
				
				p.setImageAvailable(imgAvail);
				productsList.add(p);
				i++;
			}
			log.debug(String.format("completed scanning all [%d] products",i));
		} catch (SQLException e) {
			log.error(e.getMessage());
			
		}
		
		
		
		
		return Response.status(200).entity(productsList).build();
	}

}
