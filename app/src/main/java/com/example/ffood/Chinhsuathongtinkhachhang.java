package com.example.ffood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Chinhsuathongtinkhachhang extends AppCompatActivity {

    EditText  fullname, email,diachi,  gioitinh, mobile,  cmnd;
    Button add, cancel;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinhsuathongtinkhachhang);
    }

    private void maching() {

            fullname = (EditText) findViewById(R.id.et_Hovatens);
            email = (EditText) findViewById(R.id.et_Emails);
            gioitinh= (EditText) findViewById(R.id.et_Gioitinhs);
            diachi = (EditText) findViewById(R.id.et_Diachis);
            mobile = (EditText) findViewById(R.id.et_Phones);
            cmnd= (EditText) findViewById(R.id.et_CMNDs);
            add =(Button) findViewById(R.id.btn_Thems);
            cancel =(Button) findViewById(R.id.btn_Xoas);
    }
}