package com.amar.shoppingbackend.dao;

import java.util.List;

import com.amar.shoppingbackend.dto.Product;

public interface ProductDao {

	//CRUD methods
	public boolean add(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public List<Product> list();
	public Product get(int productId);
	
	//Business methods
	public List<Product> listActiveProduct();
	public List<Product> listActiveProductByCategory(int idCategory);
	public List<Product> getLastestActiveProduct(int count);
	
}
