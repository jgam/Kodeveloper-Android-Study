package kodevelop.com;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//restrict widget from layouts

        TextView nameText = findViewById(R.id.textView);//get widgets by ID
        nameText.setText("textView content set");

        Log.d("LifeCycleActivity", "onCreate()");
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LifeCycleActivity", "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LifeCycleActivity", "onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LifeCycleActivity", "onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LifeCycleActivity","onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycleActivity", "onDestroy()");
    }
}
