<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<body>
    <section class="cart bgwhite p-t-70 p-b-100">
        <div class="container">
            <!-- Cart item -->
            <div class="container-table-cart pos-relative">
                <div class="wrap-table-shopping-cart bgwhite">
                    <table class="table-shopping-cart">
                        <tr class="table-head">
                            <th class="column-1"></th>
                            <th class="column-2"><spring:message code="product"/></th>
                            <th class="column-3"><spring:message code="unityPrice"/></th>
                            <th class="column-4"><spring:message code="unityDiscount"/></th>
                            <th class="column-5 p-l-70"><spring:message code="quantity"/></th>
                            <th class="column-6"><spring:message code="totalWithoutDiscount"/></th>
                            <th class="column-6"><spring:message code="totalWithDiscount"/></th>
                        </tr>
                        <c:forEach var="commandLine" items="${products}">
                            <tr class="table-row">
                                <td class="column-1">
                                    <div class="cart-img-product b-rad-4 o-f-hidden">
                                        <img class="imgCar" src="${commandLine.getProduct().getImageUrl()}" alt="IMG-PRODUCT">
                                    </div>
                                </td>
                                <td class="column-2">${commandLine.getProduct().getName()}</td>
                                <td class="column-3">${commandLine.getFormatedUnitPrice()}€</td>
                                <td class="column-4">${commandLine.getFormatedUnitDiscountPrice()}€</td>
                                <td class="column-5">
                                    <div class="flex-w bo5 of-hidden w-size17">
                                        <form class="inliner" action="/webshop/cart/minus/${commandLine.getProduct().getId()}" method="post">
                                            <button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                                <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                            </button>
                                        </form>
                                        <p class="size8 m-text18 t-center num-product">${commandLine.getQuantity()}</p>

                                        <form class="inliner" action="/webshop/cart/plus/${commandLine.getProduct().getId()}" method="post">
                                            <button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                                <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                            </button>
                                        </form>
                                    </div>
                                </td>
                                <td class="column-6">${commandLine.getFormatedPriceWithoutDiscount()}€</td>
                                <td class="column-6">${commandLine.getFormatedPriceWithDiscount()}€</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
            <!-- Total -->
            <div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
                <h5 class="m-text20 p-b-24 mt-2">
                    <spring:message code="cartTotal"/>
                </h5>
                <!--  -->
                <div class="flex-w flex-sb-m p-t-26 p-b-30">
                    <p><span class="m-text22 w-size19 w-full-sm"><spring:message code="totalPrice"/>:</span> <span class="m-text21 w-size20 w-full-sm">${cart.getFormatedWithoutDiscountTotal()}€</span></p>
                    <p><span class="m-text22 w-size19 w-full-sm"><spring:message code="totalSold"/>:</span> <span class="m-text21 w-size20 w-full-sm">${cart.getFormatedTotalDiscount()}€</span></p>
                    <p><span class="m-text22 w-size19 w-full-sm"><spring:message code="total"/>:</span> <span class="m-text21 w-size20 w-full-sm">${cart.getFormatedWithDiscountTotal()}€</span></p>
                </div>

                <div class="size15 trans-0-4">
                    <a shape="circle" href='<spring:url value="${cart.getFormatedWithDiscountTotal() != '0.00' ? '/cart/validate' : ''}"/>'>
                        <img src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt='<spring:message code="proceedCheckout"/>'>
                    </a>
                </div>
            </div>
        </div>
    </section>
</body>