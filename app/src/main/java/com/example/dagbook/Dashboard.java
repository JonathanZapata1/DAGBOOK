package com.example.dagbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity  implements View.OnClickListener {
    ImageView contratos;
    ImageButton prospecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        prospecto = findViewById(R.id.prospectos);
        prospecto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == prospecto){
            Intent intent = new Intent(Dashboard.this, Prospectos.class);
            startActivity(intent);
        }

    }
}