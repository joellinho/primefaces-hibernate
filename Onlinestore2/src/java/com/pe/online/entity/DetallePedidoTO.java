/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.entity;

/**
 *
 * @author admin-joel
 */
public class DetallePedidoTO {
    private int codigoPedido;
    private int codigoProducto;
    private double precioUnitario;
    private int cantidad;

    public DetallePedidoTO() {
    }
    
    

    public DetallePedidoTO(int codigoPedido, int codigoProducto, double precioUnitario, int cantidad) {
        this.codigoPedido = codigoPedido;
        this.codigoProducto = codigoProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
