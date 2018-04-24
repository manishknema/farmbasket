package com.farmbasket.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DBHelper {

	static Logger logger = Logger.getLogger(DBHelper.class);
	private static DataSource ds = null;

	static {
		logger.info("Inside Database() static method... ");
		Context context = null;
		try {
			context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/farmbasket");
		} catch (NamingException e) {
			logger.error("Unable to get Datasource...");
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}
}
