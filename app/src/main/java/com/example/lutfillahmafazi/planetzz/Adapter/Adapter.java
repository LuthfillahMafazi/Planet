package com.example.lutfillahmafazi.planetzz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lutfillahmafazi.planetzz.DetailPlanetActivity;
import com.example.lutfillahmafazi.planetzz.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    String[] namaPlanet, detailPlanet;
    int [] gambarPlanet;

    public Adapter(Context context, String[] namaPlanet, String[] detailPlanet, int[] gambarPlanet) {
        this.context = context;
        this.namaPlanet = namaPlanet;
        this.detailPlanet = detailPlanet;
        this.gambarPlanet = gambarPlanet;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_planet,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtPlanet.setText(namaPlanet[i]);
        Glide.with(context).load(gambarPlanet[i]).into(viewHolder.imgPlanet);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailPlanetActivity.class);
                pindah.putExtra("np", namaPlanet[i]);
                pindah.putExtra("dp", detailPlanet[i]);
                pindah.putExtra("gp", gambarPlanet[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarPlanet.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPlanet;
        TextView txtPlanet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPlanet = itemView.findViewById(R.id.imgTittlePlanet);
            txtPlanet = itemView.findViewById(R.id.txtTittlePlanet);
        }
    }
}
