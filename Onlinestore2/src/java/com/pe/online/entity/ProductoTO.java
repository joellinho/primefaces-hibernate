/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.online.entity;

/**
 *
 * @author admin-joel
 */
public class ProductoTO {
    private int codigo;
  private int codigoCategoria;
  private int codigoSubcategoria;
  private String nombreProducto;
  private String imagen;
  private String descripcion;
  private double precio;
  private String imagenChica;
  private String imagenGrande;
  private String bannerChico;
  private String bannerGrande;
  private String mensajeprueba;

    public ProductoTO() {
    }

    public ProductoTO(int codigo, int codigoCategoria, int codigoSubcategoria, String nombreProducto, String imagen, String descripcion, double precio, String imagenChica, String   imagenGrande, String bannerChico, String bannerGrande) {
        this.codigo = codigo;
        this.codigoCategoria = codigoCategoria;
        this.codigoSubcategoria = codigoSubcategoria;
        this.nombreProducto = nombreProducto;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenChica = imagenChica;
        this.imagenGrande = imagenGrande;
        this.bannerChico = bannerChico;
        this.bannerGrande = bannerGrande;
    }

    
    public String getMensajeprueba() {
        return mensajeprueba;
    }

    public void setMensajeprueba(String mensajeprueba) {
        this.mensajeprueba = mensajeprueba;
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
  public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
        System.out.println("obteniendo el codigo con el get");
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

}
