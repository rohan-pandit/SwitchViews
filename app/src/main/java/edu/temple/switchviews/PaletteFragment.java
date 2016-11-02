package edu.temple.switchviews;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.Activity;

public class PaletteFragment extends Fragment {

    OnFragmentInteractionListener activity;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        activity = (OnFragmentInteractionListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        ListView lView = (ListView) v.findViewById(R.id.listView);

        Resources res = getResources();

        final String[] strings = res.getStringArray(R.array.colors);

        final String[] actualColors = {"red", "green", "blue", "yellow", "grey"};

        CustomAdapter adapt = new CustomAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, strings);

        lView.setAdapter(adapt);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String chosenColor = actualColors[position];
                String chosenColor = Integer.valueOf(position).toString();
                activity.getColor(chosenColor);
            }
        });

        return v;

    }


    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    public interface OnFragmentInteractionListener {
        void getColor(String color);
    }
}
