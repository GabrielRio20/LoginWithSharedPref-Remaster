package com.example.loginwithsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    String[] login_data = {
            "rio",//email
            "rio",//password
            "Rio Aditya"//username
    };

    String tx_email, tx_password ;

    //buat variabel sharedPref, untuk menyimpan data, ditambahkan editor
    SharedPreferences.Editor setData;

    //utk membaca data
    SharedPreferences getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

        //deklarasikan sharedPref dengan nama data dan mode private bisa membaca dan menulis data
        //karena menyiman data, tambahkan edit
        setData = getSharedPreferences("data_login", MODE_PRIVATE).edit();
        getData = getSharedPreferences("data_login", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx_email = email.getText().toString();
                tx_password = password.getText().toString();

                if(tx_email.equals(login_data[0]) && tx_password.equals(login_data[1])){
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();

                    setData.putString("email", tx_email);
                    setData.putString("username", login_data[2]);

                    //untuk menyimpan data nama
                    setData.apply();
                    startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                    finish();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Login Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

