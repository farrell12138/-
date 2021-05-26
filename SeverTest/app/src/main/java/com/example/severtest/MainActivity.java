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
    Thread t;
    Message message = new Message();
    public static final int UPDATE_TEXT = 1;
    public static final int BACK_TEXT = 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case UPDATE_TEXT:
                    text.setText("第二句话");
                    break;
                case BACK_TEXT:
                    text.setText("第一句话");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        text = findViewById(R.id.exText);
        findViewById(R.id.exButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.exButton:
               t = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       message.what = message.what == UPDATE_TEXT ? BACK_TEXT : UPDATE_TEXT;
                       handler.sendMessage(message);
                   }
               });
               t.start();
               break;
           default:
               break;
       }
    }
}