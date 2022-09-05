package com.cts.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.productmanagement.dto.AllProducts;
import com.cts.productmanagement.feign.AuthClient;
import com.cts.productmanagement.model.AppProduct;
import com.cts.productmanagement.model.JwtResponse;
import com.cts.productmanagement.service.ProductService; 


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private AuthClient authClient;
		
	
    @PostMapping("/product")
	public AppProduct addProduct(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppProduct appProduct)throws Exception {    	
    	JwtResponse jwtResponse = authClient.getValidity(token);
		if(jwtResponse.isValid()) {
		return   productService.addProduct(appProduct);
		}else {
			 throw new Exception("e");
		}
	}
	/*@PostMapping("/product")
		public AppProduct addProduct(@RequestBody AppProduct appProduct)throws Exception {    	
			return   productService.addProduct(appProduct);
			}*/
		
    @PutMapping("/product")
	public AppProduct updateProduct(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppProduct appProduct)throws Exception {
    	JwtResponse jwtResponse = authClient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  productService.updateProduct(appProduct);
		}else {
			 throw new Exception("e");
		}
	}
    @GetMapping("/product/{id}")
	public AppProduct getProductById(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("id") int id) throws Exception{		
    	JwtResponse jwtResponse = authClient.getValidity(token);
		if(jwtResponse.isValid()) {
		return  productService.getProductById(id);
		}else {
			 throw new Exception("e");
		}
	}
    
   
    @DeleteMapping("/product/{id}")
	public void deleteProduct(@RequestHeader(name="Authorization",required = true)String token,@PathVariable int id) throws Exception{
    	JwtResponse jwtResponse = authClient.getValidity(token);
		if(jwtResponse.isValid()) {
		  productService.deleteProduct(id);
		}else {
			 throw new Exception("e");
		}
	}
	
	@GetMapping("/product")
	public List<AppProduct> getProducts(@RequestHeader(name="Authorization",required = true)String token)throws Exception{
		JwtResponse jwtResponse = authClient.getValidity(token);
		if(jwtResponse.isValid()) {
			return productService.getProduct();	
		}else {
			 throw new Exception("e");
		}
	}	
/*	@GetMapping("/product")
	public List<AppProduct> getProducts()throws Exception{
			return productService.getProduct();	
	}*/
	@GetMapping("/products")
	public AllProducts getAllUsers() {
		AllProducts allProducts = new AllProducts();
		allProducts.setAllProducts(productService.getProduct());
		return allProducts;
	}
}
