<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <form action="BrandServlet" method="GET">
        <div class="container">
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Brand ID</th>
                        <th scope="col">Brand Name</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${brands}" var="brand">
                        <c:url var="deleteLink" value="BrandServlet">
                            <c:param name="action" value="delete"></c:param>
                            <c:param name="id" value="${brand.brandID}"></c:param>
                        </c:url>
                        <tr>
                            <td>${brand.brandID}</td>
                            <td>${brand.brandName}</td>
                            <td>
                                <a href="${deleteLink}" onclick="if (!(confirm('Sure?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="addbtn">
                <button class="btn btn-dark" name="action" value="showForm" >Add</button> 
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
        </div>
    </form>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>
