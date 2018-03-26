package com.amar.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amar.shoppingbackend.dao.CategoryDao;
import com.amar.shoppingbackend.dto.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amar.shoppingbackend");
		context.refresh();
		
		categoryDao = (CategoryDao)context.getBean("categoryDao");
		
	}
	/*
	@Test
	public void CategoryAddTest() {
		
		category = new Category();
		category.setName("Smart Phones");
		category.setDescription("Smart Phones Like Iphone Samsung");
		category.setImageURL("IMG_00.png");
		assertEquals("Category successfully added into database", true, categoryDao.add(category));
		
	}*/
	
	/*@Test
	public void getCategoryTest () {
		
		category = categoryDao.get(2);
		assertEquals("Category successfully added into database", "Television", category.getName());
	}*/
	
	/*@Test
	public void getUpdateTest () {
		
		category = categoryDao.get(2);
		category.setName("TV");
		assertEquals("Category successfully added into database", true , categoryDao.update(category));
	}*/
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));

		
		// fetching and updating the category
		category = categoryDao.get(2);
		
		category.setName("TV2");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDao.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDao.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",10,categoryDao.list().size());		
				
		
	}
}
