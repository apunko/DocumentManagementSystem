<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>The Document Management System.</div>

<s:if test="session.containsKey('role')">
    <div>${session.containsKey('login')}</div>
    <a href="/signOut" />">Sign Out</a>
</s:if>
<s:else>
    <a href="/register" />Register</a> or Sign In:
    <form action="/users/signIn" method="post">
        <label for="login">Login: </label><br/>
        <input type="text" name="login"/><br/>
        <label for="password">Password: </label><br/>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Sign Up"/>
    </form>
</s:else>
