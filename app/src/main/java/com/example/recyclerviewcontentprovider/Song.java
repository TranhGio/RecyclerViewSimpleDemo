package com.example.recyclerviewcontentprovider;

/**
 * @author at-vinhnguyen on 7/6/20.
 */
class Song {
    int image;
    String songName;
    String songAuthor;
    int songId;

    public Song(int image, String songName, String songAuthor, int songId) {
        this.image = image;
        this.songName = songName;
        this.songAuthor = songAuthor;
        this.songId = songId;
    }
}
