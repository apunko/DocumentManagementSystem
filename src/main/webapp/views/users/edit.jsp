<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/users/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label for="firstName">First Name: </label><br/>
    <input type="text" name="firstName" value="${user.firstName}"/><br/>
    <label for="lastName">Last Name: </label><br/>
    <input type="text" name="lastName" value="${user.lastName}"/><br/>
    <input type="submit" value="Update"/>
</form>
