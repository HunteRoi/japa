<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <body>
        <div class="container">
            <div class="row">
                <c:forEach var="product" items="${products}">
                    <div class="col-lg-4 col-md-6 mb-4 ml-auto mr-auto">
                        <div class="itemCard">
                            <a href='<spring:url value="/product/${product.getId()}"/>'><img class="card-img-top" src="${product.getImageUrl()}?height=500px&width=auto" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href='<spring:url value="/product/${product.getId()}"/>'>${product.getName()}</a>
                                </h4>
                                <h5>${product.getFormatedProductPrice()}€</h5>
                                <p class="card-text">${product.getShortDescription()}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>