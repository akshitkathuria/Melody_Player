package com.example.boyzz.melody_player.tabs_fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.boyzz.melody_player.Getter;
import com.example.boyzz.melody_player.Player;
import com.example.boyzz.melody_player.R;
import com.example.boyzz.melody_player.SongDetail;
import com.example.boyzz.melody_player.adapter;

/**
 * Created by boyzz on 7/11/16.
 */
public class Albums extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener
{
    adapter adapter;
    View view;
    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_albums,container,false);
        lv = (ListView)view.findViewById(R.id.albumslistview);
        lv.setOnItemClickListener(this);

        adapter = new adapter(getActivity(), Getter.getSongsList());
        lv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        Snackbar.make(view, "Coming Soon", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}