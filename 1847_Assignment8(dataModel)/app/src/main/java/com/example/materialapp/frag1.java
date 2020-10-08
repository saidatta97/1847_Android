package com.example.materialapp;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.textfield.TextInputEditText;

public class frag1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragments1,container,false);

        TextInputEditText nameinput;
        nameinput= (TextInputEditText) view.findViewById(R.id.name);


        getActivity().setTitle("Login");
        return view;
    }

}
