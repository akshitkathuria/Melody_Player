package com.example.boyzz.melody_player;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by boyzz on 7/21/16.
 */

public class Getter //extends Activity
{
    //Context c = getApplication();
    static Uri uri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "");

    static String[] projection = new String[]{MediaStore.Audio.Media.DURATION,MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ARTIST};

    static ArrayList<SongDetail> detaillist = new ArrayList<SongDetail>();
    //static ArrayList<String> pathlist = new ArrayList<String>();
    //static ArrayList<String> titlelist = new ArrayList<String>();
    //static ArrayList<String> albumlist = new ArrayList<String>();
    //static ArrayList<String> artistlist = new ArrayList<>();
    //static ArrayList<String> durationlist = new ArrayList<String>();
    Cursor cursor;

    public void getlist(Context context)
    {
        cursor = context.getContentResolver().query(uri,projection,MediaStore.Audio.Media.IS_MUSIC,null,null);
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                //pathlist.add(new String(path));

                String id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));

                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                //titlelist.add(new String(title));

                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                //albumlist.add(new String(album));

                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                //artistlist.add(new String(artist));

                String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                long millis = Long.parseLong(duration);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
                long sec = TimeUnit.MILLISECONDS.toSeconds(millis);
                sec = sec%60;
                StringBuilder sb = new StringBuilder();
                sb.append(minutes);
                sb.append(":");
                sb.append(sec);
                //durationlist.add(new String(sb));

                detaillist.add(new SongDetail(id, title, album, artist, path, duration));

            } while (cursor.moveToNext());
        }

        cursor.close();
    }

    public static ArrayList<SongDetail> getSongsList()
    {
        return detaillist;
    }
    /*public static ArrayList<String> getArtistList()
    {
        return artistlist;
    }
    public static ArrayList<String> getPathList()
    {
        return pathlist;
    }
    public static ArrayList<String> getAlbumList()
    {
        return albumlist;
    }
    public static ArrayList<String> getDurationList()
    {
        return durationlist;
    }*/
}