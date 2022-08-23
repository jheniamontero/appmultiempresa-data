package com.appmultiempresa.appempresa.security.entity;

import com.appmultiempresa.appempresa.security.enums.RolNombre;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING) //tipo string
    private RolNombre rolNombre;

    //CONSTRUCNOTES VACIOS
    public Rol() {
    }
    //PARA PODER UTILIZARLOS ENLO LOGIN Y DEMAS
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    //getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
