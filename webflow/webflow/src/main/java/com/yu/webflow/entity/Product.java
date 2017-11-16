package com.yu.webflow.entity;

import java.io.Serializable;

public class Product implements Serializable { 
 
    private static final long serialVersionUID = 1951520003958305899L; 
    private int id; 
    private String description; 
    private int price; 
     
    public Product(int id, String description, int price) { 
        this.id = id; 
        this.description = description; 
        this.price = price; 
    }

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final int getPrice() {
		return price;
	}

	public final void setPrice(int price) {
		this.price = price;
	} 
 
 
}