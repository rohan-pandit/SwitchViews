package edu.temple.switchviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.content.res.Resources;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {

    PaletteFragment palFrag;
    CanvasFragment canFrag;
    int twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        palFrag = new PaletteFragment();
        canFrag = new CanvasFragment();

        twoPane = getResources()
                        .getConfiguration()
                        .orientation;

        if(twoPane == 1) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.palFrag, palFrag)
                    .commit();

            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.canFrag, canFrag)
                    .addToBackStack(null)
                    .commit();
        } else if(twoPane == 2){
                setContentView(R.layout.activity_palette_landscape);
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.palFragLand, palFrag)
                        .commit();

                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.canFragLand, canFrag)
                        .commit();

            }

        /*ListView lView = (ListView) findViewById(R.id.listView);

        Resources res = getResources();

        final String[] strings = res.getStringArray(R.array.colors);

        final String[] actualColors = {"red", "green", "blue", "yellow", "grey"};

        CustomAdapter adapt = new CustomAdapter(PaletteActivity.this, android.R.layout.simple_spinner_dropdown_item, strings);
        lView.setAdapter(adapt);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                String chosenColor = actualColors[position];
                intent.putExtra("chosenColor", chosenColor);
                startActivity(intent);hm
            }
        });*/


    }

    @Override
    public void getColor(String color){
        twoPane = getResources()
                        .getConfiguration()
                        .orientation;

        if(twoPane == 1){
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.canFrag, canFrag)
                    .addToBackStack(null)
                    .commit();
        }

        canFrag.changeBackground(color);
    }
}
