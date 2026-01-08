package com.designpatterns.structural.proxy;

public class ImageProxy implements Image {
    private HighResolutionImage realImage;
    private ThumbnailImage thumbnail;
    private ImageMetadata metadata;
    private boolean isFullResolutionLoaded;

    public ImageProxy(ImageMetadata metadata) {
        this.metadata = metadata;
        this.isFullResolutionLoaded = false;
        this.thumbnail = new ThumbnailImage(metadata.getFilename(), metadata);
    }

    @Override
    public void display() {
        if (!isFullResolutionLoaded) {
            System.out.println("Displaying thumbnail preview for: " + metadata.getFilename());
            thumbnail.display();
        } else {
            realImage.display();
        }
    }

    @Override
    public void loadFullResolution() {
        if (realImage == null) {
            System.out.println("User requested full resolution for: " + metadata.getFilename());
            realImage = new HighResolutionImage(metadata);
            isFullResolutionLoaded = true;
        } else {
            System.out.println("Full resolution already loaded for: " + metadata.getFilename());
        }
    }

    @Override
    public ImageMetadata getMetadata() {
        return metadata;
    }

    public boolean isFullResolutionLoaded() {
        return isFullResolutionLoaded;
    }
}
