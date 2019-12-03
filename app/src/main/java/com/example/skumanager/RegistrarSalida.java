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

public class RegistrarSalida extends AppCompatActivity {

    public EditText IDS,CBS,DSCS,CANTS,UMS;
    public Button registrarS;
    public ImageView lector, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_salida);

        IDS = findViewById(R.id.txtIDS);
        CBS = findViewById(R.id.txtCBS);
        DSCS = findViewById(R.id.txtDSCS);
        UMS = findViewById(R.id.txtUMS);
        CANTS = findViewById(R.id.txtCANTS);
        registrarS = findViewById(R.id.btnRegistrarS);
        lector = findViewById(R.id.imageView6);
        back = findViewById(R.id.imgBack3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salida = new Intent(RegistrarSalida.this,Menu.class);
                startActivity(salida);
            }
        });

        lector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escaner();
            }
        });
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
                CBS.setText(result.getContents().toString());
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
        public void onClick (View view){
            registrarSalidas();
        }

    public void registrarSalidas() {
        SQLiteConnectionHelper connection = ((MyApp) getApplication()).getConnection();

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues valuesProd = new ContentValues();
        if (IDS != null) {
            if (CBS != null) {
                if (DSCS != null) {
                    //valuesProd.put(Utilidades.CAMPO_IDS, IDS.getText().toString());
                    //valuesProd.put(Utilidades.CAMPO_CBS, CBS.getText().toString());
                    //valuesProd.put(Utilidades.CAMPO_DSCS, DSCS.getText().toString());
                    //float cantidad = new Float (CANTS.getText().toString());
                    //float cantidadf = new Float (cantidad * -1);
                    //valuesProd.put(Utilidades.CAMPO_CANTS, CANTS.getText().toString());
                    //valuesProd.put(Utilidades.CAMPO_UMS, UMS.getText().toString());

                    //Long productResultante = db.insert(Utilidades.PRODUCTS_TABLE, Utilidades.CAMPO_ID, values);
                    //Long salida = db.insert(Utilidades.SALIDAS_TABLE, Utilidades.CAMPO_IDS, valuesProd);

                    //Toast.makeText(getApplicationContext(), "Salida: " + salida, Toast.LENGTH_SHORT).show();

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
