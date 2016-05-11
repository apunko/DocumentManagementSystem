<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>${work.title}</h2>
<div>
    <a href="edit/${id}">Edit</a> | <a href="delete/${id}" class="needConfirmation">Delete</a>
</div>
<div class="col-xs-12">
    <div class="text-primary">
        ${work.description}
    </div>
</div>
<div class="col-xs-4"><h4>Belongs to <a href="/projects/${work.project.id}">${work.project.title}</a></h4></div>
<div class="col-xs-4"><h4>Work start date: ${work.stringStartDate}</h4></div>
<div class="col-xs-4"><h4>Work end date: ${work.stringEndDate}</h4></div>
<div class="col-xs-6">
    <h3>Employees</h3>
    <s:if test="work.employees.size() == 0">
        <h4>There are no employees yet!</h4>
    </s:if>
    <ul>
        <s:iterator value="work.employees">
            <li><a href="/users/<s:property value='id' />" ><s:property value="fullName" /></a></li>
        </s:iterator>
    </ul>
</div>


