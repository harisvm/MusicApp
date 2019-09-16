package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {
    List<MusicObject> songList;
    RecyclerView recyclerView;
    CardView cardView;
    RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        songList.add(new MusicObject(R.drawable.happier, "Dan Smith", "Happier", "Album"));
        songList.add(new MusicObject(R.drawable.gods_plan, "Drake", "God's Plan", "Album"));
        songList.add(new MusicObject(R.drawable.human, "Ragnambore Man", "Human", "Album"));
        songList.add(new MusicObject(R.drawable.i_mean_it, "G-Easy", "I Mean It", "Album"));
        songList.add(new MusicObject(R.drawable.so_good, "Bob", "So Good", "Album"));
        songList.add(new MusicObject(R.drawable.basdblood, "Bastille", "Bad Blood", "Album"));
        songList.add(new MusicObject(R.drawable.lukas_graham, "Lukas Graham", "7 Years", "Album"));
        songList.add(new MusicObject(R.drawable.paradise, "ColdPlay", "Paradise", "Album"));
        songList.add(new MusicObject(R.drawable.pillow_talk, "Zayn Malik", "Pillow Talk", "Album"));
        songList.add(new MusicObject(R.drawable.sound_bwoy, "Stylo-G", "Sound Bwoy", "Album"));
        songList.add(new MusicObject(R.drawable.treat_you, "Shawn Mendes", "Treat You Better", "Album"));

        MusicAdapter adapter = new MusicAdapter(this, songList, listener);

        cardView = findViewById(R.id.card);


        recyclerView.setAdapter(adapter);

    }


    @Override
    public void recyclerViewListClicked(View view, int position) {


    }
}
