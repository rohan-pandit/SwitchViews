package edu.temple.switchviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.view.View;
import android.content.Intent;
import android.widget.LinearLayout;
import android.graphics.Color;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        final String[] strings = {"red", "green", "blue", "yellow", "grey"};

        CustomAdapter adapt = new CustomAdapter(PaletteActivity.this, android.R.layout.simple_spinner_dropdown_item, strings);
        spinner.setAdapter(adapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                String chosenColor = strings[position];
                intent.putExtra("chosenColor", chosenColor);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
