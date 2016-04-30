<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="update" theme="bootstrap" method="post">
    <input type="hidden" name="id" value="${department.id}">
    <label>Department Name: </label>
    <input type="text" class="form-control" name="name" value="${department.name}" /><br/>
    <label>Department Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${department.description}</textarea><br/>
    <s:submit cssClass="btn btn-block btn-primary" value="Update"/>
</s:form>