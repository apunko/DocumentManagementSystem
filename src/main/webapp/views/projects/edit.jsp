<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-xs-5">
<s:form action="update" theme="bootstrap" method="post">
    <input type="hidden" name="id" value="${project.id}">
    <label>Title: </label><br/>
    <input type="text"  class="form-control"  name="title" value="${project.title}"/><br/>
    <s:fielderror fieldName="title"/>
    <label>Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${project.description}</textarea><br/>
    <s:fielderror fieldName="description"/>
    <div class="col-xs-6">
        <label>Plan end of project: </label><br/>
        <input type="date" class="form-control smallInput" name="planEndDate" date-value="${project.stringPlanEndDate}"/><br/>
        <s:fielderror fieldName="planEndDate"/>
    </div>
    <div class="col-xs-6">
        <s:select class="form-control smallInput editDateInput" name="contractId" label="Belongs to contract Number:"
                  list="contracts" listKey="Id" listValue="Id" value="contractId" />
    </div>
    <div class="col-xs-12">
        <s:select name="employeeIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName" />
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Update"/>
</s:form>
</div>