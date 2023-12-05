package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Student;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {
    ListView lv;
    Button btn;

    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        db = new DatabaseHelper(this);
        lv = findViewById(R.id.lvData);
        Cursor cursor = db.getMahasiswa();
        StringBuffer buffer = new StringBuffer();
        ArrayList<Student> arr = new ArrayList<>();
        Student student;



        while(cursor.moveToNext()){
            String nim = cursor.getString(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String email = cursor.getString(3);
            String address = cursor.getString(4);
            student = new Student(nim, name, phone, email, address);
            arr.add(student);
        }

        StudentAdapter adapter = new StudentAdapter(this, R.layout.adapter_student, arr);
        lv.setAdapter(adapter);
        btn = findViewById(R.id.backBtn); //revise
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student currStudent = arr.get(i);
                Intent intent = new Intent(StudentActivity.this, DetailActivity.class);

                intent.putExtra("nim", currStudent.getNim());
                intent.putExtra("name", currStudent.getNim());
                intent.putExtra("phone", currStudent.getPhone());
                intent.putExtra("email", currStudent.getEmail());
                intent.putExtra("address", currStudent.getAddress());
                startActivity(intent);
            }
        });

    }
}
