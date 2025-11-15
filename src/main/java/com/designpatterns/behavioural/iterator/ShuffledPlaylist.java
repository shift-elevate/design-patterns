package com.designpatterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class ShuffledPlaylist implements Playlist {
    private String name;
    private List<Song> songs;

    public ShuffledPlaylist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    @Override
    public SongIterator createIterator() {
        return new ShuffledPlaylistIterator(songs);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String getPlaylistName() {
        return name;
    }

    @Override
    public int getSongCount() {
        return songs.size();
    }
}
