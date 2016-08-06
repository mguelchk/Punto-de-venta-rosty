<%-- 
    Document   : Index
    Created on : 30-jul-2016, 17:42:39
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/ajax.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
    </head>
    <body>
    <center>


        Login <input id="txtUsuario" type="txtUsuario" name="txt1"/>
        <br/>       
        <br/>
        Password <input id="txtPass" type="txtPass" name="txt2"/>
        <br/>     
          <br/>     
          <input  type ="button" name="btnAceptar" value="Ingresar" onclick="Acceder()"> 
        <input  type ="submit" name="btnCancelar" value="Cancelar">   

        <center/>
    </body>
</html>
