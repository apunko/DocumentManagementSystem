<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <s:select name="clientId" label="Choose client:"
              list="clients" listKey="Id" listValue="fullName" value="%{contract.client.fullName}"/>
    <s:select name="payFormId" label="Choose Pay Form:"
              list="payForms" listKey="Id" listValue="Type" value="%{contract.payForm.type}" />
    <s:select name="templateId" listKey="Id" label="Choose template for contract:"
              list="templates" listValue="Title" value="%{contract.template.title}"/>
    </br>
    <label>Enter contract sum: </label>
    <input class="form-control smallInput" type="number" name="paySum" value="${contract.paySum}"/><br/>
    <s:fielderror fieldName="paySum"/>
    <label>Enter pay date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="payDate" date-value="${contract.stringPayDate}" /><br/>
    <s:fielderror fieldName="payDate"/>
    <label>Enter start date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="startDate" date-value="${contract.stringStartDate}" /><br/>
    <s:fielderror fieldName="startDate"/>
    <label>Enter end date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="endDate" date-value="${contract.stringEndDate}" /><br/>
    <s:fielderror fieldName="endDate"/>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
