<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
        <style>
            .error{
                color:red;
            }
        </style>
    </head>
    <body>
        <div class="full-center">
            <div class="text-center mb-4">
                <a href='<spring:url value="/home"/>'>
                    <img class="mb-2" src='<spring:url value="/images/japa2.png"/>' alt="Japa logo" width="164" height="164">
                </a>
                <h1 class="inliner"><spring:message code="signin"/></h1>
                <span class="inliner or"><spring:message code="or"/></span>
                <a href='<spring:url value="/signup"/>'><spring:message code="signup"/></a>
            </div>

            <form:form class="signinForm" method="POST" modelAttribute="currentUser">
                <div class="form-label-group">
                    <form:input path="username" type="text" id="username" class="form-control" placeholder='<spring:message code="username"/>' required="" autofocus=""/>
                    <form:label type="text" for="username" path="username"><spring:message code="username"/></form:label>
                    <form:errors path="username"/>
                </div>

                <div class="form-label-group mb-4">
                    <form:input path="password" type="password" id="password" class="form-control" placeholder='<spring:message code="password"/>' required="" autocomplete="false"/>
                    <form:label path="password" for="password"><spring:message code="password"/></form:label>
                    <form:errors path="password"/>
                </div>

                <c:if test="${param.error != null}">
                    <div id="error "class="form-label-group mb-4">
                        <p class="error">
                            <spring:message code="loginError"/>
                        </p>
                    </div>
                </c:if>

                <form:button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signin"/></form:button>
            </form:form>
        </div>
    </body>
</html>
