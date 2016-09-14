/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.ProductoDAO;
import com.pe.online.entity.ProductoTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class ShoppingBean {

    CarItemBean selected;

    public ShoppingBean() {
        selected = new CarItemBean();
    }

    public List<ProductoTO> getProductosIndex() {
        ProductoDAO dao = new ProductoDAO();
        List<ProductoTO> lista = dao.getProductosIndex();
        return lista;
    }

    public List<ProductoTO> getBanner() {
        List<ProductoTO> lista = new ArrayList<ProductoTO>();
        try {
            ProductoDAO dao = new ProductoDAO();
            lista = dao.getBanner();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<ProductoTO> getOfertas() {
        ProductoDAO dao = new ProductoDAO();
        List<ProductoTO> lista = dao.getThreeOfertas();
        return lista;

    }

    public String addToCart(int codigo, int cantidad) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CarItemBean> carrito = (List<CarItemBean>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        ProductoTO producto = new ProductoDAO().mostrarDetalles(codigo);

        CarItemBean item = new CarItemBean();
        item.setCodigo(codigo);
        item.setNombre(producto.getNombreProducto());
        item.setPrecio(producto.getPrecio());

        int indexe = existe(codigo);
        if (indexe != -1) {
            int cantidaditem = carrito.get(indexe).getCantidad();

//        carrito.remove(index);
            item.setCantidad(cantidad + cantidaditem);
            removetoCart(indexe);
        } else {

            item.setCantidad(cantidad);
        }

        item.calcularTotal();
        carrito.add(item);
        session.setAttribute("carrito", carrito);
        return "carrito.xhtml?faces-redirect=true";
    }

    public List<CarItemBean> getCarrito() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CarItemBean> carrito = (List<CarItemBean>) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new ArrayList<CarItemBean>();
        }
        return carrito;
    }

    public String VaciarCar() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CarItemBean> carrito = new ArrayList<>();

        session.setAttribute("carrito", carrito);
        return "carrito";
    }

    public double calcularTotal() {
        List<CarItemBean> carrito = getCarrito();
        double total = 0.0;
        if (carrito == null) {
            return total;
        }
        for (CarItemBean carItemBean : carrito) {
            total += carItemBean.getTotal();
        }
        return total;
    }

    public int existe(int codigoitem) {
        List<CarItemBean> lista = getCarrito();
        int codigolocal = 0;
        for (CarItemBean carItemBean : lista) {
            if (codigoitem == carItemBean.getCodigo()) {

                return codigolocal;

            }
            codigolocal++;
        }
        return -1;
    }

    public void removetoCart(int index) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CarItemBean> carrito = getCarrito();
        carrito.remove(index);
        session.setAttribute("carrito", carrito);
    }

    public void remove(int codigo) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        List<CarItemBean> carrito = getCarrito();
        ProductoTO producto = new ProductoDAO().mostrarDetalles(codigo);

        CarItemBean item = new CarItemBean();
        item.setCodigo(codigo);
        item.setNombre(producto.getNombreProducto());
        item.setPrecio(producto.getPrecio());
        int indexe = existe(codigo);
        if (indexe != -1) {
            removetoCart(indexe);
            calcularTotal();
        }
        session.setAttribute("carrito", carrito);
    }

    public void toEnglish() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale("en"));
    }

    public void toSpanish() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
        FacesContext.getCurrentInstance().getApplication().setDefaultLocale(new Locale("es"));
    }

}
