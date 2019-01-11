<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <body>
        <div class="container">
            <div class="row">
                <div class="productContent">
                    <div class="productCard">
                        <img class="imgProduct" src="${product.getImageUrl()}?height=800px&width=100px" alt="">
                        <div class="card-body">
                            <h3 class="productNameLabel"><span>${product.getName()}</span></h3>
                            <p class="categoryLabel">${product.getCategory().getName()}</p>
                            <h4>${product.getFormatedProductPrice()}€</h4>
                            <p class="card-text">${product.getDescription()}</p>
                            <form:form action="/webshop/cart/addProduct/${product.getId()}" method="post">
                                <button>
                                    <i class="fas fa-shopping-cart"></i>
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>