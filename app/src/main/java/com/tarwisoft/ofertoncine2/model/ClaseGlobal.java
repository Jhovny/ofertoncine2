package com.tarwisoft.ofertoncine2.model;
import android.app.Application;

/**
 * Created by Usuario on 6/05/2018.
 */

public class ClaseGlobal extends Application {

    private String usuarioApp;
    private String claveApp;
    private String imeiApp;
    private String numeroApp;

    public String getImeiApp() {
        return imeiApp;
    }
    public void setImeiApp(String imeiApp) {
        this.imeiApp = imeiApp;
    }

    public String getNumeroApp() {
        return numeroApp;
    }
    public void setNumeroApp(String numeroApp) {
        this.numeroApp = numeroApp;
    }

    public String getUsuarioApp() {
        return usuarioApp;
    }
    public void setUsuarioApp(String usuarioApp) {
        this.usuarioApp = usuarioApp;
    }

    public String getClaveApp() {
        return claveApp;
    }
    public void setClaveApp(String claveApp) {
        this.claveApp = claveApp;
    }


}