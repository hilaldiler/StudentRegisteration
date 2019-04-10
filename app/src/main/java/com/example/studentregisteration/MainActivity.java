package com.example.studentregisteration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        final TextView txtUser = (TextView)findViewById(R.id.textViewUser);
        txtUser.setText(username);

        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnFriends = findViewById(R.id.btnFriends);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                intent.putExtra("username", txtUser.getText().toString());
                startActivity(intent);
            }
        });

        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friendsIntent = new Intent(MainActivity.this, FriendsActivity.class);
                startActivity(friendsIntent);
            }
        });
    }

}
