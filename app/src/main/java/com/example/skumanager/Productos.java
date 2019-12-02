package com.example.skumanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Productos extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private RecyclerViewAdapter productAdapter;
    public ImageView agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        SQLiteConnectionHelper connection = ((MyApp) getApplication()).getConnection();

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerViewProducts = findViewById(R.id.productrecycler);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));

        productAdapter = new RecyclerViewAdapter(connection.mostrarproductos());
        recyclerViewProducts.setAdapter(productAdapter);

        agregar = (ImageView) findViewById(R.id.imgAgregarProd);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Productos.this,AgregarProducto.class);
                startActivity(i);
            }
        });
    }

    //public List<ProductsModel> obtenerproductos;
    //List<ProductsModel> products = new ArrayList<>();
    //products.add(new ProductsModel(""))
}
