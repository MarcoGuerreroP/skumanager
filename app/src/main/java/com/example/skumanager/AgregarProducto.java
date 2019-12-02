package com.example.skumanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.skumanager.utilidades.Utilidades;

public class AgregarProducto extends AppCompatActivity {

    public EditText ID,CB,DSC,UM,PU;
    public Button AgregarPr;
    public ImageView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        ID = (EditText) findViewById(R.id.txtIDE);
        CB = (EditText) findViewById(R.id.txtCB);
        DSC = (EditText) findViewById(R.id.txtDSC);
        UM = (EditText) findViewById(R.id.txtUM);
        PU = (EditText) findViewById(R.id.txtUM);
        AgregarPr = (Button) findViewById(R.id.btnAgregarPr);
        Back = (ImageView) findViewById(R.id.imgBack);
    }

    public void onClick(View view){
        registrarProductos();
    }

    private void registrarProductos() {
        SQLiteConnectionHelper connection = new SQLiteConnectionHelper(this,"bd_user",null,1);

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues valuesProd = new ContentValues();
        if (ID != null) {
            if (CB != null) {
                if (DSC != null) {
                    valuesProd.put(Utilidades.CAMPO_ID, ID.getText().toString());
                    valuesProd.put(Utilidades.CAMPO_CB, CB.getText().toString());
                    valuesProd.put(Utilidades.CAMPO_DSC, DSC.getText().toString());
                    valuesProd.put(Utilidades.CAMPO_UM, UM.getText().toString());
                    valuesProd.put(Utilidades.CAMPO_PU, PU.getText().toString());

                    //Long productResultante = db.insert(Utilidades.PRODUCTS_TABLE, Utilidades.CAMPO_ID, values);
                    Long producto = db.insert(Utilidades.PRODUCTS_TABLE, Utilidades.CAMPO_ID, valuesProd);

                    Toast.makeText(getApplicationContext(), "Producto: " + producto, Toast.LENGTH_SHORT).show();

                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Ingrese un identificador", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Ingrese un código de barras", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ingrese una descripción", Toast.LENGTH_SHORT).show();
        }
    }
}
