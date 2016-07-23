package com.example.boyzz.melody_player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by boyzz on 7/17/16.
 */
public class Player extends Activity
{
    String song;
    ArrayList<String> path = null;
    Button start,stop,pause;
    MediaPlayer mp = new MediaPlayer();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        start = (Button)findViewById(R.id.start);
        pause = (Button)findViewById(R.id.pause);
        stop = (Button)findViewById(R.id.stop);

        Bundle bundle = getIntent().getExtras();

        String position = bundle.getString("ids");
        path =bundle.getStringArrayList("values");

        System.out.print(path);
        song = path.get(Integer.parseInt(position));
        Toast.makeText(getApplicationContext(),song,Toast.LENGTH_SHORT).show();

        try
        {
            mp.setDataSource(song);
            mp.prepare();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void start(View view)
    {

        mp.start();
    }
    public void pause(View view)
    {
        mp.pause();
    }
    public void stop(View view)
    {
        mp.release();
    }
}
