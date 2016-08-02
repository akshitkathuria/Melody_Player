package com.example.boyzz.melody_player.tabs_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.boyzz.melody_player.Getter;
import com.example.boyzz.melody_player.MainActivity;
import com.example.boyzz.melody_player.Player;
import com.example.boyzz.melody_player.R;



/**
 * Created by boyzz on 7/11/16.
 */
public class Songs extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener
{
    ArrayAdapter<String> adpater;
    View view;
    ListView lv;
    String search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_songs, container, false);
        lv = (ListView)view.findViewById(R.id.songslistview);
        lv.setOnItemClickListener(this);

        Getter g = new Getter();
        g.getlist(getActivity());
        adpater = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,android.R.id.text1,Getter.getSongsList());
        lv.setAdapter(adpater);

        MainActivity activity = (MainActivity) getActivity();
        String searchtext = activity.searchit();

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        Intent i = new Intent(getContext(), Player.class);
        Bundle mbundle = new Bundle();
        String id= Integer.toString(position);
        mbundle.putString("ids",id);
        mbundle.putStringArrayList("values",Getter.getPathList());
        i.putExtras(mbundle);
        startActivity(i);
    }
}