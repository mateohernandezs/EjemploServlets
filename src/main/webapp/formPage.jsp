<%-- 
    Document   : formPage
    Created on : 11/08/2018, 09:32:57 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
       <form method="post" action="WelcomeServlet">
           <label>Nombre: </label>
           <input type="text" name="name" />
           <br><br>           
           <input type="Submit"value="Submit"/>
       </form>             
    </body>
</html>
