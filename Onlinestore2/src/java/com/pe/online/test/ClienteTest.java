/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author admin-joel
 */
public class ClienteTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");

//    public static void main(String[] args) {
////        mostrarClientes();
//
//        /*insertando cliente*/
//        Cliente cliente = new Cliente();
//        cliente.setNombre("aaron");
//        cliente.setCorreo("aaron_5@hotmail.com");
//        cliente.setEdad(22);
//        insertarCliente(cliente);
//
//        /*buscando cliente*/
////        
////        Cliente cli = new Cliente();
////        cli.setCodigo(2);
////       buscarCliente(cli);
//        /*eliminando cliente*/
////       Cliente clientd = new Cliente();
////       clientd.setCodigo(3);
////        eliminar(clientd);
//    }
//
//    public static void mostrarClientes() {
//        EntityManager em = emf.createEntityManager();
//        String consulta = "select c from Cliente c ";
//        List<Cliente> listacliente;
//        TypedQuery<Cliente> clientes = em.createQuery(consulta, Cliente.class);
//        listacliente = clientes.getResultList();
//        for (Cliente cliente1 : listacliente) {
//            System.out.println(cliente1.getNombre());
//
//        }
//        em.close();
//    }
//
//    public static void insertarCliente(Cliente cli) {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(cli);
//        em.getTransaction().commit();
//        em.close();
//
//    }
//
//    public static void eliminar(Cliente cli) {
//
//        EntityManager em = emf.createEntityManager();
//        String query = "select c from Cliente c where c.codigo=:codigo";
//        Cliente client;
//        TypedQuery<Cliente> typedQuery = em.createQuery(query, Cliente.class);
//        typedQuery.setParameter("codigo", cli.getCodigo());
//        em.getTransaction().begin();
//        client = typedQuery.getSingleResult();
//        em.remove(client);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    public static void buscarCliente(Cliente clie) {
//        EntityManager em = emf.createEntityManager();
//        Cliente client;
//        String query = "select c from Cliente c where c.codigo=:codigo";
//        TypedQuery<Cliente> typedQuery = em.createQuery(query, Cliente.class);
//        typedQuery.setParameter("codigo", clie.getCodigo());
//        client = typedQuery.getSingleResult();
//        em.close();
//        System.out.println(client.getNombre());
//
//    }
//
//    public static Cliente buscarCliente2(Integer codigo) {
//        EntityManager em = emf.createEntityManager();
//
//        Cliente clienteq = em.find(Cliente.class, codigo);
//        em.close();
//        return clienteq;
//    }
}
