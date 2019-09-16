package com.example.musicapp;

import java.io.Serializable;

public class MusicObject implements Serializable {
    private int id;
    private int imageId;
    private String artistName;
    private String songName;
    private String film;

    public MusicObject(int imageId, String artistName, String songName, String film) {
        this.imageId = imageId;
        this.artistName = artistName;
        this.songName = songName;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }
}
