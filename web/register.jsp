<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>
<body>
    <%@include file="includes/navbar.jsp" %>

    <div class="container">
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Add User</div>
            <div class="card-body">
                <form action="UserServlet" method="GET">
                    <input type="hidden" name="command" value="add" />

                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" name="username" value="" required />
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" value="" required />
                    </div>

                    <div class="form-group">
                        <label>Full Name</label>
                        <input type="text" class="form-control" name="fullName" value="" required />
                    </div>

                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" value="" required />
                    </div>

                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" class="form-control" name="address" value="" required />
                    </div>

                    <br>
                    <button type="submit" class="btn btn-dark">Add</button>
                    <br>
                    <br>
                    <div class="addbtn">
                        <button class="btn btn-dark"> <a href="index.jsp">Back</a> </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
