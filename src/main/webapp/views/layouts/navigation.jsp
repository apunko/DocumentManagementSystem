<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default nav-justified" role="navigation">
    <div>
        <ul class="nav navbar-nav">
            <li role="presentation"><a href="/index" >Main</a></li>
            <s:if test="session.containsKey('role')">
                <li role="presentation"><a href="/users/${session.get('id')}" >My profile</a></li>
                <s:if test='session.get("role") == "manager"'>
                    <li role="presentation"><a href="/contracts/index">Contracts</a></li>
                    <li role="presentation"><a href="/projects/index">Projects</a></li>
                    <li role="presentation"><a href="/works/index">Works</a></li>
                    <li role="presentation"><a href="/departments/index">Departments</a></li>
                    <li role="presentation"><a href="/users/index">Users</a></li>
                </s:if>
            </s:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <s:if test="session.containsKey('role')">
                <li class="navbar-brand">Welcome, ${session.get('fullName')}!</li>
                <li role="presentation" style="margin-right: 5px"><a href="/signOut" class="needConfirmation">Sign Out</a></li>
                <li></li>
            </s:if>
        </ul>
    </div>
</nav>