<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="departments.size() == 0">
    <h4>There are no departments yet!</h4>
</s:if>
<s:else>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>Name</th>
            <th>People amount</th>
            <th>View</th>
            <th>Edit</th>
            <th>Download</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="departments">
            <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="employees.size()"/></td>
                <td><a href="${id}">View</a></td>
                <td><a href="edit/${id}">Edit</a></td>
                <td><a href="download/${id}">Download</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</s:else>
<div>
    <a href="<s:url action="new" />">Add new Department</a>
    | <s:a href="/departments/downloadAllXml">Download all Departments in XML</s:a>
    | <s:a href="/departments/downloadAllCsv">Download all Departments in CSV</s:a>
</div>

