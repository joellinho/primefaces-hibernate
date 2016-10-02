/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import Util.JPAUtil;
import com.pe.online.entity.ClienteTO;
import com.pe.online.entity.UsuarioTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import model.Cliente;

/**
 *
 * @author admin-joel
 */
public class ClienteDAO {

    EntityManager em = JPAUtil.getEntityManager();
    CriteriaBuilder cb;

    public ClienteDAO() {
    }

    public List<ClienteTO> mostrarTodos() {
        List<ClienteTO> clientes;
        String query = "select new com.pe.online.entity.ClienteTO(c.codigo,c.nombre,c.correo,c.edad) from Cliente c";
        TypedQuery<ClienteTO> typedQuery = em.createQuery(query, ClienteTO.class);
        clientes = typedQuery.getResultList();
        return clientes;
    }

    public ClienteTO seleccionar(ClienteTO cliente) {
        ClienteTO client;
        String query = "select new com.pe.online.entity.ClienteTO(c.codigo,c.nombre,c.correo,c.edad) from Cliente c where c.codigo=:codigo";
        TypedQuery<ClienteTO> typedQuery = em.createQuery(query, ClienteTO.class);
        typedQuery.setParameter("codigo", cliente.getCodigo());
        client = typedQuery.getSingleResult();
        return client;
    }
    public ClienteTO seleccionarPorId(int id) {
        ClienteTO client;
        String query = "select new com.pe.online.entity.ClienteTO(c.codigo,c.nombre,c.correo,c.edad) from Cliente c where c.codigo=:codigo";
        TypedQuery<ClienteTO> typedQuery = em.createQuery(query, ClienteTO.class);
        typedQuery.setParameter("codigo", id);
        client = typedQuery.getSingleResult();
        return client;
    }

    public void modificar(ClienteTO cliente) {
        Cliente client;

        client = em.find(Cliente.class, cliente.getCodigo());
        client.setCodigo(cliente.getCodigo());
        client.setNombre(cliente.getNombre());
        client.setCorreo(cliente.getCorreo());
        client.setEdad(cliente.getEdad());
        em.getTransaction().begin();

        em.merge(client);
        em.getTransaction().commit();
    }

    public void eliminar(ClienteTO cliente) {
        Cliente client;

        client = em.find(Cliente.class, cliente.getCodigo());
        System.out.println(client.getNombre());
        em.getTransaction().begin();

        em.remove(client);
        em.getTransaction().commit();

    }

    public void insertar(ClienteTO cliente) {
        Cliente client = new Cliente();
        client.setNombre(cliente.getNombre());
        client.setCorreo(cliente.getCorreo());
        client.setEdad(cliente.getEdad());
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();

    }

    public boolean login(ClienteTO cliente) {
        String query = "select c from Cliente c where c.nombre=:nombre and c.correo=:correo";
        Query resultado = em.createQuery(query);
        resultado.setParameter("nombre", cliente.getNombre());
        resultado.setParameter("correo", cliente.getCorreo());
        try {
            Cliente client = (Cliente) resultado.getSingleResult();
            return true;
        } catch (javax.persistence.NoResultException ex) {
            return false;
        }
    }

    public ClienteTO seleccionarPorNombre(ClienteTO cliente) {
         ClienteTO client;
        String query = "select new com.pe.online.entity.ClienteTO(c.codigo,c.nombre,c.correo,c.edad) from Cliente c where c.nombre=:nombre";
        TypedQuery<ClienteTO> typedQuery = em.createQuery(query, ClienteTO.class);
        typedQuery.setParameter("nombre",cliente.getNombre());
        client = typedQuery.getSingleResult();
        return client; }
}
