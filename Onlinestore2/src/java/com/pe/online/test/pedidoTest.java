/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.test;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Cliente;
import model.DetallePedido;
import model.DetallePedidoPK;
import model.Pedido;
import model.Producto;

/**
 *
 * @author admin-joel
 */
public class pedidoTest {
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
    
    public static void main(String[] args) {
//        registrarpedido();
    registrarPedido2();
    }

    //este test era sin detalle
    public static void registrarpedido() {
//     EntityManager em = emf.createEntityManager();
//
//        Pedido pedido = new Pedido();
//        pedido.setCliente(new Cliente(1));/////////////
//        pedido.setEstado("pedido");
//        pedido.setFechaPedido(new Date(Calendar.getInstance().getTime().getTime()));
//        pedido.setFechaEntrega(new Date(Calendar.getInstance().getTime().getTime()));
//        pedido.setTotal(500);
//        pedido.setTotal(50);
//        em.getTransaction().begin();
//        em.persist(pedido);
//        em.getTransaction().commit();
//        em.close();
    }

    public static void registrarPedido2() {
        EntityManager em = emf.createEntityManager();
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente(1));
        pedido.setEstado("pedido");
        pedido.setFechaPedido(new Date());
        pedido.setFechaEntrega(new Date());
        pedido.setTotal(50);
        em.getTransaction().begin();
        em.persist(pedido);
        em.flush();
        
        
        int codigoProducto =4;
        DetallePedidoPK llave =  new DetallePedidoPK(pedido.getCodigoPedido(),codigoProducto);
        DetallePedido detalle = new DetallePedido();
        detalle.setIdDetalle(llave);
        detalle.setProducto(new Producto(codigoProducto));
        detalle.setPedido(pedido);
        detalle.setPrecioUnitario(30);
        detalle.setCantidad(5);
        em.persist(detalle);
        em.getTransaction().commit();
        em.close();
        
    }
}
