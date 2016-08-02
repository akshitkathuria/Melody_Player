package com.example.boyzz.melody_player.tabs_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.boyzz.melody_player.Getter;
import com.example.boyzz.melody_player.R;

/**
 * Created by boyzz on 7/11/16.
 */
public class Artists extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener
{
    ListView lv;
    ArrayAdapter<String> adapter;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_artists,container,false);

        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,android.R.id.text1, Getter.getArtistList());
        lv = (ListView)view.findViewById(R.id.artistslistview);
        lv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Snackbar.make(view, "Coming Soon", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
