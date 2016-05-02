<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label>Title: </label><br/>
    <input type="text"  class="form-control"  name="title" value="${work.title}"/><br/>
    <s:fielderror fieldName="title"/>
    <label>Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${work.description}</textarea><br/>
    <s:fielderror fieldName="description"/>
    <div class="col-xs-3">
        <label>Work start date: </label><br/>
        <input type="date" class="form-control smallInput newDateInput" name="startDate" date-value="${work.stringStartDate}"/><br/>
        <s:fielderror fieldName="startDate"/>
    </div>
    <div class="col-xs-3">
        <label>Work end date: </label><br/>
        <input type="date" class="form-control smallInput newDateInput" name="endDate" date-value="${work.stringEndDate}"/><br/>
        <s:fielderror fieldName="endDate"/>
    </div>
    <div class="col-xs-3">
        <s:select class="form-control smallInput" name="projectId" label="Create on project:"
                  list="projects" listKey="Id" listValue="Title" />
        <s:fielderror fieldName="projectId"/>
    </div>
    <div class="col-xs-3">
        <s:select name="employeesIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName"/>
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
