package com.cenfotec.examen.domain;

import javax.persistence.*;

import com.cenfotec.examen.domain.Persona;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razonSocial;
    private String cedulaJuridica;
    private String direccion;
    private String telefono;



    public Cliente() {
    }

    public Cliente(Long id, String razonSocial, String cedulaJuridica, String direccion, String telefono) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cedulaJuridica = cedulaJuridica;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", razonSocial='" + razonSocial + '\'' +
                ", cedulaJuridica='" + cedulaJuridica + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
