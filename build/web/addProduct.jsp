<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    <form action="ProductServlet" method="GET">
        <input type="hidden" name="command" value="add">

        <div class="container">
            <h2>Add Product</h2>

            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="productName" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="productDescription">Description:</label>
                <textarea id="productDescription" name="productDescription" class="form-control" rows="3" required></textarea>
            </div>

            <div class="form-group">
                <label for="stockQuantity">Stock Quantity:</label>
                <input type="text" id="stockQuantity" name="stockQuantity" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="brandID">Brand:</label>
                <select id="brandID" name="brandID" class="form-control" required>
                    <c:forEach items="${brandList}" var="brand">
                        <option value="${brand.brandID}">${brand.brandName}</option>
                        
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="imageURL">Image URL:</label>
                <input type="text" id="imageURL" name="imageURL" class="form-control" required>
            </div>
            <br>
            <button type="submit" class="btn btn-dark">Add Product</button>            
        </div>
        <br>
    <br>
    <br>
    <br>
    </form>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
