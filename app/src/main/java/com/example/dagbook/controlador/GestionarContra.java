package com.example.dagbook.controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dagbook.R;
import com.example.dagbook.modelo.Contrato;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GestionarContra extends AppCompatActivity {
    private ListView listContraView;
    private List<Contrato> listContra=new ArrayList<Contrato>();
    private ArrayAdapter<Contrato> arrayAdapterContrato;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_contra);
        listContraView=findViewById(R.id.listContra);
        inicializarFirebase();
        listarDatos();
    }

    private void listarDatos(){
        databaseReference.child("Contratos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listContra.clear();
                for(DataSnapshot objSnaptshot : snapshot.getChildren()){
                    Contrato c=objSnaptshot.getValue(Contrato.class);
                    listContra.add(c);
                    arrayAdapterContrato=new ArrayAdapter<Contrato>(GestionarContra.this, android.R.layout.simple_list_item_1,listContra);
                    listContraView.setAdapter(arrayAdapterContrato);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }

    private void adapterContraList(Contrato c){
    }
}
