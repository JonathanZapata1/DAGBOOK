package com.example.dagbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import javax.activation.MimeType;

public class ContractActivity extends AppCompatActivity {
    //widgets
    ImageView imagenView;
    Button savebtn,upload;
    ProgressBar progressbar;
    Uri uri;
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
        progressbar=findViewById(R.id.progressbar);
        //Progress Bar
        progressbar.setVisibility(View.INVISIBLE);
        imagenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,2);

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uri!=null){
                    UploadImagenFirebase(uri);
                }
                else{
                    Toast.makeText(ContractActivity.this,"Por favor selecciona una Foto",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void UploadImagenFirebase(Uri uri) {
        StorageReference file= storageReference.child(System.currentTimeMillis()+"."+getFileExtension(uri));
        file.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                file.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                    imageModel model= new imageModel(uri.toString());
                    String Smodel= reference.push().getKey();
                    reference.child(Smodel).setValue(model);
                    progressbar.setVisibility(View.INVISIBLE);
                    Toast.makeText(ContractActivity.this,"Foto Subida Exitosamente",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                progressbar.setVisibility(View.VISIBLE);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ContractActivity.this,"Error",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getFileExtension(Uri uri) {
        ContentResolver contentResolver= getContentResolver();
        MimeTypeMap map= MimeTypeMap.getSingleton();
        return map.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode==RESULT_OK && data!= null)
        {
            uri= data.getData();
            imagenView.setImageURI(uri);
        }
    }
}