package com.amar.shoppingbackend.dao;

import java.util.List;

import com.amar.shoppingbackend.dto.Category;

public interface CategoryDao {

	
	public boolean add(Category category);
	public boolean update(Category category);
	public boolean delete (Category category);
	public List<Category> list();
	public Category get(int id);
}
