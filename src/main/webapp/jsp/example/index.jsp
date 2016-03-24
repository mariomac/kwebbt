<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2><s:text name="index.title"/></h2>

<p><s:text name="index.body"/></p>
<s:form action="demo" method="POST">
    <s:textfield key="demo.number" name="number"/>
    <s:submit/>
</s:form>