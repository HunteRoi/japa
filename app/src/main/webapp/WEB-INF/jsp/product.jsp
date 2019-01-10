<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <div class="card mt-4">
                        <img class="card-img-top img-fluid" src="${product.getImageUrl()}?height=800px&width=100px" alt="">
                        <div class="card-body">
                            <h3 class="card-title"><span>${product.getName()}</span><span>${product.getCategory().getName()}</span></h3>
                            <h4>${product.getFormatedProductPrice()}€</h4>
                            <p class="card-text">${product.getDescription()}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>