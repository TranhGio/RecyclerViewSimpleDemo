package com.example.recyclerviewcontentprovider;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewListener {

    RecyclerView recyclerView;
    ArrayList<Song> songs;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewSong);
        dummyData();
        SongAdapter songAdapter = new SongAdapter(this, songs, this);
        recyclerView.setAdapter(songAdapter);
    }

    private void dummyData() {
        songs = new ArrayList<>();
        Song song1 = new Song(R.mipmap.image1, "anh nha o dau the", "amme", R.raw.anh_nha_o_dau_the);
        Song song2 = new Song(R.mipmap.image2, "xuan ha thu dong", "binz", R.raw.xuan_ha_thu_dong);
        songs.add(song1);
        songs.add(song2);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClickListener(int pos) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = mediaPlayer.create(this, songs.get(pos).songId);
        mediaPlayer.start();
    }
}
