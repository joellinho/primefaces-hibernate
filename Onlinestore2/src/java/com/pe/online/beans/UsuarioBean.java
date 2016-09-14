/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.UsuarioDAO;
import com.pe.online.entity.UsuarioTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean {

    UsuarioTO usuario;
    List<UsuarioTO> lista;
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
        usuario = new UsuarioTO();
        lista = new ArrayList<>();
    }

    public UsuarioTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioTO usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioTO> getLista() {
        return lista;
    }

    public void setLista(List<UsuarioTO> lista) {
        this.lista = lista;
    }

    public void mostrarTodos() {
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.getAll();
    }

    public void eliminar(UsuarioTO usuario) {
        //lista.remove(usuario);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.eliminar(usuario);
        mostrarTodos();

    }

    public void agregar() {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.agregar(this.usuario);
        mostrarTodos();
    }

    public void seleccionar(UsuarioTO user) {

        
        UsuarioDAO usuarioDao = new UsuarioDAO();
        usuario = usuarioDao.seleccionar(user);
        accion = "modificar";
    }

    public void modificar() {
//        int index = lista.lastIndexOf(usuario);
//        usuario.setCodigo(index + 1);
//        lista.add(index, usuario);
//        lista.remove(index + 1);
//        return lista;
//   
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    usuarioDAO.modificar(this.usuario);
    mostrarTodos();
    }

    public void limpiar() {
        usuario = new UsuarioTO();
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
        String resultado = "";
        mostrarTodos();
        UsuarioDAO usuarioDAo = new UsuarioDAO();

        if (usuarioDAo.login(usuario)) {
            resultado = "cms-admin.xhtml?faces-redirect=true";

        } else {
            resultado = "unautorized.xhtml";
        }
        return resultado;
    }

}
