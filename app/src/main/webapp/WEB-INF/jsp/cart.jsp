<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<head>
    <style>
        .imgCar{
            width : 150px;
            height: 250px;
        }
    </style>
</head>
<body>
<section class="cart bgwhite p-t-70 p-b-100">
    <div class="container">
        <!-- Cart item -->
        <div class="container-table-cart pos-relative">
            <div class="wrap-table-shopping-cart bgwhite">
                <table class="table-shopping-cart">
                    <tr class="table-head">
                        <th class="column-1"></th>
                        <th class="column-2">Product</th>
                        <th class="column-3">Price</th>
                        <th class="column-4 p-l-70">Quantity</th>
                        <th class="column-5">Total</th>
                    </tr>
                    <c:forEach var="commandLine" items="${products}">
                        <tr class="table-row">
                            <td class="column-1">
                                <div class="cart-img-product b-rad-4 o-f-hidden">
                                    <img class="imgCar" src="${commandLine.getProduct().getImageUrl()}" alt="IMG-PRODUCT">
                                </div>
                            </td>
                            <td class="column-2">${commandLine.getProduct().getName()}</td>
                            <td class="column-3">${commandLine.getProduct().getFormatedProductPrice()}€</td>
                            <td class="column-4">
                                <div class="flex-w bo5 of-hidden w-size17">
                                    <form action="/webshop/cart/minus/${commandLine.getProduct().getId()}" method="post">
                                        <button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
                                            <i class="fs-12 fa fa-minus" aria-hidden="true"></i>
                                        </button>
                                    </form>
                                    <p class="size8 m-text18 t-center num-product">${commandLine.getQuantity()}</p>

                                    <form action="/webshop/cart/plus/${commandLine.getProduct().getId()}" method="post">
                                        <button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
                                            <i class="fs-12 fa fa-plus" aria-hidden="true"></i>
                                        </button>
                                    </form>
                                </div>
                            </td>
                            <td class="column-5">${commandLine.getFormatedLinePrice()}€</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
        <!-- Total -->
        <div class="bo9 w-size18 p-l-40 p-r-40 p-t-30 p-b-38 m-t-30 m-r-0 m-l-auto p-lr-15-sm">
            <h5 class="m-text20 p-b-24">
                Cart Totals
            </h5>
            <!--  -->
            <div class="flex-w flex-sb-m p-t-26 p-b-30">
					<span class="m-text22 w-size19 w-full-sm">
						Total:
					</span>

                <span class="m-text21 w-size20 w-full-sm">
						IMPROVE LATER
					</span>
            </div>

            <div class="size15 trans-0-4">
                <!-- Button -->
                <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
                    <spring:message code="proceedCheckout"/>
                </button>
            </div>
        </div>
    </div>
</section>
</body>