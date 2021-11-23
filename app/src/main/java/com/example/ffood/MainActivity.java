package com.example.ffood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayAdapter<String> adapter;
    String TAG = "FIREBASE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, R.layout.activity_trang_chu);
        lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  parent, View view, int position, long id) {
                String data= adapter.getItem(position);
                String key = data.split("\n")[0];

            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Thongtincanhan");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    String key = data.getKey();
                    String value = data.getValue().toString();
                    adapter.add(key + "\n" + value);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuAdd) {
            Intent intent = new Intent(this, ThemThongtincanhan.class);
            String data =adapter.getItem(adapter.getCount()-1);
            String maxID =data.split("\n")[0];
            int addID=Integer.parseInt(maxID)+1;
            intent.putExtra("size",addID);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.mnuIntro){
            Toast.makeText(this,"Welcome to Mobile Progamming",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.mnuSignIn){
            Intent intent = new Intent(MainActivity.this,DangKy.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);

    }

}