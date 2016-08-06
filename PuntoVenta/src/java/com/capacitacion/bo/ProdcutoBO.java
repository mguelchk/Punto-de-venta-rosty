/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.bo;

import com.capacitacion.beans.Producto;
import com.capacitacion.beans.Usuario;
import com.capacitacion.usuario.dao.ProductoDao;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ProdcutoBO {

    ProductoDao productoDAO;

    public ProdcutoBO() {
        productoDAO = new ProductoDao();
    }

    public String getAllProduc() {
        StringBuilder item = new StringBuilder("<table id='tblProducto' border=\"2px\">");
        item.append("<tr>");
        item.append("<td> Clave </td>");
        item.append("<td> Descripcion </td>");
        item.append("<td> Precio </td>");
        item.append("<td> Existencia </td>");
        item.append("<td> Editar </td>");
        item.append("<td> Eliminar </td>");
        item.append("</tr>");
        try {
            List<Producto> listPro = productoDAO.getAllProduct();
            for (Producto getP : listPro) {
                item.append("<tr>");
                item.append("<td>");
                item.append(getP.getClave());
                item.append("</td>");
                item.append("<td>");
                item.append(getP.getDescripcion());
                item.append("</td>");
                item.append("<td>");
                item.append(getP.getPrecio());
                item.append("</td>");
                item.append("<td>");
                item.append(getP.getExistencias());
                item.append("</td>");
                item.append("<td>");
                item.append("<input type=\"button\" name=\"Agragar\" value=\"Editar\" onclick=\"editarProduct(" + getP.getIdProducto() + ");\" />");
                item.append("</td>");
                item.append("<td>");
                item.append("<input type=\"button\" name=\"Agragar\" value=\"elimina\" onclick=\"eliminarProdut(" + getP.getIdProducto() + ");\" />");
//                item.append("<input type=\"button\" name=\"Agragar\" value=\"Eliminar\" onclick=\"eliminarProdut(" + getP.getIdProducto() + ");\" />");
                item.append("</td>");
                item.append("</tr>");
            }
            return item.toString();
        } catch (Exception e) {
            item = new StringBuilder();
            return item.toString();
        }
    }

    public String insertProduct(Producto prodcuto) {
//        boolean registardo = productoDAO.insertProduc(prodcuto);
//        String res = "";
//        if (registardo) {
//            res = "Prodcuto resgitardo dxitosamente";
//        } else {
//            res = "Prodcuto resgitardo dxitosamente";
//        }

        String res = productoDAO.insertProduc(prodcuto) ? "Prodcuto resgitardo dxitosamente"
                : "A ocurrido un Error al Intentar Inserytar el Producto";
        return res;
    }

    public String getProdcut(Producto producto) {
        Producto pro = productoDAO.getProduct(producto);
        StringBuilder prod = new StringBuilder();
        prod.append("" + pro.getIdProducto() + "$$");
        prod.append("" + pro.getClave() + "$$");
        prod.append("" + pro.getDescripcion() + "$$");
        prod.append("" + pro.getPrecio() + "$$");
        prod.append("" + pro.getExistencias());
        return prod.toString();
    }

    public String updateProdcut(Producto producto) {
        try {
               boolean existe = productoDAO.updateProduc(producto);
        return existe ? "Registro actualizado " : "Registro no actualizado";
        } catch (Exception e) {
            System.out.println("wee"+e);
            return null;
        }
     
    }
      public String deleteProdcut(Producto producto) {
         try {
               boolean existe = productoDAO.deleteProduc(producto);
        return existe ? "Registro eliminado " : "Ocurrio uin erro al elimiar";
        } catch (Exception e) {
            System.out.println("wee"+e);
            return null;
        }
    }
}
