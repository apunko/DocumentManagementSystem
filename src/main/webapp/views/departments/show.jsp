<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Department ${department.name}</h2>
<div>
    <a href="edit/${id}">Edit</a> | <a href="delete/${id}">Delete</a>
</div>
<div class="col-xs-7">
    <div class="multiline">
        ${department.description}
    </div>
</div>
<div class="col-xs-4">
    <h3>Members:</h3>
    <table class="table">
        <tbody>
            <s:iterator value="department.employees" var="member">
                <tr>
                    <td><s:property value="fullName"/></td>
                    <td><a href="/users/${member.id}">View</a></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</div>