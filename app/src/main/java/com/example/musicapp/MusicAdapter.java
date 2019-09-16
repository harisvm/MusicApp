package com.example.musicapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MovieViewHolder> implements Serializable {

    private Context mContext;
    private List<MusicObject> songList;
    private RecyclerViewClickListener listener;

    public MusicAdapter(Context mContext, List<MusicObject> songList, RecyclerViewClickListener listener) {
        this.mContext = mContext;
        this.songList = songList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = (View) inflater.inflate(R.layout.card, null);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {

        MusicObject musicObject = songList.get(position);

        holder.song.setText(musicObject.getSongName());
        holder.artist.setText(musicObject.getArtistName());
        holder.film.setText(musicObject.getFilm());

        holder.image.setImageDrawable(mContext.getResources().getDrawable(musicObject.getImageId()));

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView song, artist, film;
        ImageView image;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            song = itemView.findViewById(R.id.song_name);
            artist = itemView.findViewById(R.id.artist);
            film = itemView.findViewById(R.id.movie);
            image = itemView.findViewById(R.id.imag);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            MusicObject musicObject = songList.get(position);
            Intent intent = new Intent(itemView.getContext(), SongActivity.class);
            intent.putExtra("song", musicObject);
            intent.putExtra("position", position);
            Bundle args = new Bundle();
            args.putSerializable("Song_list", (Serializable) songList);
            intent.putExtra("Bundle", args);
            view.getContext().startActivity(intent);

        }
    }


}
