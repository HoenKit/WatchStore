<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Add Category</title>
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
            <h2>Add Category</h2>
            <form action="ManageCategoryServlet" method="get">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="categoryName">Category Name:</label>
                    <input type="text" id="categoryName" name="categoryName" class="form-control" required>
                </div>

                <br>
                <br>

                <div class="form-group">
                    <input type="submit" value="Add Category" class="btn btn-primary">
                </div>
            </form>
            <br>
            <br>
            <br>
        </div>
        <%@ include file="includes/footer.jsp" %>
    </body>
</html>
