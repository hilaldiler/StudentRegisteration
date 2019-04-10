package com.example.studentregisteration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProfilActivity extends AppCompatActivity {

    final int CAMERA_CAPTURE = 100;
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        
        Button btnAdd = findViewById(R.id.addLesson);
        final EditText txtLesson = (EditText)findViewById(R.id.txtLesson);
        final ArrayList<String> list = new ArrayList<String>();

        ListView listView = findViewById(R.id.listViewStudent);
        TextView txtUser = findViewById(R.id.textUser);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");


        list.add("Android 101");
        list.add("Android 201");
        list.add("Android 301");
        list.add("Android 401");
        list.add("Firebase");

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        image = findViewById(R.id.image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_CAPTURE);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = txtLesson.getText().toString();
                if(input != null && input.length() > 0) {
                    list.add(input);
                    arrayAdapter.notifyDataSetChanged();
                    txtLesson.setText("");
                }else {
                    //EditText is blank
                }

            }
        });
    }

        protected void onActivityResult( int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode != RESULT_OK) return;
            switch (requestCode) {
                case CAMERA_CAPTURE:
                    Bundle extras = data.getExtras();
                    image.setImageBitmap((Bitmap) extras.get("data"));
                    break;
            }
        }

        }