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
public class ClienteTO {
     private int codigo;
   private String nombre;
   private String correo;
   private int edad;

   public ClienteTO(){
   
   }

    public ClienteTO(int codigo, String nombre, String correo, int edad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }
   
   
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
   
   
}
