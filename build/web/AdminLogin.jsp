<%-- 
    Document   : AdminLogin
    Created on : Jan 6, 2024, 5:10:24 PM
    Author     : PC
--%>


<%@page import="model.entity.users.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Admin auth = (Admin) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("index.jsp");
	}
        %>
<!DOCTYPE html>
<html>
<head>
   <%@include file="/includes/header.jsp"%>
</head>
<body >
	<%@include file="/includes/navbar.jsp"%>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Admin Login</div>
			<div class="card-body">
				<form action="AdminServlet" method="get">
					<div class="form-group">
						<label>Username</label> 
                                                <input type="text" name="username" class="form-control" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
                                    <br>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	
</body>
</html>

