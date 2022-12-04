package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Dashboard extends Fragment {

    private ImageButton CR;
    private Button btnlogout;

    public Dashboard()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);

        ImageButton CR = view.findViewById(R.id.CR);
        CR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction FR = getFragmentManager().beginTransaction();
                FR.replace(R.id.fraglayout, new ChiliRellenos());
                FR.commit();
            }
        });

        Button btnlogout = view.findViewById(R.id.logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}