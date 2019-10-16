package com.example.mylayoutt2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button previous = findViewById(R.id.previous);
        Button next = findViewById(R.id.next);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //previous
                ImageView image = findViewById(R.id.imageView);


                image.setImageResource(R.drawable.img1001);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //next
                ImageView image = findViewById(R.id.imageView);

                String a="";
                //adding +1 -1 should be here and end conditions
                image.setImageResource(R.drawable.img1002);
            }
        });
    }
}
