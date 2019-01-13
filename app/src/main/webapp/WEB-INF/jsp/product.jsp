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
                            <h4><c:choose>
                                <c:when test="${!product.hasDiscount()}">
                                    ${product.getFormatedRealPrice()}
                                </c:when>
                                <c:otherwise>
                                    <span class="wrongPrice">${product.getFormatedProductPrice()}</span> <span class="newPrice">${product.getFormatedRealPrice()}</span>
                                </c:otherwise>
                            </c:choose>€</h4>
                            <p class="card-text">${product.getDescription()}</p>
                            <form:form action="/webshop/cart/addProduct/${product.getId()}" method="post">
                                <button class="clickable">
                                    <i class="fas fa-cart-plus"></i>
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>