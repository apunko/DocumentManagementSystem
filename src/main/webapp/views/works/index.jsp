<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="works.size() == 0">
    <h4>There are no works yet!</h4>
</s:if>
<s:else>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Belongs to project</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Employees Amount</th>
        <th>View</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>Download Pdf<th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="works" var="work">
        <tr>
            <td><s:property value="title"/></td>
            <td><s:property value="description"/></td>
            <td><a href="/projects/<s:property value="project.id"/>"><s:property value="project.title"/></a></td>
            <td><s:property value="stringStartDate"/></td>
            <td><s:property value="stringEndDate"/></td>
            <td><s:property value="employees.size()"/></td>
            <td><a href="${id}">View</a></td>
            <td><a href="edit/${id}">Edit</a></td>
            <td><a href="delete/${id}" class="needConfirmation">Delete</a></td>
            <td><a href="download/${id}">Download</a></td>
        </tr>
    </s:iterator>
    </tbody>
</table>
</s:else>
<a href="<s:url action="new" />">Add new work</a>
| <s:a href="/works/downloadAllXml">Download all Works in XML</s:a>
| <s:a href="/works/downloadAllCsv">Download all Works in CSV</s:a>

