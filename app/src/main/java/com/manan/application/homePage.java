package com.manan.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homePage extends AppCompatActivity {
    TextView textView;
    Button btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btm = findViewById(R.id.logout);
        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        String name =sharedPreferences.getString("Username","");
        textView = findViewById(R.id.textView);
        textView.setText(name);
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences1 = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor lo = sharedPreferences1.edit();
//                lo.remove("Username");
                lo.remove("Password");
                lo.apply();
                finish();
                Intent intent = new Intent(homePage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}