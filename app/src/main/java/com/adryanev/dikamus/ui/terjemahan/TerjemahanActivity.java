package com.adryanev.dikamus.ui.terjemahan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

public class TerjemahanActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView kata, keterangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terjemahan);
        toolbar = findViewById(R.id.toolbar_terjemahan);
        kata = findViewById(R.id.terjemahan_kata);
        keterangan = findViewById(R.id.terjemahan_keterangan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent i = getIntent();
        String type = i.getStringExtra("type");
        if(type.equals("en-in")){
            EnglishIndonesia data = i.getParcelableExtra("data");
            getSupportActionBar().setTitle("Description");
            getSupportActionBar().setSubtitle(data.getKata());
            kata.setText(data.getKata());
            keterangan.setText(data.getKeterangan());

        }else if(type.equals("in-en")){
            IndonesiaEnglish data = i.getParcelableExtra("data");
            getSupportActionBar().setTitle("Keterangan");
            getSupportActionBar().setSubtitle(data.getKata());
            kata.setText(data.getKata());
            keterangan.setText(data.getKeterangan());
        }

    }
}
