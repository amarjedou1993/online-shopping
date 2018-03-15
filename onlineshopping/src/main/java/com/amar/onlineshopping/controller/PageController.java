package com.amar.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amar.shoppingbackend.dao.CategoryDao;
import com.amar.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = {"/" ,"/home" , "/index"})
	public ModelAndView index(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
		//passing list categories 
		mv.addObject("categories", categoryDao.list());
		
		return mv;
	}
	
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * 
	 * Method to load all products based on category
	 * */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showProducts(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickProduct", true);
		
		//passing list categories 
		mv.addObject("categories", categoryDao.list());
		
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		
		// fetch a single category
		Category category = null;
		category = categoryDao.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		mv.addObject("userClickCategory", true);
		
		//passing list categories 
		mv.addObject("categories", categoryDao.list());
		
		//passing the single catgory
		mv.addObject("category", category);
		return mv;
	}
	
	
	
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting" , required=false)String greeting){
		
		if(greeting == null){
			 greeting ="hello";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting){
		
		if(greeting == null){
			 greeting ="hello";
		}
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	

}
