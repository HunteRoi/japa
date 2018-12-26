<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <body>
        <div class="full-center">
            <div class="text-center">
                <a href='<spring:url value="/home"/>'>
                    <img class="mb-2" src='<spring:url value="/images/japa2.png"/>' alt="Japa logo" width="164" height="164">
                </a>
                <h1 class="inliner"><spring:message code="signin"/></h1>
                <span class="inliner or"><spring:message code="or"/></span>
                <a href='<spring:url value="/signup"/>'><spring:message code="signup"/></a>
            </div>

            <form:form class="form-signin"
                       method="POST"
                       modelAttribute="current_user">
                <div class="form-label-group">
                    <form:input path="username" type="text" id="username" class="form-control" placeholder='<spring:message code="username"/>' required="" autofocus=""/>
                    <form:label type="text" for="username" path="username"><spring:message code="username"/></form:label>
                </div>

                <div class="form-label-group mb-3">
                    <form:input path="password" type="password" id="password" class="form-control" placeholder='<spring:message code="password"/>' required="" autocomplete="false"/>
                    <form:label path="password" for="password"><spring:message code="password"/></form:label>
                </div>

                <form:button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signin"/></form:button>
            </form:form>
        </div>
    </body>
</html>