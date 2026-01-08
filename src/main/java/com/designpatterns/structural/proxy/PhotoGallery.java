package com.designpatterns.structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class PhotoGallery {
    private List<Image> images;
    private String galleryName;

    public PhotoGallery(String galleryName) {
        this.galleryName = galleryName;
        this.images = new ArrayList<>();
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void displayGallery() {
        System.out.println("\n=== " + galleryName + " ===");
        for (int i = 0; i < images.size(); i++) {
            System.out.println("Image " + (i + 1) + ":");
            images.get(i).display();
        }
    }

    public void viewImage(int index) {
        System.out.println("\n=== Viewing Image " + (index + 1) + " ===");
        Image image = images.get(index);
        System.out.println("Metadata: " + image.getMetadata().toString());
        image.loadFullResolution();
        image.display();
    }

    public void showStatistics() {
        int loadedCount = 0;
        for (Image image : images) {
            if (image instanceof ImageProxy && ((ImageProxy) image).isFullResolutionLoaded()) {
                loadedCount++;
            }
        }
        System.out.println("\n=== Statistics ===");
        System.out.println("Total: " + images.size() + " | Loaded: " + loadedCount +
                         " | Memory saved: " + (images.size() - loadedCount) * 100 / images.size() + "%");
    }
}
