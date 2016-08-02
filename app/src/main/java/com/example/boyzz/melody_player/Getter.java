package com.example.boyzz.melody_player;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;

/**
 * Created by boyzz on 7/21/16.
 */

public class Getter //extends Activity
{
    //Context c = getApplication();
    static Uri uri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "");

    static String[] projection = new String[]{MediaStore.Audio.Media._ID, MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ALBUM, MediaStore.Audio.Media.ARTIST};

    static ArrayList<String> pathlist = new ArrayList<String>();
    static ArrayList<String> titlelist = new ArrayList<String>();
    static ArrayList<String> albumlist = new ArrayList<String>();
    static ArrayList<String> artistlist = new ArrayList<>();
    Cursor cursor;

    public void getlist(Context context)
    {
        cursor = context.getContentResolver().query(uri,projection,MediaStore.Audio.Media.IS_MUSIC,null,null);
        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                pathlist.add(new String(path));

                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                titlelist.add(new String(title));

                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                albumlist.add(new String(album));

                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                artistlist.add(new String(artist));



            } while (cursor.moveToNext());
        }

        cursor.close();
    }

    public static ArrayList<String> getSongsList()
    {
        return titlelist;
    }
    public static ArrayList<String> getArtistList()
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
}