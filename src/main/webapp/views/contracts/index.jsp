<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:if test="contracts.size() == 0">
    <h4>There are no contracts yet!</h4>
</s:if>
<s:else>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>&#8470;</th>
                <th>Client</th>
                <th>Template type</th>
                <th>Pay Form</th>
                <th>Pay Sum</th>
                <th>Pay Date</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>View</th>
                <th>Download</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="contracts" var="contract">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="client.fullName"/></td>
                    <td><s:property value="template.title"/></td>
                    <td><s:property value="payForm.type"/></td>
                    <td><s:property value="paySum"/></td>
                    <td><s:property value="stringPayDate"/></td>
                    <td><s:property value="stringStartDate"/></td>
                    <td><s:property value="stringEndDate"/></td>
                    <td><a href="/contracts/${contract.id}">View</a></td>
                    <td><a href="/contracts/download/${contract.id}">Download</a></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</s:else>
<div>
    <a href="<s:url action="new" />">Add new Contract</a>
    | <s:a href="/contracts/downloadAllXml">Download all Contracts in XML</s:a>
    | <s:a href="/contracts/downloadAllCsv">Download all Contracts in CSV</s:a>
</div>

