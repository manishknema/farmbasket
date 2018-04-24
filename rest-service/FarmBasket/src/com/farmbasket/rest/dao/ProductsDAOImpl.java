/**
 * 
 */
package com.farmbasket.rest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.farmbasket.model.Product;

/**
 * @author Manish
 *
 */
public class ProductsDAOImpl implements ProductsDAO {

	/* (non-Javadoc)
	 * @see com.farmbasket.rest.dao.ProductsDAO#getAllProducts()
	 */
	@Override
	public Response getAllProducts() {
		List<Product> productsList = new ArrayList<Product>();
		
		Product p = new Product() ;
		p.setPrice(100);
		p.setProductName("Product1");
		//p.setProductId("1");
		p.setProductNameHindi("product-hind1");
		productsList.add(p);
		
		 
		return Response.status(200).entity(productsList).build();
	}

}
