<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp" %>

<body>
<div class="container">


        <fieldset>

            <!-- Form Name -->
            <legend><spring:message code="signup"/></legend>
            <p class="required legend">* : <spring:message code="legend"/></p>

            <!-- Text input-->

            <form:form
                    id="newUser"
                    method="POST"
                    action="/webshop/signup/register"
                    modelAttribute="newUser">

                    <div class="form-group">
                        <form:label path="username" class="col-md-4 control-label"><spring:message code="username"/><span class="required">*</span></form:label>
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
                        <form:label path="password" class="col-md-4 control-label"><spring:message code="password"/><span class="required">*</span></form:label>
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
                    <form:label path="checkPassword" class="col-md-4 control-label"><spring:message code="passwordValidation"/><span class="required">*</span></form:label>
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
                    <form:label path="favoriteMangaCategory" class="col-md-4 control-label"><spring:message code="favoriteMangaCategory"/></form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input  path="favoriteMangaCategory" name="favoriteMangaCategory" class="form-control"  type="password"/>
                        </div>
                    </div>
                </div>

                    <div class="form-group">
                        <form:label path="firstName" class="col-md-4 control-label"><spring:message code="firstName"/><span class="required">*</span></form:label>
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

                <div class="form-group">
                    <form:label path="lastName" class="col-md-4 control-label"><spring:message code="lastName"/><span class="required">*</span></form:label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input  path="lastName" name="lastName" class="form-control"  type="text"/>
                        </div>
                        <p class="error">
                            <form:errors path="lastName"/>
                        </p>
                    </div>
                </div>

                    <!-- Text input-->



                    <div class="form-group">
                        <form:label path="phoneNumber" class="col-md-4 control-label" ><spring:message code="phoneNumber"/><span class="required">*</span></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <spring:message var="phonePattern" code="phonePattern"/>
                                <form:input path="phoneNumber" name="phoneNumber"  class="form-control"  type="text" placeholder="${phonePattern}"/>
                            </div>
                            <p class="error">
                                <form:errors path="phoneNumber"/>
                            </p>
                        </div>
                    </div>


                    <!-- Text input-->
                    <div class="form-group">
                        <form:label path="email" class="col-md-4 control-label">E-mail<span class="required">*</span></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                <spring:message var="emailPattern" code="emailPattern"/>
                                <form:input path="email" name="email"  class="form-control"  type="text" placeholder="${emailPattern}"/>
                            </div>
                            <p class="error">
                                <form:errors path="email"/>
                            </p>
                        </div>
                    </div>

                    <!-- Text input-->

                    <div class="form-group">
                        <form:label path="address" class="col-md-4 control-label"><spring:message code="address"/><span class="required">*</span></form:label>
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                <form:input path="address" name="address"  class="form-control" type="text"/>
                            </div>
                            <p class="error">
                                <form:errors path="address"/>
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