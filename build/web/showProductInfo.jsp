<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Item - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <%@include file="includes/header.jsp" %>
    </head>
    <body>
        <!-- Navigation-->
        <%@include file="includes/navbar.jsp" %>
        <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6">
                        <img class="card-img-top mb-5 mb-md-0" src="<c:out value="images/${productObj.imageURL}" />" alt="Product Image" />
                    </div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: <c:out value="${productObj.productID}" /></div>
                        <h1 class="display-5 fw-bolder"><c:out value="${productObj.productName}" /></h1>
                        <div class="fs-5 mb-5">
                            <span><c:out value="$${productObj.price}" /></span>
                        </div>
                        <p class="lead"><c:out value="${productObj.productDescription}" /></p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Rating section-->
        <section class="py-5">
    <div class="container px-4 px-lg-5">
        <h2 class="fw-bolder mb-4">Customer Reviews</h2>

        <!-- Customer review form -->
        <form action="ReviewServlet" method="POST">
            <div class="mb-3">
                <label for="customerName" class="form-label">Your Name</label>
                <input type="text" class="form-control" id="customerName" name="customerName" required>
            </div>
            <div class="mb-3">
                <label for="review" class="form-label">Your Review</label>
                <textarea class="form-control" id="review" name="review" rows="3" required></textarea>
            </div>
            <div class="mb-3">
                <label for="rating" class="form-label">Rating</label>
                <select class="form-select" id="rating" name="rating" required>
                    <option value="5">5 stars</option>
                    <option value="4">4 stars</option>
                    <option value="3">3 stars</option>
                    <option value="2">2 stars</option>
                    <option value="1">1 star</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit Review</button>
        </form>

        <!-- Display existing customer reviews -->
        <div class="mt-5">
            <h4 class="fw-bold mb-3">Customer Reviews:</h4>
            <!-- Loop through and display reviews dynamically -->
            <div class="mb-3">
                <div class="fw-bold">John Doe</div>
                <div class="text-warning">5 stars</div>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>
            <!-- Repeat similar blocks for other reviews -->
        </div>
    </div>
</section>
        <!-- Footer-->
        <%@include file="/includes/footer.jsp"%>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
