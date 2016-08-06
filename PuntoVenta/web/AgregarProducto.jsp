<%-- 
    Document   : AgregarProducto
    Created on : 30-jul-2016, 17:44:15
    Author     : Victor
--%>

<%@page import="com.capacitacion.beans.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Usuario user = (Usuario) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Poductos</title>
        <script src="js/ajax.js" type="text/javascript"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
    </head>
    <body onload="getProductos()">
    <center>
        <h1>Agregar Productos</h1>
        <h1 style="text-align: right">Usuario <% if (user != null) {
                out.print(user.getNombre());
            }
            %></h1>
            <input type="hidden" id="txtIdProducto"  value="id"/><br />
        Clave <input type="text" id="txtClave" /><br />
        Nombre <input type="text" id="txtNombre"/><br />
        Precio <input type="text" id="txtPrecio" /><br />
        Exsitencia <input type="text" id="txtExistencia" /><br /><br />
        <input type="button" id="btnAddUp" value="Agragar" onclick="addProdut();" /> 
        <br />
        <br />

        <div id="idImagen" style="display: none">
            <img src="images/ajax-loader.gif" alt=""/>
        </div>
        <div id="tblProTable">
        </div>
        <br />


    </center>
</body>
</html>

