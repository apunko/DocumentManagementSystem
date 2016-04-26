<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Name</th>
            <th>People amount</th>
            <th>View</th>
            <th>Edit</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="departments">
            <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="employees.size()"/></td>
                <td><a href="${id}">View</a></td>
                <td><a href="edit/${id}">Edit</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
<div>
    <a href="<s:url action="new" />">Add new Department</a>
</div>

