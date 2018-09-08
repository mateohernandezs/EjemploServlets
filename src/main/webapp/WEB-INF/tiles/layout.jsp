<%-- 
    Document   : layout
    Created on : 30/08/2018, 05:57:15 PM
    Author     : admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta charset="utf-8">
<title>
<tiles:getAsString name="title"/>
</title>
</head><body>
<table border="1" cellpadding="2" cellspacing="2" align="center">
<tr>
<td height="30" colspan="2">
<tiles:insertAttribute name="header"/>
</td>
</tr>
<tr>
<td width="350">
<tiles:insertAttribute name="body"/>
</td>
</tr>
<tr>
<td height="30" colspan="2">
<tiles:insertAttribute name="footer"/>
</td>
</tr>
</table>
</body>
</html>