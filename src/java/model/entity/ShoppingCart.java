/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author ADMIN
 */
public class ShoppingCart {
    private int cartID;
    private User user; // Reference to User object
    private Product product; // Reference to Product object
    private int quantity;

    // Constructors, getters, and setters

    public ShoppingCart(int cartID, User user, Product product, int quantity) {
        this.cartID = cartID;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public ShoppingCart(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   

   
    
}

