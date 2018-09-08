<%-- 
    Document   : index
    Created on : 12/08/2018, 06:49:37 PM
    Author     : admin
--%>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form action="login" method="post">
<s:textfield name="userDto.login" value="%{userDto.login}" label="Name"></s:textfield>
<s:password name="userDto.password" value="%{userDto.password}" label="Password"></s:password>
<s:submit value="login"></s:submit>
</s:form>