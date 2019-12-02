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

public class RegistrarActivity extends AppCompatActivity {

    public EditText user;
    public EditText email;
    public EditText password;
    public Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        user = (EditText) findViewById(R.id.txtuser);
        email = (EditText) findViewById(R.id.txtemail);
        password = (EditText) findViewById(R.id.txtpassword);
        registrar = (Button) findViewById(R.id.btnregistrarse);
    }

    public void onClick(View view) {

        registrarUsuarios();
    }

    private void registrarUsuarios() {
        SQLiteConnectionHelper connection = new SQLiteConnectionHelper(this,"bd_user",null,1);

        SQLiteDatabase db = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (user != null) {
            if (email != null) {
                if (password != null) {
                    values.put(Utilidades.CAMPO_USER, user.getText().toString());
                    values.put(Utilidades.CAMPO_EMAIL, email.getText().toString());
                    values.put(Utilidades.CAMPO_PASSWORD, password.getText().toString());

                    Long userResultante = db.insert(Utilidades.USERS_TABLE, Utilidades.CAMPO_USER, values);

                    Toast.makeText(getApplicationContext(), "Usuario_Registro: " + userResultante, Toast.LENGTH_SHORT).show();

                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ingrese un usuario", Toast.LENGTH_SHORT).show();
        }
    }
}
