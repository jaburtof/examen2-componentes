package com.cenfotec.examen.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String auditoriaRealizar;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha;
    private String clienteReferencia;

    public Trabajo() {
    }

    public Trabajo(long id, String auditoriaRealizar, Date fecha, String clienteReferencia) throws ParseException {
        this.id = id;
        this.auditoriaRealizar = auditoriaRealizar;
        this.fecha = fecha;
        this.clienteReferencia = clienteReferencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuditoriaRealizar() {
        return auditoriaRealizar;
    }

    public void setAuditoriaRealizar(String auditoriaRealizar) {
        this.auditoriaRealizar = auditoriaRealizar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClienteReferencia() {
        return clienteReferencia;
    }

    public void setClienteReferencia(String clienteReferencia) {
        this.clienteReferencia = clienteReferencia;
    }
}
