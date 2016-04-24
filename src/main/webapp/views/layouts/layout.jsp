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
</head>
<body>
<div class="row">
    <div class="col-xs-11 col-xs-offset-1">
        <tiles:insertAttribute name="header" /><br/>
        <hr/>
        <tiles:insertAttribute name="navigation" /><br/>
        <hr/>
        <s:actionerror theme="bootstrap"/>
        <s:actionmessage theme="bootstrap"/>
        <s:fielderror theme="bootstrap"/>
        <tiles:insertAttribute name="body" /><br/>
        <hr/>
        <tiles:insertAttribute name="footer" /><br/>
    </div>
</div>
</body>
</html>