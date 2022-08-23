package com.appmultiempresa.appempresa.dto;

public class ProductoEmpDto {

    private String nombre;
    private String detalles;
    private String servicio;

    public ProductoEmpDto() {
    }

    public ProductoEmpDto(String nombre, String detalles, String servicio) {
        this.nombre = nombre;
        this.detalles = detalles;
        this.servicio = servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
}
