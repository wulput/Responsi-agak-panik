package com.example.responsiku_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.responsiku_uas.room.Pengguna;

public class RecoveryActivity extends AppCompatActivity {

    private Button btnSendEmail;
    private EditText etEmail;

   @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        btnSendEmail = findViewById(R.id.btnSendEmail);
        etEmail = findViewById(R.id.etEmail);

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etEmail.getText().toString().isEmpty()) {
                    startActivity(new Intent(RecoveryActivity.this, LoginActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan data dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}