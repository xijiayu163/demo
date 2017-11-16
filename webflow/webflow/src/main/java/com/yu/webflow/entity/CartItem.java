package com.yu.webflow.entity;

import java.io.Serializable; 

public class CartItem implements Serializable { 
    private static final long serialVersionUID = 8388627124326126637L; 
    private Product product; 
    private int quantity; 
 
    public CartItem(Product product, int quantity) { 
        this.product = product; 
        this.quantity = quantity; 
    } 
 
    public int getTotalPrice() { 
        return this.quantity * this.product.getPrice(); 
    } 
 
    public void increaseQuantity() { 
        this.quantity++; 
    }

	public final Product getProduct() {
		return product;
	}

	public final void setProduct(Product product) {
		this.product = product;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	} 

 
}