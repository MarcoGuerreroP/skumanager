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

        SQLiteConnectionHelper connection = new SQLiteConnectionHelper(this,"bd_user",null,1);

        recyclerViewProducts = (RecyclerView) findViewById(R.id.productrecycler);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));

        productAdapter = new RecyclerViewAdapter(SQLiteConnectionHelper.mostrarproductos());

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
