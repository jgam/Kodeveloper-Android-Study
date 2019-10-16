package com.example.callingphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.call).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){

            //OnRequestPermissionResult() method called
            //with many permissions, RUNT-- distinguished
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE);
        }
        else{
            startCall();
        }
    }

    private void startCall(){
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:01012345678"));
        startActivity(callIntent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch(requestCode){
            case RUNTIME_PERMISSIONS_REQUEST_CALL_PHONE: {
                //if user accepted permission
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //code implemented here
                    startCall();
                }
                else{
                    //cant use
                }
                return;
            }
        }
    }


}
