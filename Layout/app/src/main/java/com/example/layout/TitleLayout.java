package com.example.layout;

import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout implements View.OnClickListener {

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleButton = (Button)findViewById(R.id.title_button);
        Button editButton = (Button)findViewById(R.id.title_edit);
        titleButton.setOnClickListener(this);
        editButton.setOnClickListener(this);
    }
    public  void onClick(View v){
        switch (v.getId()){
            case R.id.title_button:
                ((Activity)getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "You are clicked Edit button!!!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}