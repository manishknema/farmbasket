package com.farmbasket.model;

public class Product {
	
	
	//Must have no arg constructor for JSON conversion
	public Product() {
		
	}
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameHindi() {
		return productNameHindi;
	}
	public void setProductNameHindi(String productNameHindi) {
		this.productNameHindi = productNameHindi;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imUrl){
		this.imageUrl= imUrl;
	}

	public int getDb_product_id() {
		return db_product_id;
	}
	public void setDb_product_id(int db_product_id) {
		this.db_product_id = db_product_id;
	}
	public int getInternal_product_id() {
		return internal_product_id;
	}
	public void setInternal_product_id(int internal_product_id) {
		this.internal_product_id = internal_product_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageAvailable() {
		return imageAvailable;
	}
	public void setImageAvailable(String imageAvailable) {
		this.imageAvailable = imageAvailable;
	}
	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	private int db_product_id;
	private int internal_product_id;
	private String category;
	private String imageAvailable;
	private String productName;
	private String productNameHindi;
	private String otherName;
	
	private double price;
	private String imageUrl;
	
	
	

}
