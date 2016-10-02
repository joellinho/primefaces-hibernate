/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import Util.JPAUtil;
import static com.google.common.io.Files.map;
import com.pe.online.entity.PedidoTO;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.google.common.io.Files.map;
import com.pe.online.beans.CarItemBean;
import com.pe.online.entity.DetallePedidoTO;
import com.pe.online.entity.UsuarioTO;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.DetallePedido;
import model.DetallePedidoPK;
import model.Pedido;
import model.Producto;

/**
 *
 * ic@author admin-joel
 */
public class PedidosDAO {

    private Map<Integer, PedidoTO> fuente;
    EntityManager em = JPAUtil.getEntityManager();

    public void poblar() {
//        Map<Integer, PedidoTO> pedidos = new HashMap<>();
//        PedidoTO pedido1 = new PedidoTO();
//        pedido1.setCodigo(1);
//        pedido1.setCantidad(25.0);
//        DateFormatSymbols dateSymbols = new DateFormatSymbols();
//        dateSymbols.setAmPmStrings(new String[]{"a.m.", "p.m."});
//        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm a dd/MM/yyyy", dateSymbols);
//        pedido1.setFecha("03/05/1205");
//
//        PedidoTO pedido2 = new PedidoTO();
//        pedido2.setCodigo(2);
//        pedido2.setCantidad(25.0);
//        pedido2.setFecha("03/05/2016");
//
//        pedidos.put(1, pedido1);
//        pedidos.put(2, pedido2);
//        fuente = pedidos;
//        PedidoTO pedido3 = new PedidoTO();
//        pedido3.setCodigo(3);
//        pedido3.setCantidad(25.0);
//        pedido3.setFecha("04/05/2016");
//
//        pedidos.put(1, pedido1);
//        pedidos.put(2, pedido2);
//        pedidos.put(3, pedido3);
//        fuente = pedidos;

    }

    public PedidosDAO() {
        poblar();
    }

    public List<PedidoTO> obtenerPedidos() {
        List<PedidoTO> lista = new ArrayList<>();
        String query = "Select new com.pe.online.entity.PedidoTO(pe.codigoPedido,pe.fechaPedido,pe.fechaEntrega,pe.total,pe.estado) from Pedido pe ";
        TypedQuery<PedidoTO> typedQuery = em.createQuery(query, PedidoTO.class);
        lista = typedQuery.getResultList();
        return lista;
    }

    public void añadirPedido(Integer total, Integer codigo, List<CarItemBean> carrito) {

        Pedido pedid = new Pedido();
        pedid.setCliente(new Cliente(codigo));
        pedid.setEstado("pedido");
        pedid.setFechaPedido(new Date(Calendar.getInstance().getTime().getTime()));
        pedid.setFechaEntrega(new Date(Calendar.getInstance().getTime().getTime()));
        pedid.setTotal(total);

        em.getTransaction().begin();
        em.persist(pedid);
        em.flush();
        for (CarItemBean item : carrito) {
            DetallePedidoPK detallePK = new DetallePedidoPK(pedid.getCodigoPedido(), item.getCodigo());
            DetallePedido detalle = new DetallePedido();
            detalle.setIdDetalle(detallePK);
            detalle.setPedido(pedid);
            detalle.setPrecioUnitario(item.getPrecio());
            detalle.setProducto(new Producto(item.getCodigo()));
            detalle.setCantidad(item.getCantidad());

            em.persist(detalle);
        }
        em.getTransaction().commit();

    }

    public void eliminarPedido(PedidoTO pedido) {
        fuente.remove(pedido.getCodigo());

    }

    public List<DetallePedidoTO> encontrarDetalles(PedidoTO pedido) {
        EntityManager emgr = JPAUtil.getEntityManager();
        List<DetallePedidoTO> listaDetallesTO = new ArrayList<>();
        List<DetallePedido> listaDetalles = new ArrayList<>();

        String consulta = "select p.listaDetalles from Pedido p where p.codigoPedido=:codigo";
        Query query = em.createQuery(consulta);
        query.setParameter("codigo", pedido.getCodigo());
        listaDetalles = query.getResultList();
    
          for(int i=0;i<listaDetalles.size();i++){
            DetallePedidoTO detalleped = new DetallePedidoTO();
            detalleped.setCantidad(listaDetalles.get(i).getCantidad());
            detalleped.setPrecioUnitario(listaDetalles.get(i).getPrecioUnitario());
            detalleped.setCodigoProducto(listaDetalles.get(i).getProducto().getCodigo());
            detalleped.setCodigoPedido(listaDetalles.get(i).getPedido().getCodigoPedido());
            listaDetallesTO.add(detalleped);
              System.out.println("agregando  a detalle");
          }
          for (DetallePedidoTO listaDetlle : listaDetallesTO) {
              System.out.println("obteniendo del detalle to"+listaDetlle.getPrecioUnitario()+""+listaDetlle.getCantidad());
        }
        return listaDetallesTO;
    }
}
