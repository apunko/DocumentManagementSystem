<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="update" theme="bootstrap" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <label>First Name: </label><br/>
    <input type="text" class="form-control" name="firstName" value="${user.firstName}"/><br/>
    <label>Last Name: </label><br/>
    <input type="text" class="form-control" name="lastName" value="${user.lastName}"/><br/>
    <label>Email: </label><br/>
    <input type="email" class="form-control" name="email" value="${user.email}"/><br/>
    <label>Experience: </label><br/>
    <input type="number" class="form-control" step="0.1" name="experience" value="${user.experience}"/><br/>
    <label>Position: </label><br/>
    <input type="text" class="form-control" name="position" value="${user.position}"/><br/>
    <s:select class="form-control smallInput" name="departmentId" label="Add to department:"
              list="departments" listKey="Id" listValue="Title" />
    <s:submit cssClass="btn btn-block btn-primary" value="Update employee"/>
</s:form>