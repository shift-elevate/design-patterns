package com.designpatterns.behavioural.iterator;

import java.util.Arrays;
import java.util.List;

public class MusicPlayerLauncher {

    public static void main(String[] args) {
        List<Song> sampleSongs = Arrays.asList(
                new Song("Bohemian Rhapsody", "Queen", "Rock"),
                new Song("Imagine", "John Lennon", "Pop"),
                new Song("Hotel California", "Eagles", "Rock")
        );

        MusicPlayer player = new MusicPlayer();

        System.out.println("=".repeat(60));
        System.out.println("ITERATOR PATTERN - MUSIC PLAYER DEMO");
        System.out.println("=".repeat(60));

        demonstrateShuffledPlaylist(player, sampleSongs);
        demonstrateFilteredPlaylist(player, sampleSongs);
        demonstrateResetFunctionality(player);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("ITERATOR PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }

    private static void demonstrateShuffledPlaylist(MusicPlayer player, List<Song> sampleSongs) {
        System.out.println("\n1. Shuffled Playlist:");
        System.out.println("=".repeat(60));

        ShuffledPlaylist shuffledPlaylist = new ShuffledPlaylist("Shuffled Mix");
        sampleSongs.forEach(shuffledPlaylist::addSong);

        player.loadPlaylist(shuffledPlaylist);
        System.out.println();

        player.playNext();
        System.out.println();

        player.playNext();
        System.out.println();

        player.showCurrentSong();
    }

    private static void demonstrateFilteredPlaylist(MusicPlayer player, List<Song> sampleSongs) {
        System.out.println("\n\n2. Filtered Playlist (Rock only):");
        System.out.println("=".repeat(60));

        FilteredPlaylist rockPlaylist = new FilteredPlaylist("Rock Collection", "Rock");
        sampleSongs.forEach(rockPlaylist::addSong);

        player.loadPlaylist(rockPlaylist);
        System.out.println();

        player.playNext();
        System.out.println();

        player.playNext();
    }

    private static void demonstrateResetFunctionality(MusicPlayer player) {
        System.out.println("\n\n3. Reset and Replay:");
        System.out.println("=".repeat(60));

        player.resetPlaylist();
        System.out.println();

        player.playNext();
    }
}
