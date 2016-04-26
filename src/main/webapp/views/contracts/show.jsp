<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Contract &#8470;<s:property value="id"/></h2>
<div class="col-xs-12">
    <div class="text-primary">
        <p><s:property value="contract.template.content"/></p>
    </div>
    <div class="text-primary">
        <p>
            Client will pay to "AntonAndTeamDevelopment" Company <s:property value="contract.paySum"/>$
            before end of payment day <s:property value="contract.stringPayDate"/>
        </p>
    </div>
    <div class="text-primary">
        The contract begins since <s:property value="contract.stringStartDate"/>
        and ends <s:property value="contract.stringEndDate"/>
    </div>
</div>
<div class="col-xs-8">
    <div class="col-xs-6">
        <h4>Client:</h4>
        <div>
            <s:property value="contract.client.fullName"/>
        </div>
        <div>
            Email: <s:property value="contract.client.email"/>
        </div>
        <div>
            Passport: <s:property value="contract.client.passport"/>
        </div>
    </div>
    <div class="col-xs-6">
        <h4>Company:</h4>
        <div>
            AntonAndTeamDevelopment
        </div>
    </div>
</div>

