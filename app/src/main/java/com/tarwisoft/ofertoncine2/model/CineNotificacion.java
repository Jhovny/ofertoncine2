package com.tarwisoft.ofertoncine2.model;

public class CineNotificacion {

    private String id;
    private String title;
    private String descripcion;
    private String descount;

    public CineNotificacion() {
    }

    public CineNotificacion(String id, String title, String descripcion, String descount) {
        this.id = id;
        this.title = title;
        this.descripcion = descripcion;
        this.descount = descount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescount() {
        return descount;
    }

    public void setDescount(String descount) {
        this.descount = descount;
    }
}
