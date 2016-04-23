<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/projects/create" method="post">
    <label for="title">Title: </label><br/>
    <input type="text" name="title"/><br/>
    <label for="description">Description: </label><br/>
    <input type="text" name="description"/><br/>
    <label for="planEndDate">End Date: </label><br/>
    <input type="date" name="planEndDate"/><br/>
    <s:select name="contractId" label="Contract Number:"
              list="contracts" listKey="Id" listValue="Id" />
    <s:select name="employeeIds" multiple="true" listKey="Id" label="Employees:"
              list="employees" listValue="FirstName"/>
    <input type="submit" value="Create"/>
</form>
