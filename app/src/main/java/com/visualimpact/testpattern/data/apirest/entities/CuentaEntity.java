package com.visualimpact.testpattern.data.apirest.entities;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
public class CuentaEntity {

    @SerializedName("idAplicacion")
    @Expose
    private int idAplicacion;
    @SerializedName("cuenta")
    @Expose
    private String cuenta;
    @SerializedName("colorFondo")
    @Expose
    private String colorFondo;
    @SerializedName("colorBoton")
    @Expose
    private String colorBoton;
    @SerializedName("idProyecto")
    @Expose
    private int idProyecto;

    public int getIdAplicacion() {
        return idAplicacion;
    }

    public void setIdAplicacion(int idAplicacion) {
        this.idAplicacion = idAplicacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getColorBoton() {
        return colorBoton;
    }

    public void setColorBoton(String colorBoton) {
        this.colorBoton = colorBoton;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }
}
