package com.example.skumanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    public ImageView imgproductos, imgentrada,imgsalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imgproductos = (ImageView) findViewById(R.id.imgproductos);
        imgproductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productos = new Intent(Menu.this,Productos.class);
                startActivity(productos);
            }
        });

        imgentrada = (ImageView) findViewById(R.id.imgEntrada);
        imgentrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entrada = new Intent(Menu.this,RegistrarEntrada.class);
                startActivity(entrada);
            }
        });

        imgsalida = (ImageView) findViewById(R.id.imgSalidas);
        imgsalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salida = new Intent(Menu.this,RegistrarSalida.class);
                startActivity(salida);
            }
        });
    }
}
