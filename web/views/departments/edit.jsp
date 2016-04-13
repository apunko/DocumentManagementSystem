<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <form action="/departments/update" method="post">
        <input type="hidden" name="id" value="${department.id}">
        <label for="name">Department Name: </label><br/>
        <input type="text" name="name" value="${department.name}"/><br/>
        <label for="description">Department Description: </label><br/>
        <input type="text" name="description" value="${department.description}"/><br/>
        <input type="submit" value="Update"/>
    </form>
</body>
</html>
