package com.tarwisoft.ofertoncine2.model;

public class Cine {

    private String nombreCine;
    private String descripcion;
    private String estado_abierto;
    private String foto;
    private boolean tiene_entrada;




    public Cine(String nombreCine, String descripcion, String estado_abierto, String foto, boolean tiene_entrada) {
        this.nombreCine = nombreCine;
        this.descripcion = descripcion;
        this.estado_abierto = estado_abierto;
        this.foto = foto;
        this.tiene_entrada = tiene_entrada;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado_abierto() {
        return estado_abierto;
    }

    public void setEstado_abierto(String estado_abierto) {
        this.estado_abierto = estado_abierto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isTiene_entrada() {
        return tiene_entrada;
    }

    public void setTiene_entrada(boolean tiene_entrada) {
        this.tiene_entrada = tiene_entrada;
    }
}
