package com.example.dagbook.activity.ui.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dagbook.R;
import com.example.dagbook.activity.ProspectActivity;
import com.example.dagbook.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    View view;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_gallery, container, false);
        //Button calendar = (Button) view.findViewById(R.id.btnAgregar);
        /*calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProspectActivity.class);
                startActivity(intent);
            }
        });*/
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}