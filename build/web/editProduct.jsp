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
   <%@ include file="includes/header.jsp" %>
</head>
<body>
    <%@ include file="includes/navbar.jsp" %>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Edit Product</div>
            <div class="card-body">
                <form action="ProductServlet" method="GET">
                    <input type="hidden" name="command" value="update" />
                    <input type="hidden" name="productID" value="${THE_PRODUCT.productID}" />
                    
                    <div class="form-group">
                        <label>Product Name</label>
                        <input type="text" class="form-control" name="productName" value="${THE_PRODUCT.productName}" />
                    </div>
                    
                    <div class="form-group">
                        <label>Price</label>
                        <input type="text" class="form-control" name="price" value="${THE_PRODUCT.price}" required />
                    </div>
                    
                    <div class="form-group">
                        <label>Product Description</label>
                        <input type="text" class="form-control" name="productDescription" value="${THE_PRODUCT.productDescription}" required />
                    </div>

                    <div class="form-group">
                        <label>Stock Quantity</label>
                        <input type="text" class="form-control" name="stockQuantity" value="${THE_PRODUCT.stockQuantity}" required />
                    </div>

                    <div class="form-group">
                        <label>Brand</label>
                        <select class="form-control" name="brandID" required>
                            <c:forEach items="${brandList}" var="brand">
                                <option value="${brand.brandID}" <c:if test="${brand.brandID eq THE_PRODUCT.brand.brandID}">selected</c:if>>${brand.brandName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Image URL</label>
                        <input type="text" class="form-control" name="imageURL" value="${THE_PRODUCT.imageURL}" required />
                    </div>

                    <br>
                    <button type="submit" class="btn btn-dark">Edit</button>
                    <br>
                    <br>
                    <div class="addbtn">
                        <button value="list" name="command" class="btn btn-dark" >Back</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%@include file="includes/footer.jsp" %>
</body>
</html>


