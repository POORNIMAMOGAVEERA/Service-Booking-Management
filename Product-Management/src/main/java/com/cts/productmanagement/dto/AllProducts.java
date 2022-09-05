package com.cts.productmanagement.dto;

import java.util.List;

import com.cts.productmanagement.model.AppProduct;


public class AllProducts {
	List<AppProduct> allProducts;

	public List<AppProduct> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(List<AppProduct> allProducts) {
		this.allProducts = allProducts;
	}
	
}