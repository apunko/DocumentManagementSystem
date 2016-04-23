<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Plan End date</th>
        <th>Contract Number</th>
        <th>Works</th>
        <th>Edit</th>
    </tr>
    <s:iterator value="projects">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="description"/></td>
            <td><s:property value="planEndDate"/></td>
            <td><s:property value="contract.id"/></td>
            <td><s:property value="worksTitles"/></td>
            <td><a href="edit/${id}">Edit</a></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">Add new project</a>


