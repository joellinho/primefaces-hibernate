/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.PedidosDAO;
import com.pe.online.entity.Pedidos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author admin-joel
 */
@ManagedBean
@SessionScoped
public class PedidosBean {

    List<Pedidos> listaPedidos;
    Pedidos pedidos;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {

        this.accion = accion;
    }

    public PedidosBean() {
        listaPedidos = new ArrayList<>();
    }

    public void mostrartodos() {
        PedidosDAO dao = new PedidosDAO();
        listaPedidos = dao.obtenerPedidos();
    }

    public List<Pedidos> eliminar(Pedidos ped) {
        PedidosDAO eliminarDao = new PedidosDAO();
        listaPedidos.remove(ped);
        return listaPedidos;

    }

    public List<Pedidos> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

}
