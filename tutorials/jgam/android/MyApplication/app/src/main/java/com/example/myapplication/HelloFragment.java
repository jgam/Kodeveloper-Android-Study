package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class HelloFragment extends Fragment {
    public static HelloFragment newInstance(String name) {
        HelloFragment f = new HelloFragment();

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        f.setArguments(bundle);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_hello, container, false);

        return layout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        setView(view);
    }

    private void setView(View view){
        String name = getArguments().getString("name");

        TextView titleText = view.findViewById(R.id.title);
        titleText.setText("hello boiz");
    }



}
