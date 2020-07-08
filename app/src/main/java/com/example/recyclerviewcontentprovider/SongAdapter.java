package com.example.recyclerviewcontentprovider;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * @author at-vinhnguyen on 7/6/20.
 */

class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongHolder> {

    private ArrayList<Song> songs;
    private Context context;
    private MediaPlayer mediaPlayer;
    private RecyclerViewListener listener;

    public SongAdapter(Context context, ArrayList<Song> songs, RecyclerViewListener listener) {
        this.songs = songs;
        this.context = context;
        mediaPlayer = new MediaPlayer();
        this.listener = listener;
    }

    @NonNull
    @Override
    public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        SongHolder holder = new SongHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongHolder holder, final int position) {
        holder.bindView(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {

        ImageView imgSong;
        TextView tvSongName;
        TextView tvSongAuthor;

        public SongHolder(@NonNull View itemView) {
            super(itemView);
            imgSong = itemView.findViewById(R.id.imgSong);
            tvSongName = itemView.findViewById(R.id.songName);
            tvSongAuthor = itemView.findViewById(R.id.songAuthor);
        }

        public void bindView(int position) {
            imgSong.setImageResource(songs.get(position).image);
            tvSongName.setText(songs.get(position).songName);
            tvSongAuthor.setText(songs.get(position).songAuthor);
        }
    }
}
