<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="clients.size() == 0">
    <h4>There are no clients yet!</h4>
</s:if>
<s:else>
<h2>Clients: </h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Email</th>
                <th>View</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="clients">
            <tr>
                <td><s:property value="fullName"/></td>
                <td><s:property value="email"/></td>
                <td><a href="${id}">View</a></td>
                <td><a href="edit/${id}">Edit</a></td>
                <td><a href="delete/${id}" class="needConfirmation">Delete</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:else>
<s:if test="employees.size() == 0">
    <h4>There are no employees yet!</h4>
</s:if>
<s:else>
<h2>Employees: </h2>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Position</th>
            <th>Experience</th>
            <th>Department</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Make manager</th>
        </tr>
    </thead>
    <tbody>
    <s:iterator value="employees" var="employee">
        <tr>
            <td><s:property value="fullName"/></td>
            <td><s:property value="email"/></td>
            <td><s:property value="position"/></td>
            <td><s:property value="experience"/></td>
            <td>${employee.department.name}</td>
            <td><a href="${id}">View</a></td>
            <td><a href="edit/${id}">Edit</a></td>
            <td><a href="delete/${id}" class="needConfirmation">Delete</a></td>
            <td><a href="makeManager/${id}" class="needConfirmation">Make manager</a></td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</s:else>
<a href="<s:url action="new" />">Add employee</a>

