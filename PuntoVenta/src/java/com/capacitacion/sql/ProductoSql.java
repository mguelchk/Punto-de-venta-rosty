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
public class ProductoSql {

    public static final String INSERT;
    public static final String DELETE;
    public static final String UPDATE;
    public static final String SELECT;
    public static final String SELECTLIKE;
    public static final String SELECTUNIC;

    static {
        StringBuilder queryIns = new StringBuilder();
        queryIns.append("INSERT INTO productos(UsuarioCreacion,FechaCreacion,UsuarioModificacion,FechaModificacion,Clave,Descripcion,");
        queryIns.append("Precio,IVA,Existencia,Activo)VALUES(?,NOW(),?,NOW(),?,?,?,?,?,1)");
        INSERT = queryIns.toString();

        StringBuilder queryUp = new StringBuilder();
        queryUp.append("UPDATE productos ");
        queryUp.append("SET UsuarioModificacion = ?,FechaModificacion = NOW(),Clave =?, " );
        queryUp.append("Descripcion = ?,Precio = ?,IVA = ? ,Existencia = ? ,Activo = ? WHERE idProducto = ?");
        // queryUp.append("Precio,IVA,Existencia,Activo)VALUES(?,NOW(),?,NOW(),?,?,?,?,?,1)");

        UPDATE = queryUp.toString();
        
        StringBuilder queryDel = new StringBuilder();
        queryDel.append("DELETE  FROM productos where idProducto = ?");
        DELETE = queryDel.toString();
        
        StringBuilder querySel = new StringBuilder();
        querySel.append("SELECT * FROM productos ORDER BY idProducto DESC");
        SELECT = querySel.toString();
        
        StringBuilder querySelike = new StringBuilder();
        querySelike.append("SELECT * FROM productos WHERE descripcion LIKE ?");
        SELECTLIKE = querySel.toString();
        
        StringBuilder querySelu = new StringBuilder();
        querySelu.append("SELECT * FROM productos WHERE idProducto =?");
        SELECTUNIC= querySelu.toString();
    }
}
