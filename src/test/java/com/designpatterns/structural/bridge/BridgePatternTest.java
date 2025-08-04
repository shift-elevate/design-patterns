package com.designpatterns.structural.bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bridge Pattern Tests")
class BridgePatternTest {
    
    private Renderer openglRenderer;
    private Renderer directxRenderer;
    private Circle circle;
    private Rectangle rectangle;
    
    @BeforeEach
    void setUp() {
        openglRenderer = new OpenGLRenderer();
        directxRenderer = new DirectXRenderer();
        circle = new Circle(openglRenderer, 10, 20, 5);
        rectangle = new Rectangle(directxRenderer, 0, 0, 15, 10);
    }
    
    @Test
    @DisplayName("Should create shapes with specified renderers")
    void shouldCreateShapesWithSpecifiedRenderers() {
        assertNotNull(circle);
        assertNotNull(rectangle);
        assertEquals(10, circle.getX());
        assertEquals(20, circle.getY());
        assertEquals(5, circle.getRadius());
        assertEquals(0, rectangle.getX());
        assertEquals(0, rectangle.getY());
        assertEquals(15, rectangle.getWidth());
        assertEquals(10, rectangle.getHeight());
    }
    
    @Test
    @DisplayName("Should allow runtime renderer switching")
    void shouldAllowRuntimeRendererSwitching() {
        circle.setRenderer(openglRenderer);
        
        circle.setRenderer(directxRenderer);
        
        circle.setRenderer(openglRenderer);
        
        assertDoesNotThrow(() -> circle.draw());
    }
    
    @Test
    @DisplayName("Should modify shape properties correctly")
    void shouldModifyShapePropertiesCorrectly() {
        circle.setRadius(7);
        assertEquals(7, circle.getRadius());
        
        rectangle.resize(20, 15);
        assertEquals(20, rectangle.getWidth());
        assertEquals(15, rectangle.getHeight());
    }
    
    @Test
    @DisplayName("Should handle multiple shapes with different renderers")
    void shouldHandleMultipleShapesWithDifferentRenderers() {
        Circle circle1 = new Circle(openglRenderer, 1, 1, 2);
        Circle circle2 = new Circle(directxRenderer, 2, 2, 3);
        Rectangle rect1 = new Rectangle(openglRenderer, 0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(directxRenderer, 1, 1, 6, 6);
        
        assertDoesNotThrow(() -> {
            circle1.draw();
            circle2.draw();
            rect1.draw();
            rect2.draw();
        });
    }
    
    @Test
    @DisplayName("Should demonstrate Bridge pattern flexibility")
    void shouldDemonstrateBridgePatternFlexibility() {
        Circle testCircle = new Circle(openglRenderer, 5, 5, 3);
        
        testCircle.setRenderer(directxRenderer);
        testCircle.setRenderer(openglRenderer);
        testCircle.setRenderer(directxRenderer);
        
        testCircle.setRadius(8);
        
        assertEquals(8, testCircle.getRadius());
        assertDoesNotThrow(() -> testCircle.draw());
    }
    
    @Test
    @DisplayName("Should maintain shape state across renderer changes")
    void shouldMaintainShapeStateAcrossRendererChanges() {
        circle.setRadius(10);
        rectangle.resize(25, 30);
        
        circle.setRenderer(directxRenderer);
        rectangle.setRenderer(openglRenderer);
        
        assertEquals(10, circle.getRadius());
        assertEquals(25, rectangle.getWidth());
        assertEquals(30, rectangle.getHeight());
    }
} 