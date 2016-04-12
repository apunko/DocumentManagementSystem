<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 4/12/2016
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Departments</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <s:iterator value="departments">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="description"/></td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
