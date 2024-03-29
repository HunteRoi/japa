<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href='<spring:url value="/images/japa2.ico"/>'>
        <link rel="shortcut icon" href='<spring:url value="/images/japa2.ico"/>'>
        <title>${title}</title>

        <!-- Bootstrap Core -->
        <script src='<spring:url value="https://code.jquery.com/jquery-3.3.1.slim.min.js"/>'></script>
        <script src='<spring:url value="/js/bootstrap.min.js"/>'></script>
        <script src='<spring:url value="/js/anchor.min.js"/>'></script>
        <script src='<spring:url value="/js/main.js"/>'></script>
        <!--<script src='<spring:url value="https://getbootstrap.com/docs/4.2/dist/js/bootstrap.bundle.min.js"/>'></script>-->
        <script src='<spring:url value="/js/popper.min.js"/>'></script>

        <!-- Bootstrap CSS -->
        <link type="text/css" href='<spring:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

        <!-- Custom CSS -->
        <link type="text/css" href='<spring:url value="/css/main-style.css"/>' rel="stylesheet">
    </head>
    <body class="d-flex flex-column h-100">
        <header>
            <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                <a class="navbar-brand" href='<spring:url value="/home"/>'>
                    <img src='<spring:url value="/images/japa-logo.png"/>' height="75">
                </a>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="big-a nav-link" href='<spring:url value="/home"/>' onclick="swapActive()"><spring:message code="home"/></a>
                        </li>
                        <c:forEach var="category" items="${categories}">
                            <c:choose>
                                <c:when test="${!category.getHasNoChildren()}">
                                    <li class="nav-item dropdown clickable">
                                        <a class="big-a nav-link dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" onclick="swapActive()">${category.getName()}</a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                            <c:forEach var="subCategory" items="${category.getSubCategories()}">
                                                <a class="big-a dropdown-item" href='<spring:url value="/category/${category.getNormalizedName()}/${subCategory.getNormalizedName()}"/>'>${subCategory.getName()}</a>
                                            </c:forEach>
                                        </div>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <a class="big-a nav-link" href='<spring:url value="/category/${category.getNormalizedName()}"/>' role="button" aria-expanded="false" aria-haspopup="false" onclick="swapActive()">${category.getName()}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </ul>
                    <sec:authorize access="isAuthenticated()">
                        <p id="user">
                            <spring:message code="welcome"/> ${pageContext.request.userPrincipal.name}!
                        </p>
                    </sec:authorize>
                    <button type="button" onclick="location.href='<spring:url value="/cart/checkout"/>'" z-index="1" class="mr-1 btn btn-default navbar-btn">
                        <i class="fas ${cart.hasContent() ? 'fa-cart-arrow-down' : 'fa-shopping-cart'}"></i>
                    </button>
                    <div class="dropdown">
                        <button class="ml-1 mr-1 btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <spring:message code="language"/>
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                            <spring:url var="localeEn" value="">
                                <spring:param name="locale" value="en"/>
                            </spring:url>
                            <a class="dropdown-item" href="${localeEn}"><spring:message code="english"/></a>

                            <spring:url var="localeFr" value="">
                                <spring:param name="locale" value="fr"/>
                            </spring:url>
                            <a class="dropdown-item" href="${localeFr}"><spring:message code="french"/></a>
                        </div>
                    </div>
                    <sec:authorize access="!isAuthenticated()">
                        <button type="button" onclick="location.href='<spring:url value="/signin"/>'" class="ml-1 btn btn-default navbar-btn"><spring:message code="signin"/></button>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <button type="button" onclick="location.href='<spring:url value="/logout"/>'" class="ml-1 btn btn-default navbar-btn"><spring:message code="signout"/></button>
                    </sec:authorize>
                </div>
            </nav>
        </header>

        <main role="main" class="flex-shrink-0">
            <tiles:insertAttribute name="main-content" />
        </main>

        <footer class="footer text-muted mt-auto">
            <div class="container-fluid pt-3 pb-2">
                <ul class="footer-links">
                    <li><a href="https://facebook.com/" target="_blank">Facebook</a></li>
                    <li><a href="https://twitter.com/" target="_blank">Twitter</a></li>
                    <li><a href='<spring:url value="/terms"/>'><spring:message code="legalterms"/></a></li>
                </ul>
                <p><spring:message code="footertext"/></p>
                <p><i class="far fa-copyright"></i> <spring:message code="copyright"/></p>
            </div>
        </footer>
    </body>
</html>
