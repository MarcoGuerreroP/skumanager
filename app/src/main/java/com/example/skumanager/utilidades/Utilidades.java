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

    //Campos tabla entradas
    public static final String SALIDAS_TABLE = "salidas";
    public static final String CAMPO_IDS = "ides";
    public static final String CAMPO_DSCS = "dscs";
    public  static final String CAMPO_CBS = "cbs";
    public static final String CAMPO_CANTS = "cants";
    public static final String CAMPO_UMS =  "ums";


    // CREATE TABLE users(user INTEGER, email STRING, password STRING)
    public static final String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE + "("+ CAMPO_USER +" INTEGER, "+ CAMPO_EMAIL +" TEXT, "
            + CAMPO_PASSWORD +" TEXT)";

    // CREATE TABLE IF NOT EXISTS products(ide STRING, dsc STRING, cb STRING, pu STRING, um STRING)
    public static final String CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS " + PRODUCTS_TABLE + "(" + CAMPO_ID + " TEXT, " + CAMPO_DSC + " TEXT, "
            + CAMPO_CB + " TEXT, " + CAMPO_PU + " TEXT, " + CAMPO_UM + " TEXT)";

    // CREATE TABLE IF NOT EXISTS entradas(idee STRING, dsce STRING, cbe STRING, cante STRING, ume STRING)
    public static final String CREATE_ENTRADAS_TABLE = "CREATE TABLE IF NOT EXISTS " + ENTRADAS_TABLE + "(" + CAMPO_IDE + " TEXT, " + CAMPO_DSCE + " TEXT, "
            + CAMPO_CBE + " TEXT, " + CAMPO_CANTE + " TEXT, " + CAMPO_UME + " TEXT)";

    public static final String CREATE_SALIDAS_TABLE = "CREATE TABLE IF NOT EXISTS " + SALIDAS_TABLE + "(" + CAMPO_IDS + " TEXT, " + CAMPO_DSCS + " TEXT, "
            + CAMPO_CBS + " TEXT, " + CAMPO_CANTS + " TEXT, " + CAMPO_UMS + " TEXT)";

}
