/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

/**
 *
 * @author admin-joel
 */
@Embeddable
public class DetallePedidoPK implements Serializable {
    @Column(name = "codigo_pedido")
    
    private int codigoPedido;
    
    @Column(name="codigo_producto")
    private int codigoProducto;

    public DetallePedidoPK() {
    }

    
    public DetallePedidoPK(int codigoPedido, int codigoProducto) {
        this.codigoPedido = codigoPedido;
        this.codigoProducto = codigoProducto;
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
    
    
    
}
