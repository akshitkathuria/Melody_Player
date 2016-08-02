package com.example.boyzz.melody_player;

import android.app.Activity;
import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.ArrayList;

public class Player extends Activity implements Runnable
{
    static String position;
    SeekBar seekbar;
    Thread seekthread;
    String song;
    ArrayList<String> path = null;
    Button start,stop,pause;
    MediaPlayer mp = new MediaPlayer();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        pause = (Button)findViewById(R.id.pause);
        seekbar = (SeekBar)findViewById(R.id.seekbar);

        seekthread = new Thread(this);

        Bundle bundle = getIntent().getExtras();

        position = bundle.getString("ids");
        path = bundle.getStringArrayList("values");

        song = path.get(Integer.parseInt(position));

        try
        {
            mp.reset();
            mp.setDataSource(song);
            mp.prepare();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                if(b)
                {
                    mp.seekTo(i);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }


    public void start(View view)
    {
        if(mp.isPlaying())
        {
            mp.stop();
        }
        mp.start();
        seekthread.start();
    }
    public void pause(View view)
    {
        mp.pause();
    }
    public void stop(View view)
    {
        mp.stop();
    }
    public void Delete(View view)
    {

    }

    @Override
    public void run()
    {
        int currentposition = 0;
        int duration = mp.getDuration();
        seekbar.setMax(duration);
        System.out.println("-------------------"+currentposition);

        while ( mp!=null && currentposition<duration)
        {
            try
            {
                seekthread.sleep(300);
                currentposition = mp.getCurrentPosition();
            }
            catch (Exception e)
            {

            }
            seekbar.setProgress(currentposition);
        }
    }
}