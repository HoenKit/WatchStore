<%-- 
    Document   : edit
    Created on : Jan 6, 2024, 5:04:45 PM
    Author     : PC
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="includes/header.jsp" %>
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
        <title>Edit Profile</title>
    </head>
    <body>
        <%@ include file="includes/navbar.jsp" %>
        <br>
        <br>
        <br>
        <br>
        <br>
        <form action="UpdateProfileServlet" method="Post">
            <div class="container">
                <br>
                <h2>Edit Profile</h2>
                <br>  
                <div class="form-group">
                    <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                    <input type="text" name="username" id="name" placeholder="Your Name" value="${user.username}"/>
                </div>
                <div class="form-group">
                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                    <input type="email" name="email" id="email" placeholder="Your Email" value="${user.email}"/>
                    <span id="email-error" class="text-danger"></span>
                </div>
                <div class="form-group">
                    <label for="password"><i class="zmdi zmdi-lock"></i></label>
                    <input type="password" name="password" id="password" placeholder="Your Password"/>
                </div>
                <div class="form-group">
                    <label for="phone"><i class="zmdi zmdi-phone"></i></label>
                    <input type="text" name="phone" id="phone" placeholder="Your Phone" value="${user.phone}"/>
                    <span id="phone-error" class="text-danger"></span>
                </div>
                <div class="form-group">
                    <label for="address"><i class="zmdi zmdi-address"></i></label>
                    <input type="text" name="address" id="address" placeholder="Your Address" value="${user.address}"/>
                </div>
                <div class="form-group">
                    <input type="hidden" name="role" id="role" value="User"/>
                </div>
                <button type="submit" class="btn btn-dark">Update Profile</button>
                <br>     
                <br>    
            </div>
        </form>
    </body>
</html>
