<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/users/signUp" method="post">
    <label for="firstName">First Name: </label><br/>
    <input type="text" name="firstName"/><br/>
    <label for="lastName">Last Name: </label><br/>
    <input type="text" name="lastName"/><br/>
    <label for="login">Login: </label><br/>
    <input type="text" name="login"/><br/>
    <label for="password">Password: </label><br/>
    <input type="password" name="password"/><br/>
    <input type="submit" value="Sign Up"/>
</form>