package edu.temple.switchviews;

/**
 * Created by rohanpandit on 9/22/16.
 */

import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.graphics.Color;

public class CustomAdapter extends ArrayAdapter {

    private String[] colors;

    public CustomAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);

        this.colors = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);

        View v = super.getView(position, convertView, parent);

        for(int i = 0; i < colors.length; i++){
            v.setBackgroundColor(Color.parseColor(colors[position]));
        }

        return v;
    }

}
