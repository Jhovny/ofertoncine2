package com.tarwisoft.ofertoncine2.Common;

public class Constante {
    private static final Constante ourInstance = new Constante();

    public static Constante getInstance() {
        return ourInstance;
    }

    private Constante() {

    }

    public static String  URL_SERVICIO_CINE ="http://upc.tarwisoft.com/api/cines";
    public static String  URL_SERVICIO_OFERTAS ="http://upc.tarwisoft.com/api/ofertas";
    public static String  URL_SERVICIO_BENIFICIOS ="http://upc.tarwisoft.com/api/benificio";

}
