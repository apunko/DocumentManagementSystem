<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <h2>
        <s:property value="user.fullName" />
    </h2>
</div>
<s:if test="session.containsKey('role')">
    <s:if test='session.get("role") == "client"'>
        <div class="col-xs-6">
            <h3>My contracts</h3>
            <ul>
                <s:iterator value="user.contracts">
                    <li><a href="/contracts/<s:property value='id' />" ><s:property value="title" /></a></li>
                </s:iterator>
            </ul>
        </div>
    </s:if>
    <s:if test='session.get("role") == "manager"'>
        <div class="col-xs-6">
            <h3>My projects</h3>
            <ul>
                <s:iterator value="user.projects">
                    <li><a href="/projects/<s:property value='id' />" ><s:property value="title" /></a></li>
                </s:iterator>
            </ul>
        </div>
        <div class="col-xs-6">
            <h3>My works</h3>
            <ul>
                <s:iterator value="user.works">
                    <li><a href="/works/<s:property value='id' />" ><s:property value="title" /></a></li>
                </s:iterator>
            </ul>
        </div>
    </s:if>
</s:if>


