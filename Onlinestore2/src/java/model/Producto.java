/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admin-joel
 */
@Entity
@Table(name = "producto")
@NamedQuery(name = "producto.findAll" ,query = "select p from Producto p")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(name = "codigo_categoria")
    @NotNull
    private int codigoCategoria;

    @Column(name = "codigo_subcategoria")
    private int codigoSubcategoria;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "imagen_producto")
    private String imagen;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "imagen_chica")
    private String imagenChica;
    
    @Column(name = "imagen_grande")
    private String imagenGrande;
    
    @Column(name = "banner_chico")
    private String bannerChico;
    
    @Column(name = "banner_grande")
    private String bannerGrande;
   

    public Producto() {
    }

    public Producto(Integer codigo) {
        this.codigo = codigo;
    }

    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public int getCodigoSubcategoria() {
        return codigoSubcategoria;
    }

    public void setCodigoSubcategoria(int codigoSubcategoria) {
        this.codigoSubcategoria = codigoSubcategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagenChica() {
        return imagenChica;
    }

    public void setImagenChica(String imagenChica) {
        this.imagenChica = imagenChica;
    }

    public String getImagenGrande() {
        return imagenGrande;
    }

    public void setImagenGrande(String imagenGrande) {
        this.imagenGrande = imagenGrande;
    }

    public String getBannerChico() {
        return bannerChico;
    }

    public void setBannerChico(String bannerChico) {
        this.bannerChico = bannerChico;
    }

    public String getBannerGrande() {
        return bannerGrande;
    }

    public void setBannerGrande(String bannerGrande) {
        this.bannerGrande = bannerGrande;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "Producto{" + "codigo=" + codigo + '}';
//    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", codigoCategoria=" + codigoCategoria + ", codigoSubcategoria=" + codigoSubcategoria + ", nombreProducto=" + nombreProducto + ", imagen=" + imagen + ", descripcion=" + descripcion + ", precio=" + precio + ", imagenChica=" + imagenChica + ", imagenGrande=" + imagenGrande + ", bannerChico=" + bannerChico + ", bannerGrande=" + bannerGrande + '}';
    }
    

}
