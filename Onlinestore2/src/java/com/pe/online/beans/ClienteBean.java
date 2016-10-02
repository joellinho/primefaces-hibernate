/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.ClienteDAO;
import com.pe.online.entity.ClienteTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author admin-joel
 */
@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {
    private int codigoCliente;
    private String nombreCliente;
    ClienteTO cliente;
    List<ClienteTO> clientes;
    private String accion;

    public ClienteBean() {
        clientes = new ArrayList<>();
        cliente = new ClienteTO();
    }

    public void mostrarTodos() {
        ClienteDAO dao = new ClienteDAO();
        try {
            clientes = dao.mostrarTodos();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void registrar() {
        ClienteDAO dao = new ClienteDAO();
        try {
            dao.insertar(cliente);
            limpiar();
        } catch (Exception e) {
        }
    }

    public void seleccionar(ClienteTO client) {
        accion="modificar";
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.seleccionar(client);

    }

    public void modificar() {
        ClienteDAO dao = new ClienteDAO();

        try {
            dao.modificar(cliente);
            
            mostrarTodos();
            limpiar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(ClienteTO cliente) {
        ClienteDAO dao = new ClienteDAO();

        dao.eliminar(cliente);
        mostrarTodos();
        limpiar();

    }

    public void ejecutar() {
        switch (accion) {
            case "adicionar":
                registrar();
                mostrarTodos();
               
                break;
            case "modificar":
                modificar();
                mostrarTodos();
                
                break;
        }

    }
    
    
    public String login() {
        String resultado = "";
        mostrarTodos();
        ClienteDAO clienteDAO = new ClienteDAO();

        if (clienteDAO.login(cliente)) {
            ClienteTO client = clienteDAO.seleccionarPorNombre(cliente);
            this.setNombreCliente(client.getNombre());
            this.setCodigoCliente(client.getCodigo());
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().getSessionMap().put("usuario", client.getCorreo());
            
            resultado = "index.xhtml?faces-redirect=true";

        } else {
            resultado = "unautorized.xhtml";
        }
        return resultado;
    }
    

    public void limpiar(){
    cliente= new ClienteTO();
    }
    public ClienteTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteTO cliente) {
        this.cliente = cliente;
    }

    public List<ClienteTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteTO> clientes) {
        this.clientes = clientes;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
}
