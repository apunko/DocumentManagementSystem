<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1">
    <tr>
        <th>Id(№)</th>
        <th>Pay Date</th>
        <th>Pay Sum</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Client Id</th>
        <th>Template Id</th>
        <th>Pay Form Id</th>
    </tr>
    <s:iterator value="contracts">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="payDate"/></td>
            <td><s:property value="paySum"/></td>
            <td><s:property value="startDate"/></td>
            <td><s:property value="endDate"/></td>
            <td><s:property value="clientId"/></td>
            <td><s:property value="templateId"/></td>
            <td><s:property value="payFormId"/></td>
        </tr>
    </s:iterator>
</table>
<a href="<s:url action="new" />">New</a>

