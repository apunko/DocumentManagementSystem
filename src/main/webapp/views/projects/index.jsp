<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="projects.size() == 0">
    <h4>There are no projects yet!</h4>
</s:if>
<s:else>
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
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
        <s:iterator value="projects">
            <tr>
                <td><s:property value="title"/></td>
                <td><a href="/contracts/<s:property value="contract.id"/>">&#8470;<s:property value="contract.id"/></a></td>
                <td><s:property value="works.size()"/></td>
                <td><s:property value="employees.size()"/></td>
                <td><s:property value="stringPlanEndDate"/></td>
                <td><a href="${id}">View</a></td>
                <td><a href="edit/${id}">Edit</a></td>
                <td><a href="delete/${id}">Delete</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</s:else>
<div>
    <a href="<s:url action="new" />">Add new Project</a>
</div>

