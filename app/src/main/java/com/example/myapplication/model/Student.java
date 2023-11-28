package com.example.myapplication.model;

public class Student {
    private String nim, name, phone, email, address;

    public Student(String nim, String name, String phone, String email, String address) {
        this.nim = nim;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
