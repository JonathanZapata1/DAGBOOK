package com.example.dagbook.controlador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dagbook.RecyclerView_Config;
import com.example.dagbook.R;
import com.example.dagbook.modelo.Persona;
import com.example.dagbook.modelo.Persona2;

import java.util.List;

public class ProspectList extends AppCompatActivity {
    private RecyclerView reclyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospectlist);

       reclyclerView=findViewById(R.id.userlist);
       new FireBaseDataBaseHelper().readProspects(new FireBaseDataBaseHelper.DataStatus() {
           @Override
           public void DataIsLoaded(List<Persona2> persona, List<String> keys) {
               findViewById(R.id.progressBar3).setVisibility(View.GONE);
               new RecyclerView_Config().setConfig( reclyclerView,ProspectList.this,persona,keys);
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