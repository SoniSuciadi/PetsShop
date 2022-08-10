package com.jennyputrin.si51.petshops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView ivPic;
    private TextView tvNama,tvAlamat,tvDesk;
    private Button btnTlp;
    private FloatingActionButton fabMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        toolbar=findViewById(R.id.toolBar);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        ivPic=findViewById(R.id.iv_petshop_detail);
        tvNama=findViewById(R.id.tv_nama_detail);
        tvAlamat=findViewById(R.id.tv_alamat_detail);
        tvDesk=findViewById(R.id.tv_desk);
        btnTlp=findViewById(R.id.btn_tlp);
        fabMap=findViewById(R.id.fab_map);

        tvNama.setText(getIntent().getStringExtra("NAMA"));
        tvAlamat.setText(getIntent().getStringExtra("ALAMAT"));
        btnTlp.setText(getIntent().getStringExtra("NOHP"));
        tvDesk.setText(getIntent().getStringExtra("DESK"));

        btnTlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = getIntent().getStringExtra("NOHP");;
                Uri call = Uri.parse("tel:" + number);
                Intent intent = new Intent(Intent.ACTION_DIAL, call);
                startActivity(intent);
            }
        });
        fabMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getIntent().getStringExtra("MAP"))));
            }
        });

        Glide.with(this).load(getIntent().getIntExtra("PIC",0)).into(ivPic);

    }

}