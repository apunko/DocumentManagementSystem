<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label>First Name: </label><br/>
    <input type="text" class="form-control" name="firstName" value="${user.firstName}"/><br/>
    <s:fielderror fieldName="firstName"/>
    <label>Last Name: </label><br/>
    <input type="text" class="form-control" name="lastName" value="${user.lastName}"/><br/>
    <s:fielderror fieldName="lastName"/>
    <label>Email: </label><br/>
    <input type="email" class="form-control" name="email" value="${user.email}"/><br/>
    <s:fielderror fieldName="email"/>
    <label>Experience: </label><br/>
    <input type="number" class="form-control" step="0.1" name="experience" value="${user.experience}"/><br/>
    <s:fielderror fieldName="experience"/>
    <label>Position: </label><br/>
    <input type="text" class="form-control" name="position" value="${user.position}"/><br/>
    <s:fielderror fieldName="position"/>
    <s:select class="form-control smallInput" name="departmentId" label="Add to department:"
              list="departments" listKey="Id" listValue="Name" />
    <s:submit cssClass="btn btn-block btn-primary" value="Add employee"/>
</s:form>
