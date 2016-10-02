/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.test;

import Util.JPAUtil;
import com.pe.online.entity.ProductoTO;
import com.pe.online.entity.UsuarioTO;
import model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author admin-joel
 */
public class persistenceTest {

//    public static void main(String[] args) {
////        JPAUtil.init("OnlineStorePU");
//
//       //ss consultar();
/////////////////////////eliminar
////        Usuario usuario = new Usuario();
////        usuario.setId(5);
////        eliminar(usuario);
////        buscarXId(2);
//
//
////  UsuarioTO usuarioTo = seleccionar();
////        System.out.println(usuarioTo.getUsuario());
//
//encontrarProductos();
//
//    }
//
//    public static void consultar() {
//        EntityManager em = JPAUtil.getEntityManager();
//        String consulta = "SELECT u FROM Usuario u ";
//        Query query = em.createQuery(consulta);
//        List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
//        for (Usuario usuario : listaUsuario) {
//            System.out.println(usuario.getUsuario());
//
//        }
//        em.close();
//    }
//
//    public static void eliminar(Usuario usuario) {
//        EntityManager em = JPAUtil.getEntityManager();
//        em.getTransaction().begin();
//        em.remove(usuario);
//        em.getTransaction().commit();
//        em.close();
//    }
// public static void buscarXId(int id){
//     Usuario usuario = null;
//     String query = "select u from Usuario u where id =:codigo";
//
//        EntityManager em = JPAUtil.getEntityManager();
//        em.getTransaction().begin();
//        TypedQuery<Usuario> typedQuery = em.createQuery(query,Usuario.class);
//        typedQuery.setParameter("codigo", id);
//        usuario =typedQuery.getSingleResult();
//        em.remove(usuario);
//        em.getTransaction().commit();
//        em.close();
//        System.out.println(usuario.getId()+"--"+usuario.getUsuario());
//        
// }
//public static UsuarioTO seleccionar(){
//UsuarioTO usuarioTo = new UsuarioTO();
//        String query = "select new com.pe.online.entity.UsuarioTO(u.id,u.usuario,u.password) from Usuario u where id=6";
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineStorePU");
//        EntityManager em = emf.createEntityManager();
//       
//        TypedQuery<UsuarioTO> typedQuery = em.createQuery(query, UsuarioTO.class);
////        typedQuery.setParameter("codigo",2);
//        usuarioTo = typedQuery.getSingleResult();
//        em.close();
//        return usuarioTo;
//}
//
//public static void encontrarProductos(){
//    EntityManager em = JPAUtil.getEntityManager();
//    ProductoTO productoTO ;
//    String query = "select new com.pe.online.entity.ProductoTO(p.codigo,p.codigoCategoria,p.codigoSubcategoria,p.nombreProducto,p.imagen,p.descripcion,p.precio,p.imagenChica,p.imagenGrande,p.bannerChico,p.bannerGrande) from Producto p where p.bannerGrande='si'";
//        TypedQuery<ProductoTO> typedQuery = em.createQuery(query, ProductoTO.class);
//    List<ProductoTO> listaProductos = typedQuery.getResultList();
//    for (ProductoTO listaProducto : listaProductos) {
//        System.out.println(listaProducto.getNombreProducto()+"--"+listaProducto.getImagenGrande()+"--" +listaProducto.getBannerGrande());
//    }
//}
}
