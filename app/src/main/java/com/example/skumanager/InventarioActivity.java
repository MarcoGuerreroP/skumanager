package com.example.skumanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class InventarioActivity extends AppCompatActivity {

    private RecyclerView recyclerViewInventario;
    private InventarioAdapter invenarioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        SQLiteConnectionHelper connection = ((MyApp) getApplication()).getConnection();

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerViewInventario = findViewById(R.id.inventarioRecycler);
        recyclerViewInventario.setLayoutManager(new LinearLayoutManager(this));

        invenarioAdapter = new InventarioAdapter(connection.mostrarentradas());
        recyclerViewInventario.setAdapter(invenarioAdapter);
    }

}
