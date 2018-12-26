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
        <script src='<spring:url value="/js/anchor.min.js"/>'></script>

        <!-- Bootstrap CSS -->
        <link type="text/css" href='<spring:url value="/css/bootstrap.min.css"/>' rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

        <!-- Custom CSS -->
        <link type="text/css" href='<spring:url value="/css/main-style.css"/>' rel="stylesheet">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <a class="navbar-brand" href='<spring:url value="/home"/>'>
                    <img src='<spring:url value="/images/japa-logo.png"/>' height="75">
                </a>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav m-auto">
                        <li class="nav-item">
                            <a class="big-a nav-link active" href='<spring:url value="/home"/>'><spring:message code="home"/> <span class="sr-only">(current)</span></a>
                        </li>
                        <c:forEach var="category" items="${categories}">
                        <li class="nav-item dropdown">
                            <a class="big-a nav-link dropdown-toggle" href="" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${category.getName()}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <c:forEach var="subCategory" items="${category.getSubCategories()}">
			                        <a class="big-a dropdown-item" href='<spring:url value="/${category.getNormalizedName()}/${subCategory.getNormalizedName()}"/>'>${subCategory.getName()}</a>
                                </c:forEach>
                            </div>
                        </li>
                        </c:forEach>
                    </ul>
                    <button type="button" onclick="location.href='<spring:url value="/checkout"/>'" z-index="1" class="mr-1 btn btn-default navbar-btn">
                        <i class="fas fa-shopping-cart"></i>
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
                    <button type="button" onclick="location.href='<spring:url value="/login"/>'" class="ml-1 btn btn-default navbar-btn"><spring:message code="signin"/></button>
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

        <!-- Bootstrap Core -->
        <script src='<spring:url value="/js/popper.min.js"/>'></script>
        <script src='<spring:url value="/js/jquery.min.js"/>'></script>
        <script src='<spring:url value="/js/bootstrap.bundle.min.js"/>'></script>
    </body>
</html>
