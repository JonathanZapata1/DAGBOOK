package com.example.dagbook.controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dagbook.modelo.Persona;
import com.example.dagbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProspectActivity extends AppCompatActivity /*implements View.OnClickListener, AdapterView.OnItemClickListener*/ {

    private Button btnAgregar,btnLista;
    private Persona prospecto;
    private EditText name,phone,address;
    private String str_name,str_phone,str_address;
    private ProgressDialog progressDialog;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospect);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnLista=findViewById(R.id.btnLista);

        name=findViewById(R.id.txtNombre);
        phone=findViewById(R.id.txtTelefono);
        address=findViewById(R.id.txtDireccion);

        progressDialog=new ProgressDialog( this);
        progressDialog.setTitle("Por favor esperar....");
        progressDialog.setCanceledOnTouchOutside(false);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Intent intent = new Intent(getApplicationContext(), Userlist.class);
                startActivity(intent);
            }
        });

    }

    private void Validation() {
        String msg="Por favor llenar todos los campos campo";
        str_name=name.getText().toString();
        str_address=address.getText().toString() ;
        str_phone=phone.getText().toString();
        if(str_name.isEmpty()) {
            name.setError(msg);
            name.requestFocus();
        }
        if(str_phone.isEmpty()) {
            phone.setError(msg);
            phone.requestFocus();
        }
        if(!numberCheck(str_phone)) {
            phone.setError(msg);
            phone.requestFocus();
            return;
        }
        if(str_address.isEmpty()) {
            address.setError(msg);
            address.requestFocus();
        }
        createAccount();
    }

    private void createAccount() {
        progressDialog.setMessage("Creando Prospecto....");
        progressDialog.show();
        sendDataToDd();
    }

    private void sendDataToDd() {
        prospecto=new Persona(str_name,str_phone,str_address);
        reference= FirebaseDatabase.getInstance().getReference("Prospects");
        reference.child(str_name).setValue(prospecto).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressDialog.dismiss();
                Intent intent= new Intent(getApplicationContext(),ProspectActivity.class);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"NOT Registered",Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean numberCheck(String str_phone) {
        Pattern p= Pattern.compile("[0-9]{10}");
        Matcher m= p.matcher(str_phone);
        return m.matches();
    }

}