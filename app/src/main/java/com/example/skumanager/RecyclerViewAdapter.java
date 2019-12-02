package com.example.skumanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView ID, Producto, PrecioU;

        public ViewHolder(View itemView){
            super(itemView);
            ID = (TextView) itemView.findViewById(R.id.txtIDE);
            Producto = (TextView) itemView.findViewById(R.id.txtDSC);
            PrecioU = (TextView) itemView.findViewById(R.id.txtUM);
        }
    }
    public List<ProductsModel> productLista;

    public RecyclerViewAdapter(List<ProductsModel> productLista) {
        this.productLista = productLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ID.setText(productLista.get(position).getID());
        holder.Producto.setText(productLista.get(position).getProducto());
        holder.PrecioU.setText(productLista.get(position).getPreciou());
    }

    @Override
    public int getItemCount() {
        return productLista.size();
    }
}
