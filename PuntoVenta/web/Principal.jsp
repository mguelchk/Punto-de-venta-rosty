<%-- 
    Document   : Principal
    Created on : 30-jul-2016, 17:43:34
    Author     : Victor
--%>

<%@page import="com.capacitacion.beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario user = (Usuario) session.getAttribute("user");
if(user == null){
    response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAgina Principal Mostrar</title>
    </head>
    <center>
        <h1> Usuarios</h1>
        <table border="2px">

            <tr>
                <th>idUsuario</th>
                <th>Nombre</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Activo</th>
                <th>Actualizar</th>
                <th>Eliminar</th>
            </tr>
            <tr>
                <td>100</td>
                <td>Victor</td>
                <td>100</td>
                <td>12345 PZA</td>
                <td>1</td>
            </tr>
        </table>
        <br />


        <div id="body">
            <form method="get" action="accion.html">
                idUsuario: <input type="text" name="idUsuario" /><br />
                Nombre: <input type="text" name="nombre" /><br />
                Usuario: <input type="text" name="usuario" /><br />
                Contraseña: <input type="text" name="contraseña" /><br />
                Activo: <input type="text" name="activo" /><br />
            </form>
            <input type="submit" name="Agragar" value=" Agragar" />
            <ul> <li><a href="#">Regresar</a></li> </ul>
        </div>
    </center>
</html>
