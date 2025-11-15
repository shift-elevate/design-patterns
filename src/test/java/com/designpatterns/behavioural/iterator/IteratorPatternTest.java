package com.designpatterns.behavioural.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorPatternTest {

    private Song song1;
    private Song song2;
    private Song song3;
    private ShuffledPlaylist shuffledPlaylist;
    private FilteredPlaylist rockPlaylist;
    private MusicPlayer player;

    @BeforeEach
    void setUp() {
        song1 = new Song("Bohemian Rhapsody", "Queen", "Rock");
        song2 = new Song("Imagine", "John Lennon", "Pop");
        song3 = new Song("Hotel California", "Eagles", "Rock");

        shuffledPlaylist = new ShuffledPlaylist("Test Shuffled Playlist");
        rockPlaylist = new FilteredPlaylist("Test Rock Playlist", "Rock");

        player = new MusicPlayer();
    }

    @Test
    @DisplayName("Song - basic functionality")
    void testSongBasicFunctionality() {
        assertEquals("Bohemian Rhapsody", song1.getTitle());
        assertEquals("Queen", song1.getArtist());
        assertEquals("Rock", song1.getGenre());
    }

    @Test
    @DisplayName("Song - toString formatting")
    void testSongToStringFormatting() {
        String expected = "Bohemian Rhapsody by Queen [Rock]";
        assertEquals(expected, song1.toString());
    }

    @Test
    @DisplayName("ShuffledPlaylist - add and count songs")
    void testShuffledPlaylistAddSongs() {
        assertEquals(0, shuffledPlaylist.getSongCount());

        shuffledPlaylist.addSong(song1);
        assertEquals(1, shuffledPlaylist.getSongCount());

        shuffledPlaylist.addSong(song2);
        assertEquals(2, shuffledPlaylist.getSongCount());
    }

    @Test
    @DisplayName("FilteredPlaylist - count only matching genre")
    void testFilteredPlaylistFilteringSongs() {
        rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);
        rockPlaylist.addSong(song3);

        assertEquals(2, rockPlaylist.getSongCount());
    }

    @Test
    @DisplayName("ShuffledPlaylistIterator - hasNext and next")
    void testShuffledIteratorBasicIteration() {
        shuffledPlaylist.addSong(song1);
        shuffledPlaylist.addSong(song2);

        SongIterator iterator = shuffledPlaylist.createIterator();

        assertTrue(iterator.hasNext());
        assertNotNull(iterator.next());

        assertTrue(iterator.hasNext());
        assertNotNull(iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("FilteredPlaylistIterator - only iterates matching songs")
    void testFilteredIteratorFiltering() {
        rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);
        rockPlaylist.addSong(song3);

        SongIterator iterator = rockPlaylist.createIterator();

        int count = 0;
        while (iterator.hasNext()) {
            Song song = iterator.next();
            assertEquals("Rock", song.getGenre());
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    @DisplayName("Iterator - reset functionality")
    void testIteratorReset() {
        shuffledPlaylist.addSong(song1);
        shuffledPlaylist.addSong(song2);

        SongIterator iterator = shuffledPlaylist.createIterator();

        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());

        iterator.reset();
        assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("MusicPlayer - load playlist")
    void testMusicPlayerLoadPlaylist() {
        shuffledPlaylist.addSong(song1);

        player.loadPlaylist(shuffledPlaylist);

        assertEquals(shuffledPlaylist, player.getCurrentPlaylist());
        assertNotNull(player.getIterator());
        assertEquals(0, player.getSongsPlayed());
    }

    @Test
    @DisplayName("MusicPlayer - play next song")
    void testMusicPlayerPlayNext() {
        shuffledPlaylist.addSong(song1);
        shuffledPlaylist.addSong(song2);

        player.loadPlaylist(shuffledPlaylist);

        player.playNext();
        assertEquals(1, player.getSongsPlayed());

        player.playNext();
        assertEquals(2, player.getSongsPlayed());
    }

    @Test
    @DisplayName("MusicPlayer - reset playlist")
    void testMusicPlayerResetPlaylist() {
        shuffledPlaylist.addSong(song1);
        shuffledPlaylist.addSong(song2);

        player.loadPlaylist(shuffledPlaylist);
        player.playNext();
        player.playNext();

        assertEquals(2, player.getSongsPlayed());

        player.resetPlaylist();
        assertEquals(0, player.getSongsPlayed());
    }

    @Test
    @DisplayName("Demo: Iterator Pattern in Action")
    void testIteratorPatternDemo() {
        MusicPlayerLauncher.main(new String[]{});
        assertTrue(true, "Iterator Pattern demonstration completed successfully");
    }
}
