package edu.temple.switchviews;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.graphics.Color;


public class CanvasFragment extends Fragment {

    LinearLayout ln;
    View v;
    static final String[] colors = {"red", "green", "blue", "yellow", "grey"};

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_canvas, container, false);

        ln = (LinearLayout) v.findViewById(R.id.canvasFrag);

        return v;

    }


    public void changeBackground(String color){
        int position = Integer.parseInt(color);
        ln.setBackgroundColor(Color.parseColor(colors[position]));
    }
}
