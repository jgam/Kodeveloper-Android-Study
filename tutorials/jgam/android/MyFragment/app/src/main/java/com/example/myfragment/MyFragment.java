package com.example.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.app.Fragment;

public class MyFragment extends Fragment {
    public static MyFragment newInstance(String name){//created instance to return fragment object
        MyFragment f = new MyFragment();

        Bundle bundle = new Bundle();
        bundle.putString("name", name);//bundle objectS data key
        f.setArguments(bundle);//save bundle to fragment. Now you can take this out with getArguments() method.

        return f;
    }

    //called method to create fragment's layout -> using inflater we convert XML to object
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //converts xml to java object
        //container is parent view
        //false means whether to add container or not
        View layout = inflater.inflate(R.layout.fragment_name, container, false);

        return layout;
    }

    //OnCreateView() created view and fragment's data saved bundle is parameters
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //setView is method that finds widget with view or set the data

        setView(view);
    }

    private void setView(View view){
        String name = getArguments().getString("name");

        TextView nameText = view.findViewById(R.id.name);
        nameText.setText(name);
    }
}
