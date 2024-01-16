/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class Product {
    private int productID;
    private String productName;
    private BigDecimal price;
    private String productDescription;
    private int stockQuantity;
    private Brand brand; // Reference to Brand object
    private String imageURL;

    // Constructors, getters, and setters

    public Product() {
    }

    public Product(int productID, String productName, BigDecimal price, String productDescription, int stockQuantity, Brand brand, String imageURL) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
        this.imageURL = imageURL;
    }

    public Product(String productName, BigDecimal price, String productDescription, int stockQuantity, Brand brand, String imageURL) {
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
        this.imageURL = imageURL;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

   
    
}

