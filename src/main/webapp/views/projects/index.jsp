<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Title</th>
        <th>On contract</th>
        <th>Works amount</th>
        <th>Employees amount</th>
        <th>Plan end date</th>
        <th>View</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
        <s:iterator value="projects" var="project">
            <tr>
                <td><s:property value="title"/></td>
                <td><a href="/contracts/${project.contract.id}">&#8470;${project.contract.id}</a></td>
                <td><s:property value="works.size()"/></td>
                <td><s:property value="employees.size()"/></td>
                <td><s:property value="stringPlanEndDate"/></td>
                <td><a href="${id}">View</a></td>
                <td><a href="edit/${id}">Edit</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
<div>
    <a href="<s:url action="new" />">Add new Project</a>
</div>

