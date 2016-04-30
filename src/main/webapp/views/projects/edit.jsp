<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="update" theme="bootstrap" method="post">
    <input type="hidden" name="id" value="${project.id}">
    <label>Title: </label><br/>
    <input type="text"  class="form-control"  name="title" value="${project.title}"/><br/>
    <label>Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${project.description}</textarea><br/>
    <div class="col-xs-4">
        <label>Plna end of project: </label><br/>
        <input type="date" class="form-control smallInput" name="planEndDate" value="${project.planEndDate}"/><br/>
    </div>
    <div class="col-xs-4">
        <s:select class="form-control smallInput editDateInput" name="contractId" label="Belongs to contract Number:"
                  list="contracts" listKey="Id" listValue="Id" value="contractId" />
    </div>
    <div class="col-xs-4">
        <s:select name="employeeIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName" />
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Update"/>
</s:form>
