package com.prueba.clovinn.domain;

import java.util.Date;

public class Articulos {

    private Long Id;
    private Long codigoArticulo;
    private String nombre;
    private String categoria;
    private Long precio;
    private Long stock;
    private Date fechaAlta;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(Long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
