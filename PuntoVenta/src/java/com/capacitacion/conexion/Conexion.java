/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class Conexion {

    private String host = "localhost";
    private String puerto = "3306";
    private String base = "pv";
    private String usuario = "root";
    private String contrasena = "12345";
    private String url = "jdbc:mysql://" + host + ":" + puerto + "/" + base;

    public Connection getConexion() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,usuario,contrasena);
                
        return con;
        
        
        
//        Connection con = null;
//        Class.forName("com.mysql.jdbc.Driver");
//        con = DriverManager.getConnection(url, usuario, contrasena);
//        System.out.println("Ocurrio un Error al Conactar " + ex);
//
//        return con;
    }
}
