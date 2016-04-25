<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="page-header">
    <h1>The Document Management System.</h1>
</div>
<s:if test="session.containsKey('fullName')">
    <div>
        <div class="col-xs-10">
            Welcome, ${session.get('fullName')}!
        </div>
        <div class="col-xs-2">
            <a href="/signOut" />Sign Out</a>
        </div>
    </div>
</s:if>
<s:else>
    <a href="/register" />Register</a> or Sign In:
    <form action="/signIn" class="form-inline" method="post">
        <div class="form-group">
            <label for="login">Login: </label>
            <input class="form-control" type="text" name="login"/>
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input class="form-control" type="password" name="password"/>
        </div>
        <button class="btn btn-primary" type="submit">Sign In</button>
    </form>
</s:else>
