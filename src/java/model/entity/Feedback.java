/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author ADMIN
 */
public class Feedback {
    private int feedbackID;
    private User user; // Reference to User object
    private Product product; // Reference to Product object
    private String comment;
    private int rating;

    // Constructors, getters, and setters

    public Feedback() {
    }

    public Feedback(int feedbackID, User user, Product product, String comment, int rating) {
        this.feedbackID = feedbackID;
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    public Feedback(User user, Product product, String comment, int rating) {
        this.user = user;
        this.product = product;
        this.comment = comment;
        this.rating = rating;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

   
}

