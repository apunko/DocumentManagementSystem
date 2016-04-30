<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Belongs to project</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Resolved</th>
        <th>Employees Amount</th>
        <th>View</th>
        <th>Edit</th>
    </tr>
    <s:iterator value="works" var="work">
        <tr>
            <td><s:property value="title"/></td>
            <td><s:property value="description"/></td>
            <td><a href="/projects/${work.project.id}">${work.project.title}</a></td>
            <td><s:property value="stringStartDate"/></td>
            <td><s:property value="stringEndDate"/></td>
            <td><s:property value="resolved"/></td>
            <td><s:property value="employees.size()"/></td>
            <td><a href="${id}">View</a></td>
            <td><a href="edit/${id}">Edit</a></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">Add new work</a>

