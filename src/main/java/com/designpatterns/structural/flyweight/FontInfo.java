package com.designpatterns.structural.flyweight;

import java.util.Objects;

public class FontInfo {
    private String fontFamily;
    private int fontSize;
    
    public FontInfo(String fontFamily, int fontSize) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
    
    public String getFontFamily() { return fontFamily; }
    public int getFontSize() { return fontSize; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FontInfo other = (FontInfo) obj;
        return Objects.equals(fontFamily, other.fontFamily) && 
               fontSize == other.fontSize;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fontFamily, fontSize);
    }
}
