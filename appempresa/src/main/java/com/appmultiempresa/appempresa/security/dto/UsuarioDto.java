package com.appmultiempresa.appempresa.security.dto;

import java.sql.Timestamp;

public class UsuarioDto {

    private String nombre;
    private String nombreUsuario;
    private Timestamp datoCreacion;
    private String email;
    private String password;

    public UsuarioDto(String nombre, String nombreUsuario, Timestamp datoCreacion, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.datoCreacion = datoCreacion;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Timestamp getDatoCreacion() {
        return datoCreacion;
    }

    public void setDatoCreacion(Timestamp datoCreacion) {
        this.datoCreacion = datoCreacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
