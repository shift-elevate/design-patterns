package com.designpatterns.behavioural.iterator;

import java.util.List;
import java.util.stream.Collectors;

public class FilteredPlaylistIterator implements SongIterator {
    private List<Song> filteredSongs;
    private int currentIndex;

    public FilteredPlaylistIterator(List<Song> songs, String filterGenre) {
        this.filteredSongs = songs.stream()
                .filter(song -> song.getGenre().equalsIgnoreCase(filterGenre))
                .collect(Collectors.toList());
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < filteredSongs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            return filteredSongs.get(currentIndex++);
        }
        return null;
    }

    @Override
    public Song current() {
        if (currentIndex > 0 && currentIndex <= filteredSongs.size()) {
            return filteredSongs.get(currentIndex - 1);
        }
        return null;
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
