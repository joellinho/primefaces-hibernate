/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import static com.google.common.io.Files.map;
import com.pe.online.entity.Pedidos;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * ic@author admin-joel
 */
public class PedidosDAO {

    private Map<Integer, Pedidos> fuente;

    public void poblar() {
        Map<Integer, Pedidos> pedidos = new HashMap<>();
        Pedidos pedido1 = new Pedidos();
        pedido1.setCodigo(1);
        pedido1.setCantidad(25.0);
        DateFormatSymbols dateSymbols = new DateFormatSymbols();
        dateSymbols.setAmPmStrings(new String[]{"a.m.", "p.m."});
        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm a dd/MM/yyyy", dateSymbols);
        pedido1.setFecha("03/05/1205");

        Pedidos pedido2 = new Pedidos();
        pedido2.setCodigo(2);
        pedido2.setCantidad(25.0);
        pedido2.setFecha("03/05/2016");

        pedidos.put(1, pedido1);
        pedidos.put(2, pedido2);
        fuente = pedidos;
        Pedidos pedido3 = new Pedidos();
        pedido3.setCodigo(3);
        pedido3.setCantidad(25.0);
        pedido3.setFecha("04/05/2016");

        pedidos.put(1, pedido1);
        pedidos.put(2, pedido2);
        pedidos.put(3, pedido3);
        fuente = pedidos;

    }

    public PedidosDAO() {
        poblar();
    }

    public List<Pedidos> obtenerPedidos() {
        List<Pedidos> lista = new ArrayList<>();
        for (int i = 1; i <= fuente.size(); i++) {

            lista.add(fuente.get(i));
        }
        return lista;
    }

    public void añadirPedido(Pedidos pedido) {
        int tamaño;
        tamaño = fuente.size();
        int ultimo = (Integer) fuente.keySet().toArray()[tamaño - 1];
       fuente.put(ultimo+1, pedido);
    }

    public void eliminarPedido(Pedidos pedido) {
        fuente.remove(pedido.getCodigo());

    }
}
