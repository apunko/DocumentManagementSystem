<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>${project.title}</h2>
<div>
    <a href="edit/${id}">Edit</a> | <a href="delete/${id}" class="needConfirmation">Delete</a>
</div>
<div class="col-xs-12">
    <div class="text-primary">
        ${project.description}
    </div>
</div>
<div class="col-xs-6">
    <h3>Employees</h3>
    <s:if test="project.employees.size() == 0">
        <h4>There are no employees yet!</h4>
    </s:if>
    <ul>
        <s:iterator value="project.employees">
            <li><a href="/users/<s:property value='id' />" ><s:property value="fullName" /></a></li>
        </s:iterator>
    </ul>
</div>
<div class="col-xs-6">
    <h3>Works</h3>
    <s:if test="project.works.size() == 0">
        <h4>There are no works yet!</h4>
    </s:if>
    <ul>
        <s:iterator value="project.works">
            <li><a href="/works/<s:property value='id' />" ><s:property value="title" /></a></li>
        </s:iterator>
    </ul>
</div>

