package com.example.dagbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ContractActivity extends AppCompatActivity {
    //widgets
    ImageView imagenView;
    Button savebtn,upload;
    ProgressBar progressbar;
//Firebase
    DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Imagen");
    StorageReference storageReference= FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);
        imagenView= findViewById(R.id.imageView2);
        savebtn= findViewById(R.id.btnGuardaFoto);
        upload= findViewById(R.id.btnAgregarFoto);

    }
}