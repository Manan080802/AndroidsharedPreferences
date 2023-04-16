package com.manan.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    CheckBox Remeber;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= findViewById(R.id.Username);
        ed2 =findViewById(R.id.Password);
        Remeber = findViewById(R.id.Remeber);
        btn = findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().isEmpty())
                {
                    ed1.setError("enter the username");
                }
                else if(ed2.getText().toString().isEmpty())
                {
                    ed2.setError("Enter the password");
                }
                else {
                    if (Remeber.isChecked()) {
                        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                        SharedPreferences.Editor lo = sharedPreferences.edit();
                        lo.putString("Username", ed1.getText().toString());
                        lo.putString("Password", ed2.getText().toString());
                        lo.apply();
                        Intent intent = new Intent(MainActivity.this, homePage.class);
                        startActivity(intent);


                    } else {
//                        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
//                        SharedPreferences.Editor lo = sharedPreferences.edit();
//                        lo.putString("Username", ed1.getText().toString());
//                        lo.putString("Password", ed2.getText().toString());
//                        lo.apply();
                        Intent intent = new Intent(MainActivity.this, homePage.class);
                        startActivity(intent);

                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
       String UserName= sharedPreferences.getString("Username","");
        String Password=sharedPreferences.getString("Password","");
        if(!UserName.isEmpty() && !Password.isEmpty())
        {
            Intent intent = new Intent(MainActivity.this,homePage.class);
            startActivity(intent);

        }
        ed1.setText(UserName);


    }
}