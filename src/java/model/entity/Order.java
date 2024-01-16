/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author ADMIN
 */
import java.util.Date;

public class Order {
    private int orderID;
    private User user; // Reference to User object
    private Date orderDate;

    // Constructors, getters, and setters

    public Order() {
    }

    public Order(User user, Date orderDate) {
        this.user = user;
        this.orderDate = orderDate;
    }

    public Order(int orderID, User user, Date orderDate) {
        this.orderID = orderID;
        this.user = user;
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

  
}

