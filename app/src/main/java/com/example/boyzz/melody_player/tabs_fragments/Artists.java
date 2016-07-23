package com.example.boyzz.melody_player.tabs_fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boyzz.melody_player.R;

/**
 * Created by boyzz on 7/11/16.
 */
public class Artists extends android.support.v4.app.Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_artists,container,false);
    }
}
