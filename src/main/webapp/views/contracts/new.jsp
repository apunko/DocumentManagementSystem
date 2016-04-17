<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/contracts/create" method="post">
    <s:select name="payFormType" label="Pay Form:"
              list="${payFormTypes}" />
    <s:select name="clientName" label="Client:"
              list="${clientNames}" />
    <s:select name="templateTitle" label="Template:"
              list="${templateTitles}" />
    <label for="paySum">Pay Sum: </label><br/>
    <input type="number" name="paySum"/><br/>
    <label for="payDate">Pay Date: </label><br/>
    <input type="date" name="payDate"/><br/>
    <label for="startDate">Start Date: </label><br/>
    <input type="date" name="startDate"/><br/>
    <label for="endDate">End Date: </label><br/>
    <input type="date" name="endDate"/><br/>
    <label for="description">Department Description: </label><br/>
    <input type="text" name="description"/><br/>
    <input type="submit" value="Create"/>
</form>
