/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.dao;

import Util.JPAUtil;
import com.pe.online.entity.UsuarioTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Usuario;

public class UsuarioDAO {
    
    private Map<Integer, UsuarioTO> fuente = new HashMap<>();
    
    public UsuarioDAO() {
        poblar();
    }
    
    private void poblar() {
        UsuarioTO usuario1 = new UsuarioTO();
        usuario1.setCodigo(1);
        usuario1.setUsuario("enciso");
        usuario1.setPassword("123456");
        
        UsuarioTO usuario2 = new UsuarioTO();
        usuario2.setCodigo(2);
        usuario2.setUsuario("cibertec");
        usuario2.setPassword("1234567");
        
        UsuarioTO usuario3 = new UsuarioTO();
        usuario3.setCodigo(3);
        usuario3.setUsuario("javier");
        usuario3.setPassword("123");
        
        UsuarioTO usuario4 = new UsuarioTO();
        usuario4.setCodigo(4);
        usuario4.setUsuario("miguel");
        usuario4.setPassword("12345");
        
        fuente.put(1, usuario1);
        fuente.put(2, usuario2);
        fuente.put(3, usuario3);
        fuente.put(4, usuario4);
        
    }
    
    public List<UsuarioTO> getAll() {
        List<UsuarioTO> listausuario = new ArrayList<>();
        JPAUtil.init("OnlineStorePU");
        String cnsulta = "SELECT new com.pe.online.entity.UsuarioTO(u.id,u.usuario,u.password) FROM Usuario u ";
        TypedQuery<UsuarioTO> typedQuery = JPAUtil.getEntityManager().createQuery(cnsulta, UsuarioTO.class);
        listausuario = typedQuery.getResultList();
        JPAUtil.closeEntityManager();
        return listausuario;
    }
    
    public boolean login(UsuarioTO usuario) {
        boolean bandera = false;
        for (int i = 1; i <= fuente.size(); i++) {
            if (fuente.get(i).getPassword().equals(usuario.getPassword())) {
                bandera = true;
            }
        }
        
        return bandera;
        
    }
    
    public void agregar(UsuarioTO usuarioTO) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(usuarioTO.getUsuario());
        usuario.setPassword(usuarioTO.getPassword());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    public void eliminar(UsuarioTO usuarioTO) {
        Usuario usuario = new Usuario();
        String query = "select u from Usuario u where id =:codigo";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Usuario> typedQuery = em.createQuery(query, Usuario.class);
        typedQuery.setParameter("codigo", usuarioTO.getCodigo());
        usuario = typedQuery.getSingleResult();
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
    public UsuarioTO seleccionar(UsuarioTO usuarioTO) {
        UsuarioTO usuarioTo = new UsuarioTO();
        String query = "select new com.pe.online.entity.UsuarioTO(u.id,u.usuario,u.password)  from Usuario u where id=:codigo";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<UsuarioTO> typedQuery = em.createQuery(query, UsuarioTO.class);
        typedQuery.setParameter("codigo", usuarioTO.getCodigo());
        usuarioTo = typedQuery.getSingleResult();
        em.close();
        return usuarioTo;
    }
    
    public void modificar(UsuarioTO usuarioTo) {
        Usuario usuario = new Usuario();
        String query = "select u from Usuario u where id =:codigo";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Usuario> typedQuery = em.createQuery(query, Usuario.class);
        typedQuery.setParameter("codigo", usuarioTo.getCodigo());
        
        usuario = typedQuery.getSingleResult();
        usuario.setId(usuarioTo.getCodigo());
        usuario.setUsuario(usuarioTo.getUsuario());
        usuario.setPassword(usuarioTo.getPassword());
        em.getTransaction().begin();
        em.merge(usuario);
        
        em.getTransaction().commit();
        em.close();
    }
    
}
