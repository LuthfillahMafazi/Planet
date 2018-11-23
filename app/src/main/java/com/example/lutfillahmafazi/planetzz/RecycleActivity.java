package com.example.lutfillahmafazi.planetzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lutfillahmafazi.planetzz.Adapter.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] namaPlanetDalam, namaPlanetLuar, detailPlanetDalam, detailPlanetLuar;
    int[] gambarPlanetDalam,gambarPlanetLuar;

    Adapter adapterPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaPlanetDalam = getResources().getStringArray(R.array.nama_planet_dalam);
        namaPlanetLuar = getResources().getStringArray(R.array.nama_planet_luar);
        detailPlanetDalam = getResources().getStringArray(R.array.isi_planet_dalam);
        detailPlanetLuar = getResources().getStringArray(R.array.isi_planet_luar);
        gambarPlanetDalam = new int[]{R.drawable.merkurius,R.drawable.venus,R.drawable.bumi,R.drawable.mars};
        gambarPlanetLuar = new int[] {R.drawable.jupiter,R.drawable.saturnus,R.drawable.neptunus,R.drawable.uranus};

        String tanda = getIntent().getStringExtra("tanda");

        if (tanda.equals("dalam")){
            adapterPlanet = new Adapter(this, namaPlanetDalam, detailPlanetDalam,gambarPlanetDalam);
        }else{
            adapterPlanet = new Adapter(this, namaPlanetLuar,detailPlanetLuar,gambarPlanetLuar);
        }

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterPlanet);
    }
}
