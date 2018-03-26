package com.amar.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.amar.shoppingbackend.dao.ProductDao;
import com.amar.shoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public boolean add(Product product) {

		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		
		try {

			product.setActive(false);
			return this.update(product);


		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}


	@Override
	public List<Product> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from Product" , Product.class).getResultList();
	}

	@Override
	public Product get(int productId) {
		
		try {
			
			return sessionFactory
					.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProduct() {
		
		String selectActiveProduct = "FROM Product WHERE active = :active";

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProduct)
				.setParameter("active", true)
				.getResultList();
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProductByCategory(int idCategory) {
		
		String selectActiveCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId ";

		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveCategory , Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", idCategory)
				.getResultList();
	}

	@Override
	public List<Product> getLastestActiveProduct(int count) {
		
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id" , Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
