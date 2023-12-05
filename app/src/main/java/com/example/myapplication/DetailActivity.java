package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Student;

public class DetailActivity extends AppCompatActivity {
    TextView updateNIM;
    EditText updateName;
    EditText updatePhone;
    EditText updateEmail;
    EditText updateAddress;

    Button updateBTN, deleteBTN;

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        updateNIM = findViewById(R.id.updateNIM);
        updateName = findViewById(R.id.updateName);
        updatePhone = findViewById(R.id.updatePhone);
        updateEmail = findViewById(R.id.updateEmail);
        updateAddress = findViewById(R.id.updateAddress);

        updateBTN = findViewById(R.id.updateBTN);
        deleteBTN = findViewById(R.id.deleteBTN);

        db = new DatabaseHelper(this);

        Intent intent = getIntent();

        String nim = intent.getStringExtra("nim");
        String name = intent.getStringExtra("nama");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String email = intent.getStringExtra("email");

        updateNIM.setText(nim);
        updateName.setText(name);
        updatePhone.setText(phone);
        updateEmail.setText(email);
        updateAddress.setText(address);

        updateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newNIM = updateNIM.getText().toString();
                String newName = updateName.getText().toString();
                String newPhone = updatePhone.getText().toString();
                String newAddress = updateAddress.getText().toString();
                String newEmail = updateEmail.getText().toString();

                boolean isUpdate = db.updateData(newNIM, newName, newPhone, newAddress, newEmail);

                if(isUpdate){
                    Intent intent = new Intent(DetailActivity.this, StudentActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(DetailActivity.this, "Updating data process has failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        deleteBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDelete = db.deleteData(nim);

                if(isDelete){
                    Intent intent = new Intent(DetailActivity.this, StudentActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(DetailActivity.this, "Deleting data process has failed", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
