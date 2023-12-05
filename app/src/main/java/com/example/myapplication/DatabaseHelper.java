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

    public boolean updateData(String nim, String nama, String email, String address, String phone){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", nama);
        contentValues.put("email", email);
        contentValues.put("address", address);
        contentValues.put("phone", phone);

        Cursor cursor = db.rawQuery("Select * from mahasiswa where nim = ?",
                new String[]{nim});
        if(cursor.getCount() > 0){
            long result = db.update("student", contentValues,
                    "nim = ?", new String[] {nim});

            if(result <= 0)
                return false;
            else
                return true;
        }
        return false;
    }

    public boolean deleteData(String nim){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from mahasiswa where nim = ?",
                new String[]{nim});
        if(cursor.getCount() > 0){
            long result = db.delete("mahasiswa", "nim = ?",
                    new String[] {nim});

            if(result <= 0)
                return false;
            else
                return true;
        }
        return false;
    }

}
