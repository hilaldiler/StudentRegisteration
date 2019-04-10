package com.example.studentregisteration;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsProfileAdapter extends BaseAdapter {

    ArrayList<String> listLesson = new ArrayList<>();

    private LayoutInflater fInflater;

    public FriendsProfileAdapter(Activity activity, ArrayList<String> friendsArrayList) {
        this.fInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listLesson = friendsArrayList;
    }

    @Override
    public int getCount() {
        return listLesson.size();
    }

    @Override
    public Object getItem(int position) {
        return listLesson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return null;
    }
}
