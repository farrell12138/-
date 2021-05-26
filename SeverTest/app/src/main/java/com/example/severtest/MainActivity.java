package com.example.severtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    Message message = new Message();
    public static final int UPDATE_TEXT = 1;
    public static final int BACK_TEXT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button changeButton = findViewById(R.id.start_button);
        text = findViewById(R.id.stop_button);
        changeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.start_button:
               Intent startIntent = new Intent(this, MyService.class);
               startService(startIntent);
               break;
           case R.id.stop_button:
               Intent stopIntent = new Intent(this, MyService.class);
               stopService(stopIntent);
               break;
           default:
               break;
       }
    }
}