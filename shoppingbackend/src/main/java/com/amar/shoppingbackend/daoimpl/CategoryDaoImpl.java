package com.amar.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RespectBinding;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amar.shoppingbackend.dao.CategoryDao;
import com.amar.shoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * // adding first category Category category = new Category();
	 * category.setId(1); category.setName("PC");
	 * category.setDescription("Laptops"); category.setImageURL("");
	 * category.setActive(true);
	 * 
	 * categories.add(category); category = new Category(); category.setId(2);
	 * category.setName("TV"); category.setDescription("Television");
	 * category.setImageURL(""); category.setActive(true);
	 * 
	 * categories.add(category); category = new Category(); category.setId(3);
	 * category.setName("Phone"); category.setDescription("Phone selling");
	 * category.setImageURL(""); category.setActive(true);
	 * 
	 * categories.add(category);
	 * 
	 * }
	 */

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean update(Category category) {

		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
