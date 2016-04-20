<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/contracts/create" method="post">
    <s:select name="payFormId" label="Pay Form:"
              list="payForms" listKey="Id" listValue="Type"  />
    <s:select name="clientId" label="Client:"
              list="clients" listKey="Id" listValue="FirstName" />
    <s:select name="templateId" listKey="Id" label="Template:"
              list="templates" listValue="Title"/>
    </br>
    <label for="paySum">Pay Sum: </label><br/>
    <input type="number" name="paySum"/><br/>
    <label for="payDate">Pay Date: </label><br/>
    <input type="date" name="payDate"/><br/>
    <label for="startDate">Start Date: </label><br/>
    <input type="date" name="startDate"/><br/>
    <label for="endDate">End Date: </label><br/>
    <input type="date" name="endDate"/><br/>
    <input type="submit" value="Create"/>
</form>
