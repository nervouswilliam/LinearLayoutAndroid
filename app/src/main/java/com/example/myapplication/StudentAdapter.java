package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.model.Student;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    private Context context;
    private int resource;

    public StudentAdapter(@NonNull Context context,  int resource, @NonNull ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        String nim = getItem(position).getNim();
        String name = getItem(position).getName();
        String phone = getItem(position).getPhone();
        String email = getItem(position).getEmail();
        String address = getItem(position).getAddress();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView nimTxt = convertView.findViewById(R.id.nimData);
        TextView nameTxt = convertView.findViewById(R.id.nameData);
        TextView phoneTxt = convertView.findViewById(R.id.phoneData);
        TextView emailTxt = convertView.findViewById(R.id.emailData);
        TextView addressTxt = convertView.findViewById(R.id.addressData);

        nimTxt.setText(nim);
        nameTxt.setText(name);
        phoneTxt.setText(phone);
        emailTxt.setText(email);
        addressTxt.setText(address);

        return convertView;
    }
}
