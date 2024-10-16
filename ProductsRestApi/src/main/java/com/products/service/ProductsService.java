package com.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.model.Products;
import com.products.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public List<Products> getAllProducts()
	{
		return productsRepository.findAll();
	}
	
	public Optional<Products> getProductById(Integer id){
		return productsRepository.findById(id);
	}
	
	/*-the Optional class (introduced in Java 8) is a container object 
	 * that may or may not contain a non-null value. It is primarily 
	 * used to prevent NullPointerException by representing the 
	 * possibility of an absent value. Instead of returning null,
	 * methods can return an Optional object, which can either hold 
	 * a value or be empty*/
	
	public Products saveProduct (Products product) {
		return productsRepository.save(product);
	}
	
	public void deleteProductById(Integer id) {
		productsRepository.deleteById(id);
	}

}
