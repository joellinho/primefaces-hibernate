/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.test;

import com.pe.online.beans.ProductoBean;
import com.pe.online.beans.UsuarioBean;
import com.pe.online.dao.PedidosDAO;
import com.pe.online.dao.ProductoDAO;
import com.pe.online.dao.UsuarioDAO;
import com.pe.online.entity.Pedidos;
import com.pe.online.entity.ProductoTO;
import com.pe.online.entity.UsuarioTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin-joel
 */
public class principal {
//    public static void main(String[] args) {
//        ProductoDAO dao = new ProductoDAO();
//        for (int i=0;i<dao.getProductosIndex().size();i++) {
//            System.out.println(dao.getProductosIndex().get(i).getImagen());
//        }
       
        
//        ProductoDAO dao2 = new ProductoDAO();
//        List<Producto>lista = dao2.getBanner();
//        
//        System.out.println(lista.get(0).getCodigo());
//        System.out.println(lista.get(1).getCodigo());
//        System.out.println(lista.get(2).getCodigo());

        
//          ProductoDAO dao3 = new ProductoDAO();
//        for (int i=0;i<dao.getThreeOfertas().size();i++) {
//            System.out.println(dao.getThreeOfertas().get(i).getImagenChica());
//        }
//          
//          ProductoDAO dao4 = new ProductoDAO();
//          Producto producto = dao4.mostrarDetalles(6);
//           System.out.println(producto.getDescripcion()); 


//--------------------probando pedidos----------------------


//        List<Pedidos> lista  ;
//        PedidosDAO dao = new PedidosDAO();
//        lista = dao.obtenerPedidos();
//        for (Pedidos pedidos : lista) {
//            System.out.println(pedidos.getCodigo()+"----"+pedidos.getCantidad()+"-----"+pedidos.getFecha());
//        }
//--------------------------probando un crud de pedidos-----------------------  
//    Pedidos pedidos = new Pedidos();
//    pedidos.setCodigo(4);
//    pedidos.setCantidad(50.0);
//    pedidos.setFecha(new Date().toString());
//    PedidosDAO daopedido = new PedidosDAO();
//    daopedido.añadirPedido(pedidos);
//    List<Pedidos> listapedidos =daopedido.obtenerPedidos();
//        for (Pedidos pedidoss : listapedidos) {
//            System.out.println(pedidoss.getCodigo());
//        }
     
//    Pedidos pedidos = new Pedidos();
//    pedidos.setCodigo(3);
//     PedidosDAO daopedido = new PedidosDAO();
//    daopedido.eliminarPedido(pedidos);
//     List<Pedidos> listapedidos =daopedido.obtenerPedidos();
//      for (Pedidos pedidoss : listapedidos) {
//            System.out.println(pedidoss.getCodigo());
//        }




//    Producto productodelete = new Producto();
//    productodelete.setCodigo(15);
//    ProductoDAO daoproducto= new ProductoDAO();
//    daoproducto.eliminar(productodelete);
//   List<Producto> listaprod = daoproducto.mostrarTodos();
//        for (Producto producto : listaprod) {
//            System.out.println(producto.getCodigo());
//            
//        }
  
/////--------------modificando un producto--------------//

//    ProductoBean prodbean = new ProductoBean();
//    List<Producto> lista = new ArrayList<>();
//      prodbean.mostraTodos();
//      lista = prodbean.getLista();
//       Producto producto = lista.get(1);
//       Producto prod = new Producto();
//       prod.setCodigo(5);
//       prod.setNombreProducto("nuevo producto");
//       prod.setImagen("nuevaimagen");
//       prod.setPrecio(500);
//       int index = lista.indexOf(producto);
//        lista.add(index, prod);
//        for (Producto producto1 : lista) {
//            System.out.println(producto1.getCodigo()+"------"+producto1.getNombreProducto());
//        }
  
//    UsuarioDAO dao = new UsuarioDAO();
//    List<Usuario> listauser =dao.getAll();
//        for (Usuario usuario : listauser) {
//            System.out.println(usuario.getUsuario());
//            
//        }

//Usuario usuario = new Usuario();
//usuario.setPassword("12345676");
//UsuarioDAO usuarioDao = new UsuarioDAO();
//        System.out.println(usuarioDao.login(usuario));
  

//Producto producto= new Producto();
//producto.setNombreProducto(" ");
//ProductoDAO prodao = new ProductoDAO();
//
//List<Producto> listaproductos=prodao.buscarPorNombre(producto);
//        for (Producto productoiter : listaproductos) {
//            System.out.println(productoiter.getNombreProducto()+productoiter.getDescripcion());
//        }
//
//
//    }
}
