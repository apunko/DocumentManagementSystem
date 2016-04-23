<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/works/create" method="post">
    <label for="title">Title: </label><br/>
    <input type="text" name="title"/><br/>
    <label for="description">Description: </label><br/>
    <input type="text" name="description"/><br/>
    <label for="startDate">Start Date: </label><br/>
    <input type="date" name="startDate"/><br/>
    <label for="endDate">End Date: </label><br/>
    <input type="date" name="endDate"/><br/>
    <s:select name="projectId" label="Project:"
              list="projects" listKey="Id" listValue="Title" />
    <s:select name="employeesIds" multiple="true" listKey="Id" label="Employees:"
              list="employees" listValue="FirstName"/>
    <input type="submit" value="Create"/>
</form>
