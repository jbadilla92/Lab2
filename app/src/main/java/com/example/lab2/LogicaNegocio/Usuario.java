package com.example.lab2.LogicaNegocio;

import java.io.Serializable;

/**
 * Created by Luis Carrillo Rodriguez on 26/3/2018.
 */

public class Usuario implements Serializable {
    private String correo;
    private String contraseña;
    private String cedula;
    private String privilegio;

    public Usuario() {
        this.correo = "none";
        this.contraseña = "none";
        this.privilegio = "none";
    }

    public Usuario(String correo, String contraseña, String privilegio, String cedula) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.cedula = cedula;
        this.privilegio = privilegio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", cedula='" + cedula + '\'' +
                ", privilegio='" + privilegio + '\'' +
                '}';
    }
}
