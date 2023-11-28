package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNim;
    EditText editName;
    EditText editPhone;
    EditText editEmail;
    EditText editAddress;
    Button btnSave, viewBtn;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNim = findViewById(R.id.editNIM);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editAddress = findViewById(R.id.editAddress);

        btnSave = findViewById(R.id.btnSave);

        db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nim = editNim.getText().toString();
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();
                String email = editEmail.getText().toString();
                String address = editAddress.getText().toString();

                boolean isInsert = db.isInsertMahasiswa(nim, name, phone, email, address);

                if(isInsert){
                   Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                   startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Data gagal disimpan", Toast.LENGTH_LONG).show();

                }
            }
        });

        viewBtn = findViewById(R.id.viewBtn);
        viewBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });

    }
}