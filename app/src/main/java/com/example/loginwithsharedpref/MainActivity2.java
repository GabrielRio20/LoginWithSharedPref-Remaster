package com.example.loginwithsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView username;
    Button logout;
    SharedPreferences getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.tv_username);
        logout = findViewById(R.id.btn_logout);

        getData = getSharedPreferences("data_login", MODE_PRIVATE);

        if(getData.contains("email")){
            username.setText("Welcome, " + getData.getString("username", null));
        }
        else{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData.edit().clear().commit();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
}
