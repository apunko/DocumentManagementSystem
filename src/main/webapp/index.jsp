<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>
  ${mainInf}
</div>
<div><a href="<s:url action="departments/index" />">Show Departments</a></div>
<div><a href="<s:url action="users/index" />">Show Users</a></div>
<div><a href="<s:url action="contracts/index" />">Show Contracts</a></div>