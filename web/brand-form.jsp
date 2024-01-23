<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="includes/header.jsp" %>
</head>
<body>
    <%@ include file="includes/navbar.jsp" %>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <h2>Add Brand</h2>
        <form action="BrandServlet" method="get">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="brandName">Brand Name:</label>
                <input type="text" id="brandName" name="brandName" class="form-control" required>
            </div>

            <!-- You can add more form fields if needed -->

            <div class="form-group">
                <input type="submit" value="Add Brand" class="btn btn-primary">
            </div>
        </form>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
