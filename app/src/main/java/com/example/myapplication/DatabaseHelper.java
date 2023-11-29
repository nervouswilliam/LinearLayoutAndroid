package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "mahasiswa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE student("+
                "nim text PRIMARY KEY," +
                "name text," +
                "phone text," +
                "email text," +
                "address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean isInsertMhs(String nim, String name, String phone, String email, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("nim", nim);
        content.put("name", name);
        content.put("phone", phone);
        content.put("email", email);
        content.put("address", address);

        long result = db.insert("student", null, content);
        if(result == -1){
            return false;
        }
        return true;
    }
    public Cursor getMahasiswa(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student", null);
        return cursor;
    }

}
