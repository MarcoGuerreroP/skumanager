package com.example.skumanager.utilidades;

public class Utilidades {

    //Constantes campos tabla Usuarios
    public static final String USERS_TABLE = "users";
    public static final String CAMPO_USER = "user";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASSWORD = "password";

    //Campos tabla productos
    public static final String PRODUCTS_TABLE = "products";
    public static final String CAMPO_ID = "ide";
    public static final String CAMPO_DSC = "dsc";
    public static final String CAMPO_CB = "cb";
    public static final String CAMPO_PU = "pu";
    public static final String CAMPO_UM = "um";

    //Campos tabla entradas
    public static final String ENTRADAS_TABLE = "entradas";
    public static final String CAMPO_IDE = "idee";
    public static final String CAMPO_DSCE = "dsce";
    public  static final String CAMPO_CBE = "cbe";
    public static final String CAMPO_CANTE = "cante";
    public static final String CAMPO_UME =  "ume";


    public static final String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE + "("+ CAMPO_USER +" INTEGER, "+ CAMPO_EMAIL +" STRING, "
            + CAMPO_PASSWORD +" STRING)";

    public static final String CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS " + PRODUCTS_TABLE + "(" + CAMPO_ID + " STRING, " + CAMPO_DSC + " STRING, "
            + CAMPO_CB + " STRING, " + CAMPO_PU + " STRING, " + CAMPO_UM + " STRING)";

    public static final String CREATE_ENTRADAS_TABLE = "CREATE TABLE IF NOT EXISTS " + ENTRADAS_TABLE + "(" + CAMPO_IDE + " STRING, " + CAMPO_DSCE + " STRING, "
            + CAMPO_CBE + " STRING, " + CAMPO_CANTE + " STRING, " + CAMPO_UME + " STRING)";

}
