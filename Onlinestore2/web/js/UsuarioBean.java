/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.UsuarioDAO;
import com.pe.online.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean {

    Usuario usuario;
    List<Usuario> lista;
    int index;
    private String accion;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public UsuarioBean() {
        usuario = new Usuario();
        lista = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public void mostrarTodos() {
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.getAll();
    }

    public List<Usuario> eliminar(Usuario usuario) {
        lista.remove(usuario);
        return lista;
    }

    public List<Usuario> agregar() {
        int size = lista.size();
        int index = lista.lastIndexOf(usuario);
        usuario.setCodigo(size + 1);
        lista.add(usuario);
        return lista;
    }

    public void seleccionar(Usuario user) {

        int index = lista.indexOf(user);
        usuario = lista.get(index);
        accion = "modificar";
    }

    public List<Usuario> modificar() {
        int index = lista.lastIndexOf(usuario);
        usuario.setCodigo(index + 1);
        lista.add(index, usuario);
        lista.remove(index + 1);
        return lista;
    }

    public void limpiar() {
        usuario = new Usuario();
    }

    public void ejecutar() {
        switch (accion) {
            case "nuevo":
                agregar();
                limpiar();
                break;
            case "modificar":
                modificar();
                limpiar();
                break;
        }

    }

    public String login() {
        String resultado="";
        String password = this.usuario.getPassword();
        mostrarTodos();
        for (int i = 0; i <= lista.size(); i++) {
            if (password.equals("123456")) {
               resultado= "cms-admin.xhtml?faces-redirect=true";
            } else{
            resultado="unautorized.xhtml";
            }
        }
        System.out.println("CONTRASEÑA ="+password);
        return resultado;
        
    }
}
