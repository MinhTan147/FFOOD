package com.example.ffood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
public class DangKy extends AppCompatActivity {

    EditText email,password;
    Button Signup,Signin,resetpassword,cancel;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        matching();
        auth = FirebaseAuth.getInstance();

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, DangNhap.class);
                startActivity(intent);
                finish();

                Intent intents = new Intent(DangKy.this, ThemThongtincanhan.class);
                startActivity(intent);
                finish();
            }
        });
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentt = new Intent(DangKy.this, QuenMatKhau.class);
                startActivity(intentt);
                finish();

                Intent intent = new Intent(DangKy.this, ThemThongtincanhan.class);
                startActivity(intent);
                finish();
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String semail = email.getText().toString().trim();
                String spassword = password.getText().toString().trim();
                if (TextUtils.isEmpty(semail)){
                    Toast.makeText(getApplicationContext(),"Hãy nhập email ",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(spassword)){
                    Toast.makeText(getApplicationContext(),"Hãy nhập password ",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (spassword.length() < 6){
                    Toast.makeText(getApplicationContext(),"password quá ngắn , mời nhập lại ",Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(semail,spassword).addOnCompleteListener(DangKy.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Toast.makeText(SignUpActivity.this,"tạo người dùng thành công"+task.isSuccessful(),Toast.LENGTH_SHORT).show();
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Tạo người dùng thất bại.",Toast.LENGTH_LONG).show();
                            Log.d("Lỗi Đăng Ký",task.getException().getMessage().toString());
                        } else {
                            Toast.makeText(getApplicationContext(),"Tạo người dùng thành công",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(DangKy.this,MainActivity.class));
                            finish();
                        }
                    }
                });
            }
        });

    }

    private void matching() {

        email = findViewById(R.id.Signup_email);
        password = findViewById(R.id.Signup_Password);
        Signup = findViewById(R.id.signup_btn_signup);
        Signin = findViewById(R.id.signup_btn_signin);
        resetpassword = findViewById(R.id.signup_btn_resetpass);
        cancel = findViewById(R.id.signup_btn_cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}