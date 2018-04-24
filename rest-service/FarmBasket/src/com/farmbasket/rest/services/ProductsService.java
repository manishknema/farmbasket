package com.farmbasket.rest.services;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.farmbasket.rest.dao.ProductsDAO;
import com.farmbasket.rest.dao.ProductsDAOImpl;
import com.farmbasket.rest.dao.ProductsDAOMySQLImpl;
import com.farmbasket.utils.DBHelper;

@Path("/products")
public class ProductsService {

	@Context ServletContext servletContext;
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	@Path("status")
	@GET
	@Produces("application/json")
	public Response list() throws JSONException{
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("test", "working ok");
		
		return Response.status(200).entity(jsonResponse.toString()).build();
	}
	
	
	@GET
	@Produces("application/json")
	public Response getAllProducts(@QueryParam("path") String requestedPath) throws JSONException {
		ProductsDAO daoImpl = new ProductsDAOImpl();
		String path = requestedPath == null ? "images/" : requestedPath;
       
        log.info(String.format("path is [%s]", path));
			
		daoImpl = new ProductsDAOMySQLImpl(DBHelper.getDataSource(),path);
	
		return daoImpl.getAllProducts();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
