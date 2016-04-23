<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Resolved</th>
        <th>Project Title</th>
        <th>Employees Amount</th>
        <th>Edit</th>
    </tr>
    <s:iterator value="works">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="description"/></td>
            <td><s:property value="startDate"/></td>
            <td><s:property value="endDate"/></td>
            <td><s:property value="resolved"/></td>
            <td><s:property value="project.title"/></td>
            <td><s:property value="employees.size()"/></td>
            <td><a href="edit/${id}">Edit</a></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">Add new work</a>

