package com.example.ffood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayAdapter<String> adapter;
    String TAG = "FIREBASE";
    private RecyclerView rcvFood;
    private AdapterFood mAdapterFood;
    private List<foods> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<>(this, R.layout.activity_trang_chu);
        lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);

        rcvFood = findViewById(R.id.rcv_food);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvFood.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvFood.addItemDecoration(dividerItemDecoration);

        list = new ArrayList<>();
        mAdapterFood = new AdapterFood(list);

        rcvFood.setAdapter(mAdapterFood);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  parent, View view, int position, long id) {
                String data= adapter.getItem(position);
                String key = data.split("\n")[0];

            }
        });

        getListFoodFromRealtimeDatabase();

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
    private void getListFoodFromRealtimeDatabase(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("foods");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    foods foods = dataSnapshot.getValue(foods.class);
                    list.add(foods);
                }
                mAdapterFood.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Get list food faild",Toast.LENGTH_SHORT).show();

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