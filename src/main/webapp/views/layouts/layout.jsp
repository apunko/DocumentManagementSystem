<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" />
    </title>
    <script type="text/javascript" src="/assets/js/jquery-2.2.3.min.js"></script>
    <sb:head/>
    <script type="text/javascript" src="/assets/js/main.js"></script>
    <link rel="stylesheet" type="text/css" href="/assets/css/main.css">
</head>
<body>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1">
        <tiles:insertAttribute name="header" /><br/>
        <hr/>
        <tiles:insertAttribute name="navigation" /><br/>
        <s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
        <s:fielderror theme="bootstrap"/>
        <s:if test="%{#request['error'] != null}">
            <div class="alert alert-warning">
                <s:property value="#request['error']" />
            </div>
        </s:if>
        <tiles:insertAttribute name="body" /><br/>
        <tiles:insertAttribute name="footer" /><br/>
    </div>
</div>
</body>
</html>