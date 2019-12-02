package com.example.skumanager;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView btnregistrarse;
    public Button ingresar;

    SQLiteConnectionHelper connection = new SQLiteConnectionHelper(this,"bd_user",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnregistrarse = (TextView) findViewById(R.id.txtregistrarse);

        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(MainActivity.this,RegistrarActivity.class);
                startActivity(registrarse);

            }
        });


        ingresar = findViewById(R.id.btningresar);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user  = (EditText) findViewById(R.id.txtuser);
                EditText password  = (EditText) findViewById(R.id.txtpassword);

               try {
                   Cursor cursor = connection.ConsultarUsers(user.getText().toString(), password.getText().toString());
                   if (user != null) {
                       if (cursor.getCount() > 0) {
                           Intent i = new Intent(getApplicationContext(), Menu.class);
                           startActivity(i);
                       } else {
                           Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
                       }
                       user.setText("");
                       password.setText("");
                       user.findFocus();
                   }else{
                       Toast.makeText(getApplicationContext(), "Ingrese un usuario", Toast.LENGTH_LONG).show();
                   }
               } catch (SQLException e) {
                   e.printStackTrace();
               }
            }
        });
    }



}
