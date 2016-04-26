<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <s:select name="clientId" label="Choose client:"
              list="clients" listKey="Id" listValue="FirstName" />
    <s:select name="payFormId" label="Choose Pay Form:"
              list="payForms" listKey="Id" listValue="Type"  />
    <s:select name="templateId" listKey="Id" label="Choose template for contract:"
              list="templates" listValue="Title"/>
    </br>
    <label for="paySum">Enter contract sum: </label>
    <input class="form-control smallInput" type="number" name="paySum" value="1000"/><br/>
    <label for="payDate">Enter pay date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="payDate"/><br/>
    <label for="startDate">Enter start date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="startDate"/><br/>
    <label for="endDate">Enter end date: </label>
    <input class="form-control smallInput newDateInput" type="date" name="endDate"/><br/>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
