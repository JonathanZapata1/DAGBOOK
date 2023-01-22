package com.example.dagbook.activity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dagbook.R;
import com.example.dagbook.activity.Contratos;
import com.example.dagbook.activity.Prospectos;

public class Home extends AppCompatActivity implements View.OnClickListener {
    ImageButton contratos;
    ImageButton prospectos;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contratos = findViewById(R.id.btncontratos);
        prospectos = findViewById(R.id.btnprospectos);

        contratos.setOnClickListener(this);
        prospectos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == contratos){
            Intent intent = new Intent(Home.this, Contratos.class);
            startActivity(intent);
        }
        if(v == prospectos){
            Intent intent = new Intent(Home.this, Prospectos.class);
            startActivity(intent);
        }
    }
}
