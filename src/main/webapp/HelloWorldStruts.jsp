<%-- 
    Document   : HelloWorldStruts
    Created on : 11/08/2018, 11:44:26 AM
    Author     : admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>         
        <h2>Probando <s:property value="messageStore.message" /></h2>
    </body>
</html>
