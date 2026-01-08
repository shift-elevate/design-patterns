package com.designpatterns.structural.proxy;

public class HighResolutionImage implements Image {
    private byte[] imageData;
    private ImageMetadata metadata;
    private boolean isLoaded;

    public HighResolutionImage(ImageMetadata metadata) {
        this.metadata = metadata;
        this.isLoaded = false;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading high-resolution image: " + metadata.getFilename());
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
            this.imageData = new byte[(int) metadata.getFileSize()];
            this.isLoaded = true;

            long loadTime = System.currentTimeMillis() - startTime;
            System.out.println(String.format("High-res image loaded: %s (%.2f MB) in %d ms",
                    metadata.getFilename(), metadata.getFileSize() / (1024.0 * 1024.0), loadTime));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        if (isLoaded) {
            System.out.println("Displaying high-resolution image: " + metadata.getFilename());
        } else {
            System.out.println("Image not loaded yet: " + metadata.getFilename());
        }
    }

    @Override
    public void loadFullResolution() {
        if (!isLoaded) {
            loadFromDisk();
        }
    }

    @Override
    public ImageMetadata getMetadata() {
        return metadata;
    }
}
