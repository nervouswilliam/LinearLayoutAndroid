package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
    Button btnSave;

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

        DatabaseHelper db = new DatabaseHelper(this);

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
                    getData();
//                    Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data gagal disimpan", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    private void getData(){
        Cursor cursor = db.getMahasiswa();
        if(cursor.getCount() <= 0){
            Toast.makeText(MainActivity.this, "Tabel Kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            buffer.append("Nim: " + cursor.getString(0) + "\n");
            buffer.append("Name: " + cursor.getString(1)+ "\n");
            buffer.append("Phone: " + cursor.getString(2)+ "\n");
            buffer.append("Email: " + cursor.getString(3)+ "\n");
            buffer.append("Address: " + cursor.getString(4) + "\n");
        }
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setCancelable(true);
        alert.setTitle("Data Mahasiswa");
        alert.setMessage(buffer);
        alert.show();

    }
}