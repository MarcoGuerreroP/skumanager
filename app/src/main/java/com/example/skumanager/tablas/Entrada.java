package com.example.skumanager.tablas;

public class Entrada {
    private String IDEE;
    private String DSCE;
    private String CBE;
    private String CANTE;
    private String UME;

    public Entrada(String IDEE, String DSCE, String CBE, String CANTE, String UME) {
        this.IDEE = IDEE;
        this.DSCE = DSCE;
        this.CBE = CBE;
        this.CANTE = CANTE;
        this.UME = UME;
    }

    public String getIDEE() {
        return IDEE;
    }

    public void setIDEE(String IDEE) {
        this.IDEE = IDEE;
    }

    public String getDSCE() {
        return DSCE;
    }

    public void setDSCE(String DSCE) {
        this.DSCE = DSCE;
    }

    public String getCBE() {
        return CBE;
    }

    public void setCBE(String CBE) {
        this.CBE = CBE;
    }

    public String getCANTE() {
        return CANTE;
    }

    public void setCANTE(String CANTE) {
        this.CANTE = CANTE;
    }

    public String getUME() {
        return UME;
    }

    public void setUME(String UME) {
        this.UME = UME;
    }
}
