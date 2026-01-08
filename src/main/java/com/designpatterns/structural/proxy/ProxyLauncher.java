package com.designpatterns.structural.proxy;

public class ProxyLauncher {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("PROXY PATTERN");
        System.out.println("=".repeat(60));

        PhotoGallery gallery = new PhotoGallery("Vacation Photos");

        gallery.addImage(new ImageProxy(
                new ImageMetadata("sunset_beach.jpg", "JPEG", 10485760)));
        gallery.addImage(new ImageProxy(
                new ImageMetadata("mountain_peak.jpg", "JPEG", 12582912)));
        gallery.addImage(new ImageProxy(
                new ImageMetadata("city_skyline.jpg", "JPEG", 11534336)));

        System.out.println("\nGallery loaded! Only thumbnails in memory.\n");

        gallery.displayGallery();
        gallery.viewImage(1);
        gallery.viewImage(1);
        gallery.showStatistics();

        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROXY PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));
    }
}
