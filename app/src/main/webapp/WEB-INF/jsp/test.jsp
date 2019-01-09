<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form
id="newUser"
method="POST"
action="/webshop/signup/register"
modelAttribute="newUser">
    <form:input path="username"/>
    <form:input path="password"/>
    <form:input path="firstName"/>
    <form:input path="lastName"/>
    <spring:message code="male" var="male"/>
    <form:radiobutton path="isMale" value="true" label="${male}"/>
    <spring:message code="female" var="female"/>
    <form:radiobutton path="isMale" value="false" cssStyle="margin-left: 10px;" label="${female}"/>
    <form:input path="birthdate"/>
    <form:input path="email"/>
    <form:input path="address"/>
    <form:button type="input"/>
</form:form>