package com.example.dagbook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ListProspectActivity extends AppCompatActivity /*implements View.OnClickListener, AdapterView.OnItemClickListener */{
   /* private Button btnAgregar;
    private ListView mListView;
    private EditText mNombre, mTelefono, mDireccion;
    private List<String> mLista= new ArrayList<>();
    private ArrayAdapter<String> mAdapter;
    private Toolbar myToolbar;*/

    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_prospect);

        listview=findViewById(R.id.lista);
        ArrayList<String> lista= new ArrayList<>();
        lista.add("Cliente1");
        lista.add("Cliente2");
        lista.add("Cliente3");
        ArrayAdapter adaptador= new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        listview.setAdapter(adaptador);




       /* mLista.add("Cliente 1\nDireccion 1\nTelefono1");
        mLista.add("Cliente 2\nDireccion 2\nTelefono2");
        mLista.add("Cliente 3\nDireccion 3\nTelefono3");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mLista);
        listview.setAdapter(adapter);

        myToolbar= (Toolbar) findViewById(R.id.toolbar);
        setActionBar(myToolbar);
        // btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
        //mListView = findViewById(R.id.listView);
        // mListView.setOnClickListener(this);
        // mNombre = findViewById(R.id.txtNombre);
        //mTelefono = findViewById(R.id.txtTelefono);
        //mDireccion = findViewById(R.id.txtDireccion);*/

    }

  /*  @Override
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

    }*/
}