package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idEdit;
    EditText pwEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idEdit = findViewById(R.id.id);
        pwEdit = findViewById(R.id.pw);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkLogin();
            }
        });
    }

    private void checkLogin(){
        String id = idEdit.getText().toString();
        String pw = pwEdit.getText().toString();

        if(TextUtils.isEmpty(id) || TextUtils.isEmpty(pw)){
            Toast.makeText(this, "didnt put in password nor id", Toast.LENGTH_SHORT).show();
            return;
        }

        if(id.equals("admin") && pw.equals("admin")){
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "incorrect password and id", Toast.LENGTH_SHORT).show();
        }
    }
}
