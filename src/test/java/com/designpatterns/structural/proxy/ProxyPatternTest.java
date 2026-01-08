package com.designpatterns.structural.proxy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ProxyPatternTest {

    private ImageMetadata metadata;
    private ImageProxy imageProxy;
    private PhotoGallery gallery;

    @BeforeEach
    void setUp() {
        metadata = new ImageMetadata("test_image.jpg", "JPEG", 10485760);
        imageProxy = new ImageProxy(metadata);
        gallery = new PhotoGallery("Test Gallery");
    }

    @Test
    @DisplayName("ImageMetadata - basic functionality")
    void testImageMetadataBasicFunctionality() {
        assertEquals("test_image.jpg", metadata.getFilename());
        assertEquals("JPEG", metadata.getFormat());
        assertEquals(10485760, metadata.getFileSize());
        assertTrue(metadata.toString().contains("test_image.jpg"));
        assertTrue(metadata.toString().contains("JPEG"));
    }

    @Test
    @DisplayName("ImageProxy - initial state without loading")
    void testImageProxyInitialState() {
        assertNotNull(imageProxy);
        assertFalse(imageProxy.isFullResolutionLoaded());
        assertEquals(metadata, imageProxy.getMetadata());
    }

    @Test
    @DisplayName("ImageProxy - lazy loading behavior")
    void testImageProxyLazyLoading() {
        assertFalse(imageProxy.isFullResolutionLoaded());

        imageProxy.loadFullResolution();
        assertTrue(imageProxy.isFullResolutionLoaded());

        imageProxy.loadFullResolution();
        assertTrue(imageProxy.isFullResolutionLoaded());
    }

    @Test
    @DisplayName("ImageProxy - display behavior")
    void testImageProxyDisplayBehavior() {
        assertDoesNotThrow(() -> imageProxy.display());

        imageProxy.loadFullResolution();
        assertDoesNotThrow(() -> imageProxy.display());
    }

    @Test
    @DisplayName("PhotoGallery - add images")
    void testPhotoGalleryAddImages() {
        gallery.addImage(imageProxy);
        assertDoesNotThrow(() -> gallery.displayGallery());
    }

    @Test
    @DisplayName("PhotoGallery - view image")
    void testPhotoGalleryViewImage() {
        gallery.addImage(imageProxy);
        assertDoesNotThrow(() -> gallery.viewImage(0));
        assertTrue(imageProxy.isFullResolutionLoaded());
    }

    @Test
    @DisplayName("PhotoGallery - statistics")
    void testPhotoGalleryStatistics() {
        ImageProxy proxy1 = new ImageProxy(new ImageMetadata("image1.jpg", "JPEG", 10485760));
        ImageProxy proxy2 = new ImageProxy(new ImageMetadata("image2.jpg", "JPEG", 12582912));
        ImageProxy proxy3 = new ImageProxy(new ImageMetadata("image3.jpg", "JPEG", 11534336));

        gallery.addImage(proxy1);
        gallery.addImage(proxy2);
        gallery.addImage(proxy3);

        assertFalse(proxy1.isFullResolutionLoaded());
        assertFalse(proxy2.isFullResolutionLoaded());
        assertFalse(proxy3.isFullResolutionLoaded());

        proxy2.loadFullResolution();
        assertTrue(proxy2.isFullResolutionLoaded());

        assertDoesNotThrow(() -> gallery.showStatistics());
    }

    @Test
    @DisplayName("Proxy Pattern - complete demo")
    void testProxyPatternDemo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TESTING: Proxy Pattern Demo");
        System.out.println("=".repeat(60));

        ProxyLauncher.main(new String[]{});

        assertTrue(true, "Proxy pattern demo executed successfully");
    }

    @Test
    @DisplayName("Proxy Pattern - memory efficiency")
    void testProxyPatternMemoryEfficiency() {
        ImageProxy proxy1 = new ImageProxy(new ImageMetadata("image1.jpg", "JPEG", 10485760));
        ImageProxy proxy2 = new ImageProxy(new ImageMetadata("image2.jpg", "JPEG", 12582912));
        ImageProxy proxy3 = new ImageProxy(new ImageMetadata("image3.jpg", "JPEG", 11534336));

        assertFalse(proxy1.isFullResolutionLoaded());
        assertFalse(proxy2.isFullResolutionLoaded());
        assertFalse(proxy3.isFullResolutionLoaded());

        proxy1.loadFullResolution();

        assertTrue(proxy1.isFullResolutionLoaded());
        assertFalse(proxy2.isFullResolutionLoaded());
        assertFalse(proxy3.isFullResolutionLoaded());
    }
}
