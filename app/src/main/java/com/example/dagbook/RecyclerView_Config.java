package com.example.dagbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dagbook.modelo.Persona;
import com.example.dagbook.vista.AdapterProspect;
import com.google.firebase.database.core.view.View;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private ProspectAdapter mProspectAdapter;
    public void setConfig(RecyclerView recyclerView,Context context,List<Persona>personas,List<String> keys){
        mContext= context;
        mProspectAdapter= new ProspectAdapter(personas,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mProspectAdapter);
    }
    class ProspectItemView extends RecyclerView.ViewHolder {
private TextView name,phone,address;
private String key;
public  ProspectItemView(ViewGroup parent){
    super(LayoutInflater.from(mContext).inflate(R.layout.item,parent,false));
    name= (TextView) itemView.findViewById(R.id.tvname);
    phone=(TextView)itemView.findViewById(R.id.tvphone);
    address=(TextView)itemView.findViewById(R.id.tvaddress);
}
public void bind(Persona persona, String key){
    name.setText(persona.getName());
    phone.setText(persona.getPhone());
    address.setText(persona.getAddress());
    this.key=key;
}
    }
    class ProspectAdapter extends RecyclerView.Adapter<ProspectItemView>{
        private List<Persona> mPersonaList;
        private List<String> mKeys;

        public ProspectAdapter(List<Persona> mPersonaList, List<String> mKeys) {
            this.mPersonaList = mPersonaList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ProspectItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return  new ProspectItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ProspectItemView holder, int position) {
            holder.bind(mPersonaList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mPersonaList.size();
        }
    }
}
