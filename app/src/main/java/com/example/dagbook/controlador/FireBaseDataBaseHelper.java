package com.example.dagbook.controlador;

import androidx.annotation.NonNull;

import com.example.dagbook.modelo.Persona;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDataBaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceProspect;
    private List<Persona> propects= new ArrayList<>();

public interface  DataStatus{
    void DataIsLoaded (List<Persona> persona, List<String> keys);
    void DataIsInsert();
    void DataIsUpdated();
    void DataIsDelete();
}
    public FireBaseDataBaseHelper() {
        mDatabase= FirebaseDatabase.getInstance();
        mReferenceProspect= mDatabase.getReference("Prospects");    }
    public void readProspects(final DataStatus dataStatus ){
        mReferenceProspect.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            propects.clear();
            List<String> keys= new ArrayList<>();
            for (DataSnapshot keyNode: snapshot.getChildren())
            {
                keys.add(keyNode.getKey());
                Persona persona= keyNode.getValue(Persona.class);
                propects.add(persona);
            }
            dataStatus.DataIsLoaded(propects,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void updateProspect(String key,Persona persona,final DataStatus dataStatus){
    mReferenceProspect.child(key).setValue(persona)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    dataStatus.DataIsUpdated();
                }
            });

    }
    public void deleteProspect(String key,final DataStatus dataStatus){
        mReferenceProspect.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dataStatus.DataIsDelete();
                    }
                });
    }

}
