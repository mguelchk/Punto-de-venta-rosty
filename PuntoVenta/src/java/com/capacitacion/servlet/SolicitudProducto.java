/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.servlet;

import com.capacitacion.beans.Producto;
import com.capacitacion.beans.Usuario;
import com.capacitacion.bo.ProdcutoBO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "SolicitudProducto", urlPatterns = {"/SolicitudProducto"})
public class SolicitudProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            switch (opcion) {
                case 1:
                    String tabla = new ProdcutoBO().getAllProduc();
                    out.print(tabla);
                    break;
                case 2:
                    try {
                        Usuario user = (Usuario) request.getSession().getAttribute("user");
                        Producto producto = new Producto();
                        producto.setUsuarioCreacion(user.getIdUsuario());
                        producto.setUsuarioModificacion(user.getIdUsuario());
                        producto.setClave(request.getParameter("clave"));
                        producto.setDescripcion(request.getParameter("nombre"));
                        producto.setPrecio(new BigDecimal(request.getParameter("precio")));
                        producto.setIva(new BigDecimal(16));
                        producto.setExistencias(Integer.parseInt(request.getParameter("existencia")));
                        System.out.println("-" + producto.toString());
                        String respuesta = new ProdcutoBO().insertProduct(producto);
                        out.print(respuesta);
                    } catch (Exception e) {
                        System.out.println("err - " + e);
                    }

                case 3:
                    try {
                        Producto producto = new Producto();
                        producto.setIdProducto(Integer.parseInt(request.getParameter("idProdcuto")));
                        String respuesta = new ProdcutoBO().getProdcut(producto);
                        out.print(respuesta);
                    } catch (Exception e) {
                        System.out.println("err - " + e);
                    }

                case 4:
                    try {
                        Usuario user = (Usuario) request.getSession().getAttribute("user");

                        Producto producto = new Producto();
                        producto.setIdProducto(Integer.parseInt(request.getParameter("idProdcuto")));
                        producto.setUsuarioModificacion(user.getIdUsuario());
                        producto.setClave(request.getParameter("clave"));
                        producto.setDescripcion(request.getParameter("nombre"));
                        producto.setPrecio(new BigDecimal(request.getParameter("precio")));
                        producto.setIva(new BigDecimal(16));
                        producto.setExistencias(Integer.parseInt(request.getParameter("existencia")));
                        String respuesta = new ProdcutoBO().updateProdcut(producto);
                        out.print(respuesta);
                    } catch (Exception e) {
                        System.out.println("err - " + e);
                    }
                case 5:
                    try {
                        Producto producto = new Producto();
                        producto.setIdProducto(Integer.parseInt(request.getParameter("idProdcuto")));
                        String respuesta = new ProdcutoBO().deleteProdcut(producto);
                        out.print(respuesta);
                    } catch (Exception e) {
                        System.out.println("err - " + e);
                    }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
