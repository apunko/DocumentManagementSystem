<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-xs-5">
<s:form action="create" theme="bootstrap" method="post">
    <div class="col-xs-6">
        <label>First Name: </label><br/>
        <input type="text" class="form-control" name="firstName" value="${user.firstName}"/><br/>
        <s:fielderror fieldName="firstName"/>
        <label>Last Name: </label><br/>
        <input type="text" class="form-control" name="lastName" value="${user.lastName}"/><br/>
        <s:fielderror fieldName="lastName"/>
    </div>
    <div class="col-xs-6">
        <label>Login: </label><br/>
        <input type="text" class="form-control" name="login" value="${user.login}"/><br/>
        <s:fielderror fieldName="login"/>
        <label>Experience: </label><br/>
        <input type="number" class="form-control" step="0.1" name="experience" value="${user.experience}"/><br/>
        <s:fielderror fieldName="experience"/>
    </div>
    <div class="col-xs-6">
        <label>Position: </label><br/>
        <input type="text" class="form-control" name="position" value="${user.position}"/><br/>
        <s:fielderror fieldName="position"/>
    </div>
    <div class="col-xs-6">
    <s:select class="form-control" name="departmentId" label="Add to department:"
              list="departments" listKey="Id" listValue="Name" />
    </div>
    <div class="col-xs-12">
        <label>Email: </label><br/>
        <input type="email" class="form-control" name="email" value="${user.email}"/><br/>
        <s:fielderror fieldName="email"/>
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Add employee"/>
</s:form>
</div>
