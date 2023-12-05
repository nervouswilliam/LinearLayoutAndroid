package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView updateNIM;
    TextView updateName;
    TextView updatePhone;
    TextView updateEmail;
    TextView updateAddress;

    Button updateBTN, deleteBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        updateNIM = findViewById(R.id.updateNIM);
        updateName = findViewById(R.id.updateName);
        updatePhone = findViewById(R.id.updatePhone);
        updateEmail = findViewById(R.id.updateEmail);
        updateAddress = findViewById(R.id.updateAddress);

        Intent intent = getIntent();

        String nim = intent.getStringExtra("nim");
        String nama = intent.getStringExtra("nama");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");

        updateNIM.setText(nim);
        updateName.setText(nama);
        updatePhone.setText(phone);
        updateEmail.setText(email);
        updateAddress.setText(address);

        updateBTN = findViewById(R.id.updateBTN);
        deleteBTN = findViewById(R.id.deleteBTN);
    }
}
