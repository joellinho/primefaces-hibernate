/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin-joel
 */
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido implements Serializable{
    @EmbeddedId
    private DetallePedidoPK idDetalle;
    
    @Column(name = "precio_unitario")
    private double precioUnitario;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_pedido",referencedColumnName = "codigo_pedido",insertable = false,updatable = false)
    private Pedido pedido;
    
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_producto",referencedColumnName = "codigo",updatable = false,nullable = false,insertable = false)
    private Producto producto;

    public DetallePedido(DetallePedidoPK idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetallePedido() {
    }

    
    
    public DetallePedidoPK getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(DetallePedidoPK idDetalle) {
        this.idDetalle = idDetalle;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetallePedido other = (DetallePedido) obj;
        if (!Objects.equals(this.idDetalle, other.idDetalle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetalle=" + idDetalle + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + '}';
    }
    
    
    
}
