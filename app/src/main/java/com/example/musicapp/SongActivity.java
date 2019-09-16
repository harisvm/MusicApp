package com.example.musicapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {
    ImageView imageView;
    TextView song, artist;
    SeekBar seekBar;
    ImageButton play, back, forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        imageView = findViewById(R.id.imagee);

        song = findViewById(R.id.song_name);
        artist = findViewById(R.id.artist_name);

        final MusicObject currentSong = (MusicObject) getIntent().getSerializableExtra("song");

        final int[] position = {getIntent().getIntExtra("position", 0)};

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("Bundle");
        final ArrayList<Object> object = (ArrayList<Object>) args.getSerializable("Song_list");

        imageView.setImageDrawable(this.getResources().getDrawable(currentSong.getImageId()));
        song.setText(currentSong.getSongName());
        artist.setText(currentSong.getArtistName());

        play = findViewById(R.id.play);

        back = findViewById(R.id.rewind);
        forward = findViewById(R.id.forward);


        forward.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (position[0] < 10) {
                    MusicObject m1 = (MusicObject) object.get(position[0] + 1);
                    imageView.setImageDrawable(getDrawable(m1.getImageId()));
                    song.setText(m1.getSongName());
                    artist.setText(m1.getArtistName());
                    position[0] = position[0] + 1;

                } else {

                    position[0] = 0;

                    MusicObject m2 = (MusicObject) object.get(position[0]);
                    imageView.setImageDrawable(getDrawable(m2.getImageId()));
                    song.setText(m2.getSongName());
                    artist.setText(m2.getArtistName());
                    position[0] = position[0] + 1;

                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (position[0] > 0) {
                    MusicObject m3 = (MusicObject) object.get(position[0] - 1);
                    imageView.setImageDrawable(getDrawable(m3.getImageId()));
                    song.setText(m3.getSongName());
                    artist.setText(m3.getArtistName());
                    position[0] = position[0] - 1;

                } else {
                    MusicObject m4 = (MusicObject) object.get(10);
                    imageView.setImageDrawable(getDrawable(m4.getImageId()));
                    song.setText(m4.getSongName());
                    artist.setText(m4.getArtistName());
                    position[0] = 9;


                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusicObject m5 = (MusicObject) object.get(position[0]);
                Toast.makeText(getApplicationContext(), m5.getSongName(), Toast.LENGTH_LONG).show();

            }
        });


    }

}
