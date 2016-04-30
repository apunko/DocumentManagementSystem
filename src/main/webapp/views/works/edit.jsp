<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="update" theme="bootstrap" method="post">
    <input type="hidden" name="id" value="${work.id}">
    <label>Title: </label><br/>
    <input type="text"  class="form-control"  name="title" value="${work.title}"/><br/>
    <label>Description: </label><br/>
    <textarea class="form-control" rows="5" name="description">${work.description}</textarea><br/>
    <div class="col-xs-3">
        <label>Work start date: </label><br/>
        <input type="date" class="form-control smallInput editDateInput" name="startDate" value="${work.stringStartDate}"/><br/>
    </div>
    <div class="col-xs-3">
        <label>Work end date: </label><br/>
        <input type="date" class="form-control smallInput editDateInput" name="endDate" value="${work.stringEndDate}"/><br/>
    </div>
    <div class="col-xs-3">
        <s:select class="form-control smallInput" name="projectId" label="Create on project:"
                  list="projects" listKey="Id" listValue="Title" value="projectId"/>
    </div>
    <div class="col-xs-3">
        <s:select name="employeesIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName"/>
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Update"/>
</s:form>
