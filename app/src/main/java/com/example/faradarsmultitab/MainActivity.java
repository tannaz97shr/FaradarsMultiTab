 package com.example.faradarsmultitab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void btnClicked(View view) {
         Intent intent=new Intent(this , SimpleTabActivity.class);
         intent.putExtra("type",(String)view.getTag());
         startActivity(intent);
     }

 }
