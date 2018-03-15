package com.amar.shoppingbackend.dao;

import java.util.List;

import com.amar.shoppingbackend.dto.Category;

public interface CategoryDao {

	public List<Category> list();
	public Category get(int id);
}
