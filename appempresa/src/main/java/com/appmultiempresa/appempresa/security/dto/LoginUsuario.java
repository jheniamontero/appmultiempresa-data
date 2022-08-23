package com.appmultiempresa.appempresa.security.dto;

import javax.persistence.Column;

public class LoginUsuario {

    private String nombreUsuario;
    private String password;

    //getters and setters

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
