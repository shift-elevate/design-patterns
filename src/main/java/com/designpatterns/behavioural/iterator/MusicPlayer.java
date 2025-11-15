package com.designpatterns.behavioural.iterator;

public class MusicPlayer {
    private Playlist currentPlaylist;
    private SongIterator iterator;
    private int songsPlayed;

    public void loadPlaylist(Playlist playlist) {
        this.currentPlaylist = playlist;
        this.iterator = playlist.createIterator();
        this.songsPlayed = 0;
        System.out.println("Loaded playlist: " + playlist.getPlaylistName());
        System.out.println("Total songs: " + playlist.getSongCount());
    }

    public void playNext() {
        if (iterator != null && iterator.hasNext()) {
            Song song = iterator.next();
            songsPlayed++;
            System.out.println("Now playing: " + song);
            System.out.println("Progress: " + songsPlayed + "/" + currentPlaylist.getSongCount());
        } else {
            System.out.println("End of playlist reached");
        }
    }

    public void showCurrentSong() {
        if (iterator != null) {
            Song current = iterator.current();
            if (current != null) {
                System.out.println("Current song: " + current);
            } else {
                System.out.println("No song currently playing");
            }
        }
    }

    public void resetPlaylist() {
        if (iterator != null) {
            iterator.reset();
            songsPlayed = 0;
            System.out.println("Playlist reset to beginning");
        }
    }

    public void showPlaylistInfo() {
        if (currentPlaylist != null) {
            System.out.println("Playlist: " + currentPlaylist.getPlaylistName());
            System.out.println("Songs: " + currentPlaylist.getSongCount());
        }
    }

    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    public SongIterator getIterator() {
        return iterator;
    }

    public int getSongsPlayed() {
        return songsPlayed;
    }
}
