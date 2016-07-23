package com.example.boyzz.melody_player.tabs_fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.boyzz.melody_player.Getter;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_songs, container, false);
        lv = (ListView)view.findViewById(R.id.listview);
        lv.setOnItemClickListener(this);

        Getter g = new Getter();

        adpater = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,android.R.id.text1,g.getlist(getContext()));
        lv.setAdapter(adpater);

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