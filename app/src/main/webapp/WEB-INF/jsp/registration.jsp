<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<body>
<div class="container">


        <fieldset>

            <!-- Form Name -->
            <legend><spring:message code="signup"/></legend>

            <!-- Text input-->

            <form:form
                    id="newUser"
                    method="POST"
                    action="/webshop/signup/register"
                    modelAttribute="newUser">

                    <div class="form-group">
                        <form:label path="username" class="col-md-4 control-label"><spring:message code="username"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <form:input  path="username" name="username"  class="form-control"  type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="username"/>
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="password" class="col-md-4 control-label"><spring:message code="password"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <form:input  path="password" name="password" class="form-control"  type="password"/>
                            </div>
                            <p class="error">
                                <form:errors path="password"/>
                            </p>
                        </div>
                    </div>

                <div class="form-group">
                    <form:label path="password" class="col-md-4 control-label"><spring:message code="passwordValidation"/></form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input  path="checkPassword" name="checkPassword" class="form-control"  type="password"/>
                        </div>
                        <p class="error">
                            <form:errors path="checkPassword"/>
                        </p>
                    </div>
                </div>

                    <div class="form-group">
                        <form:label path="firstName" class="col-md-4 control-label"><spring:message code="firstName"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <form:input  path="firstName" name="first_name" class="form-control"  type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="firstName"/>
                            </p>
                        </div>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <form:label path="lastName" class="col-md-4 control-label" ><spring:message code="lastName"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <form:input path="lastName" name="last_name"  class="form-control"  type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="lastName"/>
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="birthdate" class="col-md-4 control-label"><spring:message code="birthdate"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope" ></i></span>
                                <spring:message code="datePattern" var="datePattern"/>
                                <form:input path="birthdate" name="birthdate"  class="form-control"  placeholder='${datePattern}' type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="birthdate"/>
                            </p>
                        </div>
                    </div>

                    <div class="form-group">
                        <form:label path="isMale" class="col-md-4 control-label"><spring:message code="sex"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                <spring:message code="male" var="male"/>
                                <form:radiobutton path="isMale" value="true" label=" ${male}"/>
                                <spring:message code="female" var="female"/>
                                <form:radiobutton path="isMale" value="false" cssStyle="margin-left: 10px;" label=" ${female}"/>
                            </div>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <form:label path="email" class="col-md-4 control-label">E-mail</form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                <form:input path="email" name="email"  class="form-control"  type="email"/>
                            </div>
                            <p class="error">
                                <form:errors path="email"/>
                            </p>
                        </div>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <form:label path="address" class="col-md-4 control-label"><spring:message code="address"/></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                <form:input path="address" name="address"  class="form-control" type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="username"/>
                            </p>
                        </div>
                    </div>

                    <!-- Button -->
                   <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <form:button type="submit" class="btn btn-warning" ><spring:message code="signup"/><span class="glyphicon glyphicon-send"></span></form:button>
                        </div>
                    </div>
                </form:form>
        </fieldset>

</div>
</div><!-- /.container -->
</body>