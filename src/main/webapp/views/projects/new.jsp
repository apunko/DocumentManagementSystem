<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label>Title: </label><br/>
    <input type="text"  class="form-control"  name="title" value="${project.title}"/><br/>
    <s:fielderror fieldName="title"/>
    <label>Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${project.description}</textarea><br/>
    <s:fielderror fieldName="description"/>
    <div class="col-xs-4">
        <label>Plan end of project: </label><br/>
        <input type="date" class="form-control smallInput newDateInput" name="planEndDate"  value="${project.planEndDate}"/><br/>
        <s:fielderror fieldName="planEndDate"/>
    </div>
    <div class="col-xs-4">
        <s:select class="form-control smallInput" name="contractId" label="Belongs to contract Number:"
                  list="contracts" listKey="Id" listValue="Id" value="contractId" />
        <s:fielderror fieldName="contractId"/>
    </div>
    <div class="col-xs-4">
        <s:select name="employeeIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName"/>
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
