<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>
<body>
    <%@include file="includes/navbar.jsp" %>
    <br>
    <br>
    <br>
    <br>
    <br>
    <form action="ProductServlet" method="GET">
        <div class="container">
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Product Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Stock Quantity</th>
                        <th scope="col">Brand</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${productListU}" var="product">
                        <c:url var="updateLink" value="ProductServlet">
                            <c:param name="command" value="loadtoUpdate"></c:param>
                            <c:param name="productID" value="${product.productID}"></c:param>
                        </c:url>
                        <c:url var="deleteLink" value="ProductServlet">
                            <c:param name="command" value="delete"></c:param>
                            <c:param name="productID" value="${product.productID}"></c:param>
                        </c:url>
                        <tr>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${fn:length(product.productDescription) > 20}">
                                        ${fn:substring(product.productDescription, 0, 20)}...
                                    </c:when>
                                    <c:otherwise>
                                        ${product.productDescription}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>${product.stockQuantity}</td>
                            <td>${product.brand.brandName}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                <a href="${deleteLink}" onclick="if (!(confirm('Sure?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="addbtn">
                <button class="btn btn-dark" name="command" value ="addForm" >Add</button> 
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
    </form>
    <%@include file="includes/footer.jsp" %>
</body>
</html>
