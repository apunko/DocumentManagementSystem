<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Clients: </h2>
    <table class="table table-bordered">
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>View</th>
        </tr>
        <s:iterator value="clients">
            <tr>
                <td><s:property value="fullName"/></td>
                <td><s:property value="email"/></td>
                <td><a href="edit/${id}">Edit</a></td>
            </tr>
        </s:iterator>
    </table>
<h2>Employees: </h2>
<table class="table table-bordered">
    <tr>
        <th>Full Name</th>
        <th>Passport</th>
        <th>Email</th>
        <th>Position</th>
        <th>Experience</th>
        <th>Department</th>
        <th>View</th>
        <th>Edit</th>
    </tr>
    <s:iterator value="employees" var="employee">
        <tr>
            <td><s:property value="fullName"/></td>
            <td><s:property value="passport"/></td>
            <td><s:property value="email"/></td>
            <td><s:property value="position"/></td>
            <td><s:property value="experience"/></td>
            <td>${employee.department.name}</td>
            <td><a href="${id}">View</a></td>
            <td><a href="edit/${id}">Edit</a></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">Add employee</a>

