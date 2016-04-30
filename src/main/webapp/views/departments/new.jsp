<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label>Department Name: </label>
    <input type="text" class="form-control" name="name"/><br/>
    <label>Department Description: </label>
    <textarea class="form-control" rows="5" name="description"></textarea><br/>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
