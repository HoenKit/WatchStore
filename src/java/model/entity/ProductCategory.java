/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author ADMIN
 */
public class ProductCategory {
    private int productCategoryID;
    private Product product; // Reference to Product object
    private Category category; // Reference to Category object

    // Constructors, getters, and setters

    public ProductCategory() {
    }

    public ProductCategory(int productCategoryID, Product product, Category category) {
        this.productCategoryID = productCategoryID;
        this.product = product;
        this.category = category;
    }

    public int getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}

