/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.ClienteDAO;
import com.pe.online.dao.PedidosDAO;
import com.pe.online.entity.ClienteTO;
import com.pe.online.entity.DetallePedidoTO;
import com.pe.online.entity.PedidoTO;
import com.pe.online.entity.UsuarioTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;


@ManagedBean
@SessionScoped
public class PedidosBean {

    List<PedidoTO> listaPedidos;
    PedidoTO pedidos;
    private String accion;
    private List<DetallePedidoTO> listaDetalle;
   
  
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {

        this.accion = accion;
    }

    public PedidosBean() {
        listaPedidos = new ArrayList<>();
    }

    public String agregarPedidos(Integer total, Integer codigocliente,List<CarItemBean> carrito) {
        PedidosDAO dao = new PedidosDAO();
        try {
            dao.añadirPedido(total, codigocliente,carrito);
            return "prueba.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "unautorized.xhml?faces-redirect=true";
        }
    }

    public void mostrartodos() {
        PedidosDAO dao = new PedidosDAO();
        listaPedidos = dao.obtenerPedidos();
        
    }

    public List<PedidoTO> eliminar(PedidoTO ped) {
        PedidosDAO eliminarDao = new PedidosDAO();
        listaPedidos.remove(ped);
        return listaPedidos;

    }
    public void rowSelect(SelectEvent evn){
        FacesMessage messages = new FacesMessage("seleccionado", ((PedidoTO)evn.getObject()).getEstado());
         FacesContext.getCurrentInstance().addMessage(null,messages);
         mostrarDetalles();
    }

    public List<PedidoTO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoTO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public PedidoTO getPedidos() {
        return pedidos;
    }

    public void setPedidos(PedidoTO pedidos) {
        this.pedidos = pedidos;
    }

    public List<DetallePedidoTO> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<DetallePedidoTO> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    private void mostrarDetalles() {
        PedidosDAO pedididoDao = new PedidosDAO();
           listaDetalle =pedididoDao.encontrarDetalles(pedidos);
    }

   

}
