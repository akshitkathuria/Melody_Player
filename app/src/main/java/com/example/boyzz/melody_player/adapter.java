package com.example.boyzz.melody_player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by boyzz on 8/8/16.
 */
public class adapter extends BaseAdapter {

    ArrayList<SongDetail> songs;
    Context context;

    public adapter(Context context, ArrayList<SongDetail> songs) {
        this.context = context;
        this.songs = songs;
    }

    public class holder
    {
       TextView text_song,text_duration;
        ImageView song_image;
    }


    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.adapter,null);
            holder hold = new holder();
            hold.text_song = (TextView)view.findViewById(R.id.song);
            hold.text_duration = (TextView)view.findViewById(R.id.duration);
            hold.song_image = (ImageView)view.findViewById(R.id.imageView);
            view.setTag(hold);
        }

        holder hold = (holder)view.getTag();
        hold.text_song.setText(songs.get(i).getTitle());
        hold.text_duration.setText(songs.get(i).getDuration());
        hold.song_image.setImageResource(R.drawable.play);

        return view;
    }

}
