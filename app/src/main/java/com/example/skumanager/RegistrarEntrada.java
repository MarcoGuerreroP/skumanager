package com.example.skumanager;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.skumanager.utilidades.Utilidades;

public class RegistrarEntrada extends AppCompatActivity {

    public EditText IDE,CBE,DSCE,CANTE,UME;
    public Button registrarE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entrada);

        IDE = findViewById(R.id.txtIDE);
        CBE = findViewById(R.id.txtCBE);
        DSCE = findViewById(R.id.txtDSCE);
        UME = findViewById(R.id.txtUME);
        CANTE = findViewById(R.id.txtUM);
        registrarE = findViewById(R.id.btnRegistrarE);
    }

    public void onClick(View view){
        registrarEntradas();
    }

    public void registrarEntradas() {
        SQLiteConnectionHelper connection = new SQLiteConnectionHelper(this,"bd_user",null,1);

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues valuesEntrada = new ContentValues();
        if (IDE != null) {
            if (CBE != null) {
                if (DSCE != null) {
                    valuesEntrada.put(Utilidades.CAMPO_IDE, IDE.getText().toString());
                    valuesEntrada.put(Utilidades.CAMPO_CBE, CBE.getText().toString());
                    valuesEntrada.put(Utilidades.CAMPO_DSCE, DSCE.getText().toString());
                    valuesEntrada.put(Utilidades.CAMPO_CANTE, CANTE.getText().toString());
                    valuesEntrada.put(Utilidades.CAMPO_UME, UME.getText().toString());

                    //Long productResultante = db.insert(Utilidades.PRODUCTS_TABLE, Utilidades.CAMPO_ID, values);
                    Long entrada = db.insert(Utilidades.ENTRADAS_TABLE, Utilidades.CAMPO_IDE, valuesEntrada);

                    Toast.makeText(getApplicationContext(), "Entrada: " + entrada, Toast.LENGTH_SHORT).show();

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
