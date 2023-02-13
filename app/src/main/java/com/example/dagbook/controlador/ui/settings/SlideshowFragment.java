package com.example.dagbook.controlador.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dagbook.R;
import com.example.dagbook.controlador.GestionarContra;
import com.example.dagbook.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    private Button btnGestioContra;
    private View view;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_slideshow,container, false);
        btnGestioContra=(Button) view.findViewById(R.id.btnAdminContra);
        btnGestioContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), GestionarContra.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}