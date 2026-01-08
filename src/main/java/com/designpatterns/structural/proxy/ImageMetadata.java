package com.designpatterns.structural.proxy;

public class ImageMetadata {
    private String filename;
    private String format;
    private long fileSize;

    public ImageMetadata(String filename, String format, long fileSize) {
        this.filename = filename;
        this.format = format;
        this.fileSize = fileSize;
    }

    public String getFilename() { return filename; }
    public String getFormat() { return format; }
    public long getFileSize() { return fileSize; }

    @Override
    public String toString() {
        return String.format("%s [%s] - %.2f MB",
                filename, format, fileSize / (1024.0 * 1024.0));
    }
}
