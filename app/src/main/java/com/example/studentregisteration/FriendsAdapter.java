package com.example.studentregisteration;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    List<Friends> list;
    Activity activity;

    public FriendsAdapter(Activity activity, List<Friends> mlist) {
        layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        list = mlist;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        view = layoutInflater.inflate(R.layout.row, null);
        ImageView image = (ImageView)view.findViewById(R.id.imageFriend);
        TextView tvName = (TextView)view.findViewById(R.id.name);
        TextView tvUsername = (TextView)view.findViewById(R.id.username);
        Friends friends = list.get(position);

        tvName.setText(friends.getName());
        tvUsername.setText(friends.getUsername());

        String name = friends.getName().toString();
        if(name.equals("Diren Aydın"))
            image.setImageResource(R.drawable.diren);
        else if(name.equals("Cevher Şirin"))
            image.setImageResource(R.drawable.cevher);


        return view;
    }
}
