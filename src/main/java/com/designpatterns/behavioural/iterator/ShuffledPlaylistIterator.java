package com.designpatterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledPlaylistIterator implements SongIterator {
    private List<Song> songs;
    private int currentIndex;

    public ShuffledPlaylistIterator(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
        shuffleSongs();
        this.currentIndex = 0;
    }

    private void shuffleSongs() {
        Collections.shuffle(songs);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < songs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            return songs.get(currentIndex++);
        }
        return null;
    }

    @Override
    public Song current() {
        if (currentIndex > 0 && currentIndex <= songs.size()) {
            return songs.get(currentIndex - 1);
        }
        return null;
    }

    @Override
    public void reset() {
        shuffleSongs();
        currentIndex = 0;
    }
}
