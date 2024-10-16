package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{
	//It should be empty!!! Unless you want to create your own Query.
	//Like FindByName etc..

}
