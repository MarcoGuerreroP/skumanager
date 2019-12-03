package com.example.skumanager;

import android.content.Intent;
import android.support.annotation.Nullable;
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

    private List<ProductsModel> productList = new ArrayList<>();
    SQLiteConnectionHelper connection;

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101) {
            if(resultCode == RESULT_OK) {
                if (productList != null && connection != null) {
                    productList.clear();
                    productList = connection.mostrarproductos();
                    productAdapter = new RecyclerViewAdapter(productList);
                    recyclerViewProducts.setAdapter(productAdapter);
                }
            }
        }
    }
}
