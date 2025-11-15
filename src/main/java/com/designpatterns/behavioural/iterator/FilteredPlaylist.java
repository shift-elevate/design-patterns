package com.designpatterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class FilteredPlaylist implements Playlist {
    private String name;
    private List<Song> songs;
    private String filterGenre;

    public FilteredPlaylist(String name, String filterGenre) {
        this.name = name;
        this.songs = new ArrayList<>();
        this.filterGenre = filterGenre;
    }

    @Override
    public SongIterator createIterator() {
        return new FilteredPlaylistIterator(songs, filterGenre);
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
        return name + " (Filtered: " + filterGenre + ")";
    }

    @Override
    public int getSongCount() {
        return (int) songs.stream()
                .filter(song -> song.getGenre().equalsIgnoreCase(filterGenre))
                .count();
    }
}
