
/*
 * To change producto license header, choose License Headers in Project Properties.
 * To change producto template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.beans;

import com.pe.online.dao.ProductoDAO;
import com.pe.online.entity.ProductoTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class ProductoBean implements Serializable {

    ProductoTO producto;

    private List<ProductoTO> lista;
    private List<ProductoTO> listaFiltrada;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<ProductoTO> getLista() {
        return lista;
    }

    public void setLista(List<ProductoTO> lista) {
        this.lista = lista;
    }

    public ProductoTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoTO producto) {
        this.producto = producto;
    }

    public ProductoBean() {
        lista = new ArrayList<>();
        producto = new ProductoTO();
    }

    public void mostraTodos() {
        ProductoDAO dao = new ProductoDAO();

        lista = dao.mostrarTodos();

    }

    public String mostrarDetalles(int codigo) {

        ProductoDAO dao = new ProductoDAO();
        producto = dao.mostrarDetalles(codigo);

        return "detalles.xhtml?faces-redirect=true";
    }

    public List<ProductoTO> eliminar(ProductoTO producto) {
        lista.remove(producto);
        limpiar();
        return lista;

    }

    public void seleccionar(ProductoTO prod) {

        int index = lista.indexOf(prod);
        producto = lista.get(index);
        this.accion = "modificar";
    }

    public List<ProductoTO> editar() {

        int index = lista.indexOf(producto);

        lista.add(index, producto);
        lista.remove(index + 1);
        accion = "";

        return lista;

    }

    public List<ProductoTO> adicionar() {
        int size = lista.size();
        producto.setCodigo(size + 1);
        lista.add(producto);
        return lista;
    }

    public void limpiar() {
        producto = new ProductoTO();

    }

    public void operar() {
        switch (accion) {
            case "nuevo":
                adicionar();
                limpiar();

                break;
            case "modificar":
                editar();
                limpiar();

                break;

        }
    }

    public void buscarPorNombre() {
        ProductoDAO pordao = new ProductoDAO();
        lista = pordao.buscarPorNombre(producto);
    }

}
