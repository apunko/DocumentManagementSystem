<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Login</th>
        <th>Passport</th>
        <th>Role</th>
        <th>Position</th>
        <th>Experience</th>
        <th>Department Id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <s:iterator value="users">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
            <td><s:property value="login"/></td>
            <td><s:property value="passport"/></td>
            <td><s:property value="role"/></td>
            <td><s:property value="position"/></td>
            <td><s:property value="experience"/></td>
            <td><s:property value="departmentId"/></td>
            <td><a href="edit/${id}">Edit</a></td>
            <td><a href="delete/${id}" methods="delete">Delete</a></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">New</a>

