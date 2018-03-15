package com.amar.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Repository;

import com.amar.shoppingbackend.dao.CategoryDao;
import com.amar.shoppingbackend.dto.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {

		// adding first category
		Category categry = new Category();
		categry.setId(1);
		categry.setName("PC");
		categry.setDescription("Laptops");
		categry.setImageURL("");
		categry.setActive(true);

		categories.add(categry);
		categry = new Category();
		categry.setId(2);
		categry.setName("TV");
		categry.setDescription("Television");
		categry.setImageURL("");
		categry.setActive(true);

		categories.add(categry);
		categry = new Category();
		categry.setId(3);
		categry.setName("Phone");
		categry.setDescription("Phone selling");
		categry.setImageURL("");
		categry.setActive(true);

		categories.add(categry);

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
	
		//enchanced loop
		for (Category category : categories) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
