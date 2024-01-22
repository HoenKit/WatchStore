<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <br>
    <div class="container">
        <div class="card-header my-3">All Products</div>
        <div class="row">
            <c:forEach var="product" items="${productList}">
                <div class="col-md-3">
                    <div class="card w-100" style="width: 18rem;">
                        <div class="card-body">
                            <!-- Set up a link for each product -->
                            <c:url var="productLink" value="ProductServlet">
                                <c:param name="command" value="load"></c:param>
                                <c:param name="productID" value="${product.productID}"></c:param>
                            </c:url>

                            <img src="images/${product.imageURL}" class="card-img-top" alt="...">
                            <h5 class="productName">Name: ${product.productName}</h5>
                            <h6 class="brand">Brand: ${product.brand.brandName}</h6>
                            <h6 class="price">Price: ${product.price}$</h6>

                            <div class="d-flex justify-content-between">
                                <div class="mb-2">
                                    <a class="btn btn-primary" href="${productLink}">View Detail</a>
                                </div>
                                <div class="mb-2">
                                    <a class="btn btn-success" href="#">Add to Cart</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
