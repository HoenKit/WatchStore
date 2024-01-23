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
    <form action="ManageCategoryServlet" method="GET">
        <div class="container">
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Category ID</th>
                        <th scope="col">Category Name</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categories}" var="category">
                        
                        <c:url var="deleteLink" value="ManageCategoryServlet">
                            <c:param name="action" value="delete"></c:param>
                            <c:param name="id" value="${category.categoryID}"></c:param>
                        </c:url>
                        <tr>
                            <td>${category.categoryID}</td>
                            <td>${category.categoryName}</td>
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
