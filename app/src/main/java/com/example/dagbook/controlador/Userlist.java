package com.example.dagbook.controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.dagbook.FireBaseDataBaseHelper;
import com.example.dagbook.RecyclerView_Config;
import com.example.dagbook.vista.AdapterProspect;
import com.example.dagbook.R;
import com.example.dagbook.modelo.Persona;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Userlist extends AppCompatActivity {
RecyclerView reclyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

       reclyclerView=findViewById(R.id.userlist);
       new FireBaseDataBaseHelper().readProspects(new FireBaseDataBaseHelper.DataStatus() {
           @Override
           public void DataIsLoaded(List<Persona> persona, List<String> keys) {
               findViewById(R.id.progressBar3).setVisibility(View.GONE);
               new RecyclerView_Config().setConfig( reclyclerView,Userlist.this,persona,keys);
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