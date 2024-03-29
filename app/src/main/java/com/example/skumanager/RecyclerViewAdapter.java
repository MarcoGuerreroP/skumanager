package com.example.skumanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ProductViewHolder> {

    public List<ProductsModel> productLista;

    public RecyclerViewAdapter(List<ProductsModel> productLista) {
        this.productLista = productLista;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView ID, Producto, PrecioU;

        public ProductViewHolder(View itemView){
            super(itemView);
            ID = itemView.findViewById(R.id.txtID);
            Producto = itemView.findViewById(R.id.txtDSC);
            PrecioU = itemView.findViewById(R.id.txtPU);
        }
    }

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, parent,false);
        ProductViewHolder viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.ID.setText(productLista.get(position).getID());
        holder.Producto.setText(productLista.get(position).getProducto());
        holder.PrecioU.setText(productLista.get(position).getPreciou());
    }

    @Override
    public int getItemCount() {
        return productLista.size();
    }
}
