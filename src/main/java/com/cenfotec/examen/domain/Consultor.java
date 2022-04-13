package com.cenfotec.examen.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Consultor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;

    private String telefono;
    private String email;
    private String disponibilidadViaje;
    private String especialidad;
    private boolean estado;


    public Consultor(Long id, String nombre, String apellido1, String apellido2, String direccion, Date dateOfBirth, String telefono, String email, String disponibilidadViaje, String especialidad, Boolean estado)throws ParseException {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.dateOfBirth = dateOfBirth;
        this.telefono = telefono;
        this.email = email;
        this.disponibilidadViaje = disponibilidadViaje;
        this.especialidad = especialidad;
        this.estado = estado;
    }


    public Consultor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisponibilidadViaje() {
        return disponibilidadViaje;
    }

    public void setDisponibilidadViaje(String disponibilidadViaje) {
        this.disponibilidadViaje = disponibilidadViaje;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        StringBuilder value = new StringBuilder("ConsultorEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Apellidos: ");
        value.append(apellido1+" "+apellido2);
        value.append(",Dirección: ");
        value.append(direccion);
        value.append(",Fecha de nacimiento: ");
        value.append(dateOfBirth);
        value.append(")");
        return value.toString();
    }

}