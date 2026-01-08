package com.designpatterns.structural.proxy;

public class ThumbnailImage {
    private String filename;
    private byte[] thumbnailData;

    public ThumbnailImage(String filename, ImageMetadata metadata) {
        this.filename = filename;
        loadThumbnail();
    }

    private void loadThumbnail() {
        System.out.println("Loading thumbnail for: " + filename);
        this.thumbnailData = new byte[102400];
        System.out.println("Thumbnail loaded: " + filename + " (100 KB)");
    }

    public void display() {
        System.out.println("Displaying thumbnail: " + filename);
    }
}
