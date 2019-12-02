package com.example.skumanager.tablas;

public class Products {
    private String IDE;
    private String Descripcion;
    private String CB;
    private String PU;
    private String UM;


    public Products(String IDE, String descripcion, String CB, String PU, String UM) {
        this.IDE = IDE;
        this.Descripcion = descripcion;
        this.CB = CB;
        this.PU = PU;
        this.UM = UM;
    }

    public String getID() {
        return IDE;
    }

    public void setID(String ID) {
        this.IDE = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCB() {
        return CB;
    }

    public void setCB(String CB) {
        this.CB = CB;
    }

    public String getPU() {
        return PU;
    }

    public void setPU(String PU) {
        this.PU = PU;
    }

    public String getUM() {
        return UM;
    }

    public void setUM(String UM) {
        this.UM = UM;
    }
}
