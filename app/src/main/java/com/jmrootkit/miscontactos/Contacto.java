package com.jmrootkit.miscontactos;

public class Contacto {
    private String nombre;
    private String fecha;
    private String phone;
    private String email;
    private String descripcion;

    public Contacto(String nombre, String fecha, String phone, String email) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.phone = phone;
        this.email = email;
    }

    public Contacto(String nom, String fe, String ph, String email, String desc) {
        this.nombre = nom;
        this.fecha = fe;
        this.phone = ph;
        this.email = email;
        this.descripcion = desc;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
