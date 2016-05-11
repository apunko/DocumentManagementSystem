<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-xs-5">
<s:form action="signUp" theme="bootstrap" method="post">
    <label>First Name: </label><br/>
    <input type="text" class="form-control" name="firstName" value="${user.firstName}" /><br/>
    <s:fielderror fieldName="firstName"/>
    <label>Last Name: </label><br/>
    <input type="text" class="form-control" name="lastName" value="${user.lastName}" /><br/>
    <s:fielderror fieldName="lastName"/>
    <label>Email: </label><br/>
    <input type="text" class="form-control" name="email" value="${user.email}"/><br/>
    <s:fielderror fieldName="email"/>
    <label>Login: </label><br/>
    <input type="text" class="form-control" name="login" value="${user.login}"/><br/>
    <s:fielderror fieldName="login"/>
    <label>Password: </label><br/>
    <input type="password" class="form-control" name="password"/><br/>
    <s:fielderror fieldName="password"/>
    <s:submit cssClass="btn btn-block btn-primary" value="Sing Up"/>
</s:form>
</div>