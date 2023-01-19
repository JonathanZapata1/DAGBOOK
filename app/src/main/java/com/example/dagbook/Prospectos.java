package com.example.dagbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Prospectos extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btnAgregar;
    private ListView mListView;
    private EditText mNombre, mTelefono, mDireccion;
    private List<String> mLista= new ArrayList<>();
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_prospectos);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        mListView = findViewById(R.id.listView);
        // mListView.setOnClickListener(this);
        mNombre = findViewById(R.id.txtNombre);
        mTelefono = findViewById(R.id.txtTelefono);
        mDireccion = findViewById(R.id.txtDireccion);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAgregar:
                String texto = (mNombre.getText().toString().trim() + "\n"+mTelefono.getText().toString().trim() +"\n"+ mDireccion.getText().toString().trim());
                mLista.add(texto);
                mNombre.getText().clear();
                mTelefono.getText().clear();
                mDireccion.getText().clear();
                mAdapter= new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, mLista);
                mListView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Item Clicked: "+i, Toast.LENGTH_SHORT).show();

    }
}