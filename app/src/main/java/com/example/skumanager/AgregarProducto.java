package com.example.skumanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.skumanager.utilidades.Utilidades;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class AgregarProducto extends AppCompatActivity {

    public EditText ID, CB, DSC, UM, PU;
    public Button AgregarPr;
    public ImageView Back;
    public ImageView lector;

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
        lector = (ImageView) findViewById(R.id.imageView);

        lector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escaner();
            }
        });

    }


    public void onClick(View view) {
        registrarProductos();
    }

    private void registrarProductos() {
        SQLiteConnectionHelper connection = ((MyApp) getApplication()).getConnection();

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues valuesProd = new ContentValues();
        setResult(RESULT_OK);
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

                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese un identificador", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Ingrese un código de barras", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Ingrese una descripción", Toast.LENGTH_SHORT).show();
        }
    }

    public void escaner() {
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);

        intent.setPrompt("Escanear Codigo");
        intent.setCameraId(0);
        intent.setBeepEnabled(false);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {

            if (result.getContents() == null) {
                Toast.makeText(this, "Cacelaste el escaneo", Toast.LENGTH_LONG).show();

            } else {
                CB.setText(result.getContents().toString());
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}

