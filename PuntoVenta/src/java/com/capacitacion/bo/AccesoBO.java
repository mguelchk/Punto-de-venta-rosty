/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capacitacion.bo;

import com.capacitacion.beans.Usuario;
import com.capacitacion.usuario.dao.UsuarioDao;

/**
 *
 * @author Victor
 */
public class AccesoBO {
    
    UsuarioDao usuarioDAO;
    
    public AccesoBO(){
        usuarioDAO = new UsuarioDao();
    }
    
    public Usuario ValidaUser(Usuario user){
        return usuarioDAO.validateUser(user);
    }
}
