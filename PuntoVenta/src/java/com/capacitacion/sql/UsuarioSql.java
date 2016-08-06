/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.sql;

/**
 *
 * @author Victor
 */
public class UsuarioSql {

    public static final String SELECT;

    static {
        StringBuilder querySel = new StringBuilder();
        querySel.append("SELECT * FROM usuarios ");
        querySel.append("WHERE Usuario= ? and Contrasenia = ? AND Activo=1 ");
        SELECT = querySel.toString();

    }
}
