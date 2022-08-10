package com.jennyputrin.si51.petshops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private Toolbar toolbar;
    private List<PetShops> mData= new ArrayList<>();
    private RecyclerView rvPetShop;
    private PetShopsAdapter petShopsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolBar);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);
        rvPetShop=findViewById(R.id.rv_petshops);
        rvPetShop.setLayoutManager(new LinearLayoutManager(Home.this));

        petShopsAdapter=new PetShopsAdapter(mData, new PetShopsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(PetShops item, int position) {
                Intent intent = new Intent(Home.this, DetailActivity.class);
                intent.putExtra("NAMA", item.getNamaPetShop());
                intent.putExtra("ALAMAT", item.getAlamatPetShop());
                intent.putExtra("PIC", item.getPicPetShop());
                intent.putExtra("DESK", item.getDeskripsiPetShop());
                intent.putExtra("NOHP", item.getNohpPetShop());
                intent.putExtra("MAP", item.getMapPetShop());
                startActivity(intent);
            }
        });
        rvPetShop.setAdapter(petShopsAdapter);
        dummyData();
    }


    public void dummyData(){
        String[] nama=getResources().getStringArray(R.array.nama);
        String[] alamat=getResources().getStringArray(R.array.alamat);

        TypedArray img=getResources().obtainTypedArray(R.array.img);
        String[] desk=getResources().getStringArray(R.array.desk);
        String[] map=getResources().getStringArray(R.array.maps);
        String[] tlp=getResources().getStringArray(R.array.tlp);

        PetShops petShops=new PetShops();

        for (int i=0;i<nama.length;i++){
            petShops=new PetShops();
            petShops.setId(i);
            petShops.setPicPetShop(img.getResourceId(i,0));
            petShops.setNamaPetShop(nama[i]);
            petShops.setAlamatPetShop(alamat[i]);
            petShops.setDeskripsiPetShop(desk[i]);
            petShops.setMapPetShop(map[i]);
            petShops.setNohpPetShop(tlp[i]);

            mData.add(petShops);

        }

    }
}