<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <body>
        <div class="container">
            <div class="row">
                <c:forEach var="product" items="${products}">
                    <div class="col-lg-4 col-md-6 mb-4 ml-auto mr-auto">
                        <div class="card h-100">
                            <a href='<spring:url value="/product/${product.getId()}"/>'><img class="card-img-top" src="${product.getImageUrl()}" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href='<spring:url value="/product/${product.getId()}"/>'>${product.getName()}</a>
                                </h4>
                                <h5>${product.getProductPrice()}€</h5>
                                <p class="card-text">${product.getDescription()}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>