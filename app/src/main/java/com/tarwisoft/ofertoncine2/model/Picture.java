package com.tarwisoft.ofertoncine2.model;

public class Picture {

    private String picture;
    private String titulo_pelicula;
    private String decripcion;
    private String like;
    private String line_number;
    private int codigoOferta;

    public Picture(String picture, String titulo_pelicula, String decripcion, String like, String line_number, int codigo_oferta) {
        this.picture = picture;
        this.titulo_pelicula = titulo_pelicula;
        this.decripcion = decripcion;
        this.like = like;
        this.line_number = line_number;
        this.codigoOferta=codigo_oferta;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitulo_pelicula() {
        return titulo_pelicula;
    }

    public void setTitulo_pelicula(String titulo_pelicula) {
        this.titulo_pelicula = titulo_pelicula;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getLine_number() {
        return line_number;
    }

    public void setLine_number(String line_number) {
        this.line_number = line_number;
    }

    public int getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(int codigoOferta) {
        this.codigoOferta = codigoOferta;
    }
}
