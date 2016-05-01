<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<s:form action="create" theme="bootstrap" method="post">
    <label>First Name: </label><br/>
    <input type="text" class="form-control" name="firstName"/><br/>
    <label>Last Name: </label><br/>
    <input type="text" class="form-control" name="lastName"/><br/>
    <label>Email: </label><br/>
    <input type="email" class="form-control" name="email"/><br/>
    <label>Experience: </label><br/>
    <input type="number" class="form-control" step="0.1" name="experience"/><br/>
    <label>Position: </label><br/>
    <input type="text" class="form-control" name="position"/><br/>
    <s:select class="form-control smallInput" name="departmentId" label="Add to department:"
              list="departments" listKey="Id" listValue="Title" />
    <s:submit cssClass="btn btn-block btn-primary" value="Add employee"/>
</s:form>
