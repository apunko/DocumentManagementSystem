<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label>Department Name: </label>
    <input type="text" class="form-control" name="name" value="${department.name}"/><br/>
    <s:fielderror fieldName="name"/>
    <label>Department Description: </label>
    <textarea class="form-control" rows="5" name="description">${department.description}</textarea><br/>
    <s:fielderror fieldName="description"/>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
