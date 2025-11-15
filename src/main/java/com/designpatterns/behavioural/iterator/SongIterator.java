package com.designpatterns.behavioural.iterator;

public interface SongIterator {
    boolean hasNext();
    Song next();
    Song current();
    void reset();
}
