<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>
<html>
    <head>
    </head>
    <body>

        <div class="text-center mb-4">
            <p><img class="mb-4" src='<spring:url value="/images/japa2.png"/>' alt="Japa logo" width="72" height="72"></p>
            <h1 class="inliner"><spring:message code="signin"/></h1>
            <span class="inliner or"><spring:message code="or"/></span>
            <a href=''><spring:message code="signup"/></a>
            <br/>
            <p>ID Japa.com :</p>
        </div>

        <form:form class="form-signin"
                   method="POST"
                   modelAttribute="current_user">

            <div class="form-label-group">
                <form:input path="username" type="text" id="username" class="form-control" placeholder='<spring:message code="username"/>' required="" autofocus=""/>
                <form:label type="text" for="username" path="username"><spring:message code="username"/></form:label>
            </div>

            <div class="form-label-group">
                <form:input path="password" type="password" id="password" class="form-control" placeholder='<spring:message code="password"/>' required="" autocomplete="false"/>
                <form:label path="password" for="password"><spring:message code="password"/></form:label>
            </div>
            <form:button style="margin-left: auto; margin-right: auto"  class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="signin"/></form:button>
            <p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
        </form:form>

    </body>
</html>