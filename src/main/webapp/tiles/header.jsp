<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h1>Cool web page</h1>
<h3>Languages</h3>
<ul>
    <li>
        <s:url var="url" action="changelang">
            <s:param name="lang">en</s:param>
        </s:url>
        <s:a href="%{url}">English</s:a>
    </li>
    <li>
        <s:url var="url" action="changelang">
            <s:param name="lang">es</s:param>
        </s:url>
        <s:a href="%{url}">Español</s:a>
    </li>
</ul>