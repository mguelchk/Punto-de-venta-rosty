/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.usuario.dao;

import com.capacitacion.beans.Producto;
import com.capacitacion.conexion.Conexion;
import com.capacitacion.sql.ProductoSql;
import com.capacitacion.sql.UsuarioSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ProductoDao {

    public boolean insertProduc(Producto producto) {
        boolean existe = false;
       
        try {
             Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.INSERT);
            stm.setInt(1, producto.getUsuarioCreacion());
            stm.setInt(2, producto.getUsuarioModificacion());
            stm.setString(3, producto.getClave());
            stm.setString(4, producto.getDescripcion());
            stm.setBigDecimal(5, producto.getPrecio());
            stm.setBigDecimal(6, producto.getIva());
            stm.setInt(7, producto.getExistencias());
            stm.execute();
            existe = true;
            con.close();
        } catch (Exception e) {
            System.out.println("Error al Insertar Usuario - insertProduc " +e);
        }

        return existe;
    }

    public boolean updateProduc(Producto producto) {
        boolean existe = false;
        
        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.UPDATE);
            System.out.println(ProductoSql.UPDATE);
            stm.setInt(1, producto.getUsuarioModificacion());
            stm.setString(2, producto.getClave());
            stm.setString(3, producto.getDescripcion());
            stm.setBigDecimal(4, producto.getPrecio());
            stm.setBigDecimal(5, producto.getIva());
            stm.setInt(6, producto.getExistencias());
            stm.setBoolean(7, producto.isActivo());
            stm.setInt(8, producto.getIdProducto());
            stm.execute();
            existe = true;
            con.close();
        } catch (Exception e) {
            System.out.println("Error al Actualizar " +e);
        }

        return existe;
    }

    public boolean deleteProduc(Producto producto) {
        boolean existe = false;
        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.DELETE);
            stm.setInt(1, producto.getIdProducto());
            stm.execute();
            existe = true;
            con.close();
        } catch (Exception e) {
            System.out.println("Error al Borrar");
        }

        return existe;
    }
    
     public Producto getProduct(Producto p) {
        ResultSet rs;
        Producto pro = new Producto();
        try {
             Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.SELECTUNIC);
            stm.setInt(1, p.getIdProducto());
            rs = stm.executeQuery();
             while (rs.next()) {
                pro.setIdProducto(rs.getInt("idProducto"));
                pro.setUsuarioCreacion(rs.getInt("usuariocreacion"));
                pro.setFechaCreacion(rs.getDate("fechacreacion"));
                pro.setFechaModificacion(rs.getDate("fechamodificacion"));
                pro.setUsuarioCreacion(rs.getInt("usuariomodificacion"));
                pro.setClave(rs.getString("clave"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getBigDecimal("precio"));
                pro.setExistencias(rs.getInt("existencia"));
                pro.setActivo(rs.getBoolean("activo"));
            }
        } catch (Exception e) {
            System.out.println("Error al Seleccionar"+e);
            pro=null;
        }
        return pro;
    }

    public List<Producto> getAllProduct(Producto p) {
        ResultSet rs;
        List<Producto> listProd = new ArrayList<>();
       
        try {
             Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.SELECTLIKE);
            stm.setString(1, "%" + p.getDescripcion());
            rs = stm.executeQuery();
            addListProduc(rs, listProd);
        } catch (Exception e) {
            System.out.println("Error al Seleccionar");
        }
        return listProd;
    }

    public List<Producto> getAllProduct() {
        ResultSet rs;
        List<Producto> listProd = new ArrayList<>();
        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(ProductoSql.SELECT);
            rs = stm.executeQuery();
            addListProduc(rs, listProd);
        } catch (Exception e) {
            System.out.println("Error al Seleccionar - GetAllProduct"+e);
        }
        return listProd;
    }

    private void addListProduc(ResultSet rs, List<Producto> listProd) {
        try {
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt("idProducto"));
                pro.setUsuarioCreacion(rs.getInt("usuariocreacion"));
                pro.setFechaCreacion(rs.getDate("fechacreacion"));
                pro.setFechaModificacion(rs.getDate("fechamodificacion"));
                pro.setUsuarioCreacion(rs.getInt("usuariomodificacion"));
                pro.setClave(rs.getString("clave"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setPrecio(rs.getBigDecimal("precio"));
                pro.setExistencias(rs.getInt("existencia"));
                pro.setActivo(rs.getBoolean("activo"));
                listProd.add(pro);
            }
        } catch (Exception e) {
        }

    }
}
