<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
        <tiles:getAsString name="title"/>
    </title>
</head>
<body>
    <header>
        <tiles:insertAttribute name="header"/>
    </header>
    <tiles:insertAttribute name="body"/>
    <footer>
        <tiles:insertAttribute name="footer"/>
    </footer>
</table>
</body>
</html>