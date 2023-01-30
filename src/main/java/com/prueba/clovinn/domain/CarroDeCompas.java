package com.prueba.clovinn.domain;

public class CarroDeCompas {
    private Long Id;
    private Long codigoArticulo;
    private Long cantArticulo;
    private Long codigoUsuario;
    private String estado;

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

    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getCantArticulo() {
        return cantArticulo;
    }

    public void setCantArticulo(Long cantArticulo) {
        this.cantArticulo = cantArticulo;
    }
}
