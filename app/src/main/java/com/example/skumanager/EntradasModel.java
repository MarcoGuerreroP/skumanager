package com.example.skumanager;

public class EntradasModel  {
    private String IDE, DSCE, CANE;

    public EntradasModel() {
    }

    public EntradasModel(String IDE, String DSCE, String CANE) {
        this.IDE = IDE;
        this.DSCE = DSCE;
        this.CANE = CANE;
    }

    public String getIDE() {
        return IDE;
    }

    public void setIDE(String IDE) {
        this.IDE = IDE;
    }

    public String getDSCE() {
        return DSCE;
    }

    public void setDSCE(String DSCE) {
        this.DSCE = DSCE;
    }

    public String getCANE() {
        return CANE;
    }

    public void setCANE(String CANE) {
        this.CANE = CANE;
    }
}
