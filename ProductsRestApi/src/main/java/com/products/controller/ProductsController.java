package com.products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.model.Products;
import com.products.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/allproducts")
	public List<Products> getallproducts()
	{
		return productsService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Optional<Products> getproductbyid(@PathVariable Integer id)
	{
		return productsService.getProductById(id);
	}
	
	@PostMapping("/addproduct")
	public Products saveProducts(@RequestBody Products product) 
	{
		return productsService.saveProduct(product);
	}
	//@ResponceBody - Java Object To JSON.
	//@RequestBody - JSON To Java Object.
	
	
	@PutMapping("/updateproduct/{id}")
	public Products updateById(@PathVariable Integer id,@RequestBody Products productdata)
	{
		Products product = productsService.getProductById(id).orElseThrow();
		
	 //Existing             Updated
		product.setName(productdata.getName());
		product.setTagline(productdata.getTagline());
		product.setPrice(productdata.getPrice());
		
		return productsService.saveProduct(product);
		
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProduct(@PathVariable Integer id)
	{
		productsService.deleteProductById(id);
	}

}
