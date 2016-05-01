<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="/signUp" theme="bootstrap" method="post">
    <label>First Name: </label><br/>
    <input type="text" class="form-control" name="firstName"/><br/>
    <label>Last Name: </label><br/>
    <input type="text" class="form-control" name="lastName"/><br/>
    <label>Email: </label><br/>
    <input type="text" class="form-control" name="email"/><br/>
    <label>Login: </label><br/>
    <input type="text" class="form-control" name="login"/><br/>
    <label>Password: </label><br/>
    <input type="password" class="form-control" name="password"/><br/>
    <s:submit cssClass="btn btn-block btn-primary" value="Sing Up"/>
</s:form>