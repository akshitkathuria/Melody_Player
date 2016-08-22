package com.example.boyzz.melody_player;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by boyzz on 8/13/16.
 */

public class SongDetail implements Parcelable{

    private String id;
    private String title;
    private String artist;
    private String path;
    private String duration;
    private String album;

    public SongDetail(String songID, String songTitle,String songAlbum, String songArtist, String path, String duration){
        id=songID;
        title=songTitle;
        artist=songArtist;
        this.path = path;
        album = songAlbum;
        this.duration = duration;

    }

    protected SongDetail(Parcel in) {
        id = in.readString();
        title = in.readString();
        artist = in.readString();
        path = in.readString();
        duration = in.readString();
        album = in.readString();
    }

    public static final Creator<SongDetail> CREATOR = new Creator<SongDetail>() {
        @Override
        public SongDetail createFromParcel(Parcel in) {
            return new SongDetail(in);
        }

        @Override
        public SongDetail[] newArray(int size) {
            return new SongDetail[size];
        }
    };

    public String getID(){return id;}
    public String getTitle(){return title;}
    public String getAlbum(){return album;}
    public String getArtist(){return artist;}
    public String getPath(){return path;}
    public String getDuration(){return duration;}

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(artist);
        parcel.writeString(path);
        parcel.writeString(duration);
        parcel.writeString(album);
    }
}
