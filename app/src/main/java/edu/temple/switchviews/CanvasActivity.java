package edu.temple.switchviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.LinearLayout;
import android.graphics.Color;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();

        LinearLayout ln = (LinearLayout)findViewById(R.id.canvas);

        String color = intent.getExtras().getString("chosenColor");

        ln.setBackgroundColor(Color.parseColor(color));


    }
}
