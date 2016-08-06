/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.usuario.dao;

import com.capacitacion.beans.Usuario;
import com.capacitacion.conexion.Conexion;
import com.capacitacion.sql.UsuarioSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Victor
 */
public class UsuarioDao {

    public Usuario validateUser(Usuario user) {
        ResultSet rs;
        try {
            Connection con = new Conexion().getConexion();
            PreparedStatement stm = con.prepareStatement(UsuarioSql.SELECT);
            stm.setString(1, user.getUsuario());
            stm.setString(2, user.getContraseña());
            rs = stm.executeQuery();
            user = new Usuario();
            if (rs != null) {
                while (rs.next()) {
                    user.setIdUsuario(rs.getInt("idusuario"));
                    user.setNombre(rs.getString("Nombre"));
                    user.setValid(true);

                }
            } else {
                user.setValid(true);
            }
            con.close();
        } catch (Exception e) {
            user.setValid(false);
            System.out.println("Error al Validar Usuario" + e);
        }

        return user;
    }
}
