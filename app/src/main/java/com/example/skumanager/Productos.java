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

    private List<ProductsModel> productList = new ArrayList<>();
    SQLiteConnectionHelper connection;

    private List<ProductsModel> productList = new ArrayList<>();
    SQLiteConnectionHelper connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        connection = ((MyApp) getApplication()).getConnection();

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerViewProducts = findViewById(R.id.productrecycler);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));

        productList = connection.mostrarproductos();

        productAdapter = new RecyclerViewAdapter(productList);
        recyclerViewProducts.setAdapter(productAdapter);

<<<<<<< HEAD
=======
<<<<<<< HEAD
        agregar = findViewById(R.id.imgAgregarProd);
=======
>>>>>>> b1a2fd809430f19d2a7d23d9641d1ce344a5220f

        agregar = (ImageView) findViewById(R.id.imgAgregarProd);
>>>>>>> Cambios de aplicacion de sku mnager list view icon etc
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Productos.this,AgregarProducto.class);
                startActivityForResult(i, 101);
            }
        });
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> Cambios de aplicacion de sku mnager list view icon etc
>>>>>>> b1a2fd809430f19d2a7d23d9641d1ce344a5220f
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
<<<<<<< HEAD
=======
<<<<<<< HEAD

    //public List<ProductsModel> obtenerproductos;
    //List<ProductsModel> products = new ArrayList<>();
    //products.add(new ProductsModel(""))
=======
>>>>>>> Cambios de aplicacion de sku mnager list view icon etc
>>>>>>> b1a2fd809430f19d2a7d23d9641d1ce344a5220f
}
