package com.example.skumanager;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.skumanager.utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class SQLiteConnectionHelper extends SQLiteOpenHelper {



    public SQLiteConnectionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREATE_USERS_TABLE);
        db.execSQL(Utilidades.CREATE_PRODUCTS_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS");
        onCreate(db);
    }

    //Validación de usuarios
    public Cursor ConsultarUsers(String user, String password) throws SQLException {
        Cursor mcursor = null;
        mcursor  = this.getReadableDatabase().query("users",new String []
                {"user","email","password"},"user like '" + user + "' and password like '" + password + "'",
                 null,null,null,null);

        return mcursor;
    }

    //Obtener productos
    public List<ProductsModel> mostrarproductos(){
        SQLiteDatabase BD = getReadableDatabase();
        Cursor cursor  = BD.query("users",new String[] {"ide,dsc,pu"},null,null,null,null,null);
        List<ProductsModel> productos = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                productos.add(new ProductsModel(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return productos;
    }
}
