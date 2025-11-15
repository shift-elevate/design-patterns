package com.designpatterns.behavioural.iterator;

public interface Playlist {
    SongIterator createIterator();
    void addSong(Song song);
    void removeSong(Song song);
    String getPlaylistName();
    int getSongCount();
}
