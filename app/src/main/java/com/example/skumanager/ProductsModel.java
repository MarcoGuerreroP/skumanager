package com.example.skumanager;

public class ProductsModel {
    private String ID, producto, preciou;

    public ProductsModel() {
    }

    public ProductsModel(String ID, String producto, String preciou) {
        this.ID = ID;
        this.producto = producto;
        this.preciou = preciou;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPreciou() {
        return preciou;
    }

    public void setPreciou(String preciou) {
        this.preciou = preciou;
    }
}
