/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.entity;

import java.util.Date;

/**
 *
 * @author admin-joel
 */
public class PedidoTO {
    private int codigo;
    private int codigo_cliente;
    private Date fechaPedido;
    private Date fechaEntrega;
    private double total;
    private String estado;

    public PedidoTO(int codigo, Date fechaPedido, Date fechaEntrega, double total, String estado) {
        this.codigo = codigo;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.estado = estado;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    

}
