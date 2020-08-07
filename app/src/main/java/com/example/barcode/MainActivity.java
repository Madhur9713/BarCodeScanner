package com.example.barcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static com.example.barcode.R.id.button;
import static com.example.barcode.R.id.textView;



public class MainActivity extends AppCompatActivity {

    public static TextView textView;
    Button button;
    static User user;
    static DatabaseReference myRef;
    static DatabaseReference usersRef;
    static FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        usersRef = myRef.child("users");




        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    public static class User {

        public String productId;
        public Integer ifDetectedSend0;


        public User(String id) {
            this.productId=id;
            this.ifDetectedSend0=1;
            // ...
        }

    }
}
