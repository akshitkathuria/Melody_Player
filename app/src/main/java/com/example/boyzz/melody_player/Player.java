package com.example.boyzz.melody_player;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.ArrayList;

public class Player extends Activity
{
    Handler handler;
    SeekBar seekbar;
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

        Bundle bundle = getIntent().getExtras();

        String position = bundle.getString("ids");
        path = bundle.getStringArrayList("values");

        song = path.get(Integer.parseInt(position));

        try
        {
            mp.reset();
            mp.setDataSource(song);
            mp.prepare();

            int mediamax = mp.getDuration();
            int mediapos = mp.getCurrentPosition();

            seekbar.setMax(mediamax);
            seekbar.setProgress(mediapos);

            handler.removeCallbacks(moveSeekBarThread);
            handler.postDelayed(moveSeekBarThread,100);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Runnable moveSeekBarThread = new Runnable()
    {
        @Override
        public void run()
        {
            if(mp.isPlaying())
            {
                int mediaPos_new = mp.getCurrentPosition();
                int mediaMax_new = mp.getDuration();
                seekbar.setMax(mediaMax_new);
                seekbar.setProgress(mediaPos_new);

                handler.postDelayed(this, 100);
            }
        }
    };

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
        mp.stop();
    }
}