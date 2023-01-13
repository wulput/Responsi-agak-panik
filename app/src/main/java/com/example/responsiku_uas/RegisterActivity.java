package com.example.responsiku_uas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.responsiku_uas.room.AppDatabase;
import com.example.responsiku_uas.room.Pengguna;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    //inisialisasi
    private Button btnRegis;
    private EditText etEmail;
    private EditText etPasswd;
    private EditText etConfPasswd;
    private ImageButton ibBack;

    AppDatabase db;
    Pengguna pengguna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegis = findViewById(R.id.btnRegis);
        etEmail = findViewById(R.id.etEmail);
        etPasswd = findViewById(R.id.etPasswd);
        etConfPasswd = findViewById(R.id.etConfPasswd);


        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //untuk memasukkan datanya
                String email = etEmail.getText().toString().trim();
                String password = etPasswd.getText().toString().trim();
                String confirmpasswd = etConfPasswd.getText().toString().trim();

                if (password.equals(confirmpasswd)) {
                    db = AppDatabase.getDbInstance(getApplicationContext());
                    pengguna = new Pengguna(email, password);
                    db.userDao().insertAll(pengguna);

                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan data dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

