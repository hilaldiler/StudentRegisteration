package com.example.studentregisteration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    ListView listView;
    List<Friends> listFriends = new ArrayList<Friends>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);



        Button btnAdd = findViewById(R.id.btnAddFriend);
        final EditText txtFriends = (EditText)findViewById(R.id.edtFriendName);
        final EditText txtFriendUsername = findViewById(R.id.edtFriendUserName);

        listFriends.add(new Friends("Diren Aydın", "@direnaydin"));
        listFriends.add(new Friends("Cevher Şirin", "@cevhersirin"));

        listView = (ListView)findViewById(R.id.listViewFriends);
        final FriendsAdapter adapter = new FriendsAdapter(this, listFriends);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = txtFriends.getText().toString();
                String inputUsername = txtFriendUsername.getText().toString();
                if(inputName != null && inputName.length() > 0 && inputUsername != null && inputUsername.length() > 0) {
                    listFriends.add(new Friends("" + inputName, "@" + inputUsername));
                    adapter.notifyDataSetChanged();
                    txtFriends.setText("");
                    txtFriendUsername.setText("");
                }else {
                    //EditText is blank
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intentFriendProfil = new Intent(FriendsActivity.this, FriendProfilActivity.class);

                startActivity(intentFriendProfil);

            }
        });

        listView.setAdapter(adapter);

    }
}
