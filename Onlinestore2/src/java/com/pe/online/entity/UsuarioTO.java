/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.entity;


public class UsuarioTO {
   private int codigo;
   private String usuario;
   private String password;

    public UsuarioTO() {
    }

    public UsuarioTO(int codigo, String usuario, String password) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.password = password;
    }

   
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}
