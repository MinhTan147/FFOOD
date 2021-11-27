package com.example.ffood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class ThemThongtincanhan extends AppCompatActivity {

    EditText  fullname, email,diachi,  gioitinh, mobile,  cmnd;
    Button add, cancel;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thongtincanhan);
        Bundle extras = getIntent().getExtras();
        if(extras != null ) {
            this.size = extras.getInt("size");
        }

        maching();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulythemmoi();
                Intent intent = new Intent(ThemThongtincanhan.this,TrangChu.class);
                startActivity(intent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

    private void xulythemmoi(){
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Thongtincanhan");

            String sname=fullname.getText().toString();
            String semail=email.getText().toString();
            String saddress=gioitinh.getText().toString();
            String sgender=diachi.getText().toString();
            String smobile=mobile.getText().toString();
            String soffice=cmnd.getText().toString();

            Toast.makeText(this,"Them  thanh cong ", Toast.LENGTH_LONG).show();
            finish();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
