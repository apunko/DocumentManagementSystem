<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:form action="create" theme="bootstrap" method="post">
    <label for="title">Title: </label><br/>
    <input type="text"  class="form-control"  name="title"/><br/>
    <div class="col-xs-4">
        <label for="planEndDate">Plan end of project: </label><br/>
        <input type="date" class="form-control smallInput newDateInput" name="planEndDate"/><br/>
    </div>
    <div class="col-xs-4">
        <s:select class="form-control smallInput" name="contractId" label="Belongs to contract Number:"
                  list="contracts" listKey="Id" listValue="Id" />
    </div>
    <div class="col-xs-4">
        <s:select name="employeeIds" class="multiSelect" multiple="true" listKey="Id" label="Employees:"
                  list="employees" listValue="fullName"/>
    </div>
    <s:submit cssClass="btn btn-block btn-primary" value="Create"/>
</s:form>
