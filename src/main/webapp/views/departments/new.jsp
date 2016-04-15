<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New</title>
</head>
<body>
    <form action="/departments/create" method="post">
        <label for="name">Department Name: </label><br/>
        <input type="text" name="name"/><br/>
        <label for="description">Department Description: </label><br/>
        <input type="text" name="description"/><br/>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
