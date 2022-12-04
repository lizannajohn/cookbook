package com.example.cookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ChiliRellenos extends Fragment {
    private Button btnshare;
    private Button btnsave;
    private Button btnprint;
    private Button btndwnld;

    public ChiliRellenos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chili_rellenos,container,false);

        Button btnshare = view.findViewById(R.id.btnshare);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Shared!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnsave = view.findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Saved to Saved Recipes!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnprint = view.findViewById(R.id.btnprint);
        btnprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Printed!", Toast.LENGTH_LONG).show();
            }
        });

        Button btndwnld = view.findViewById(R.id.btndwnld);
        btndwnld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Recipe Downloaded!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }
}