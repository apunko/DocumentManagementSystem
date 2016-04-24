<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>The Document Management System.</div>

<s:if test="session.containsKey('login')">
    <div>${session.get('login')}</div>
    <a href="/signOut" /> Sign Out</a>
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
