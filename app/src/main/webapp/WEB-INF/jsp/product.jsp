<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-9">
            <div class="card mt-4">
                <img class="card-img-top img-fluid" src="${product.getImageUrl()}" alt="">
                <div class="card-body">
                    <h3 class="card-title">${product.getName()}</h3>
                    <h4>${product.getProductPrice()}€</h4>
                    <p class="card-text">${product.getDescription()}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>