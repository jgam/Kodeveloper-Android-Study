package com.example.myfragment;


//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Button button = (Button) v;
        setFragment(button.getText().toString());//set new instance of MyFragment with string.
    }

    private void setFragment(String name) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, MyFragment.newInstance(name));
        ft.commit();
    }
}
