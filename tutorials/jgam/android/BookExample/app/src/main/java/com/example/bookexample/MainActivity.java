package com.example.bookexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button toast = findViewById(R.id.button1);
        Button snack = findViewById(R.id.button2);
        Button snackClicked = findViewById(R.id.button3);
        Button dialogue = findViewById(R.id.button4);
        Button dialogueClicked = findViewById(R.id.button5);

        toast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Toast!", Toast.LENGTH_SHORT).show();
            }
        });

        snack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, "Snack niqqa!!!", Snackbar.LENGTH_SHORT).show();
            }
        });

        snackClicked.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v, "my niqqa!!!", Snackbar.LENGTH_SHORT).setAction("close", new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                    }
                }).setActionTextColor(Color.RED).show();
            }
        });

        dialogue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("this dialogue niqqa!")
                        .setMessage("check or not ur fault")
                        .setNeutralButton("close", null)
                        .setPositiveButton("yeah boi", null)
                        .setNegativeButton("no boii", null)
                        .show();
            }
        });
    }
}
