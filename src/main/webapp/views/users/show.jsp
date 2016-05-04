<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <h2>
        <s:property value="user.fullName" />
    </h2>
</div>
<div>
    <h4>
        <s:property value="user.email" />
    </h4>
</div>
<s:if test="session.containsKey('role')">
    <s:if test='session.get("id") == "user.id"'>
        <s:if test='session.get("role") == "client"'>
            <div class="col-xs-6">
                <h3>My contracts</h3>
                <s:if test="user.contracts.size() == 0">
                    <h4>There are no contracts yet!</h4>
                </s:if>
                <ul>
                    <s:iterator value="user.contracts">
                        <li><a href="/contracts/<s:property value='id' />" ><s:property value="title" /></a></li>
                    </s:iterator>
                </ul>
            </div>
        </s:if>
    </s:if>
    <s:else>
        <s:if test='user.role == "client"'>
            <div class="col-xs-6">
                <h3>Contracts</h3>
                <s:if test="user.contracts.size() == 0">
                    <h4>There are no contracts yet!</h4>
                </s:if>
                <ul>
                    <s:iterator value="user.contracts">
                        <li><a href="/contracts/<s:property value='id' />" >Contract &#8470;<s:property value="id"/></a></li>
                    </s:iterator>
                </ul>
            </div>
        </s:if>
        <s:else>
            <div class="col-xs-6">
                <h3>Projects</h3>
                <s:if test="user.projects.size() == 0">
                    <h4>There are no projects yet!</h4>
                </s:if>
                <ul>
                    <s:iterator value="user.projects">
                        <li><a href="/projects/<s:property value='id' />" ><s:property value="title" /></a></li>
                    </s:iterator>
                </ul>
            </div>
            <div class="col-xs-6">
                <h3>Works</h3>
                <s:if test="user.works.size() == 0">
                    <h4>There are no works yet!</h4>
                </s:if>
                <ul>
                    <s:iterator value="user.works">
                        <li><a href="/works/<s:property value='id' />" ><s:property value="title" /></a></li>
                    </s:iterator>
                </ul>
            </div>
        </s:else>
    </s:else>

</s:if>


