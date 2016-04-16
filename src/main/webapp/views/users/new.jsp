<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/users/create" method="post">
    <label for="firstName">First Name: </label><br/>
    <input type="text" name="firstName"/><br/>
    <label for="lastName">Last Name: </label><br/>
    <input type="text" name="lastName"/><br/>
    <label for="role">Role: </label><br/>
    <input type="text" name="role"/><br/>
    <label for="experience">Experience: </label><br/>
    <input type="number" step="0.1" name="experience"/><br/>
    <label for="position">position: </label><br/>
    <input type="text" name="position"/><br/>
    <label for="departmentId">Department id: </label><br/>
    <input type="number" name="departmentId"/><br/>
    <input type="submit" value="Create"/>
</form>
