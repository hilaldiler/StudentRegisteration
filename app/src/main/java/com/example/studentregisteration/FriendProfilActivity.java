package com.example.studentregisteration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FriendProfilActivity extends AppCompatActivity {

    ImageView imgFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profil);

        imgFriend = (ImageView)findViewById(R.id.imgFriend);


    }
}
