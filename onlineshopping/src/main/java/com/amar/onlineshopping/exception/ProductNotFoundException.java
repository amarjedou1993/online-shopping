package com.amar.onlineshopping.exception;

import java.io.Serializable;


public class ProductNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException(){
		
		this("this product is not fount");
	}

	public ProductNotFoundException(String string) {
		
		this.message = System.currentTimeMillis() + ": " + message;
				
	}

	public String getMessage() {
		return message;
	}

	
	
}
