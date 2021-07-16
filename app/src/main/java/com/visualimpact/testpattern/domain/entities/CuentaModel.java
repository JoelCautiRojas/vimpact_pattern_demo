package com.visualimpact.testpattern.domain.entities;

import androidx.annotation.Keep;

@Keep
public class CuentaModel {

    private int idAplicacion;
    private String cuenta;
    private String colorFondo;
    private String colorBoton;
    private int idProyecto;
    private String color;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //
    //
    // ENUMS
    //
    //

    public enum ColorCuenta{
        RED("red"),
        GREEN("green"),
        SKYBLUE("skyblue"),
        YELLOW("yellow"),
        GRAY("gray"),
        DEFAULT("default");

        private String color;

        ColorCuenta(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }
}
