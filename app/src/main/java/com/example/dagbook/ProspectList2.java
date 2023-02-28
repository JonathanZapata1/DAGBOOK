package com.example.dagbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dagbook.controlador.FireBaseDataBaseHelper;
import com.example.dagbook.modelo.Persona2;

import java.util.List;

public class ProspectList2 extends AppCompatActivity {
    private RecyclerView reclyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospect_list2);
        reclyclerView=findViewById(R.id.userlist);
        new FireBaseDataBaseHelper().readProspects(new FireBaseDataBaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Persona2> persona, List<String> keys) {
                findViewById(R.id.progressBar3).setVisibility(View.GONE);
                new RecyclerView_Config2().setConfig( reclyclerView, ProspectList2.this,persona,keys);
            }

            @Override
            public void DataIsInsert() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDelete() {

            }
        });
    }
}