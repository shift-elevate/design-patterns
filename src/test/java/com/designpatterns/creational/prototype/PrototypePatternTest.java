package com.designpatterns.creational.prototype;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrototypePatternTest {
    
    private Circle circlePrototype;
    private Rectangle rectanglePrototype;
    private PrototypeRegistry registry;
    
    @BeforeEach
    void setUp() {
        circlePrototype = new Circle(10, "red");
        rectanglePrototype = new Rectangle(20, 10, "blue");
        registry = new PrototypeRegistry();
    }
    
    @Test
    void testCircleCloning() {
        Shape clonedCircle = circlePrototype.clone();
        
        assertNotNull(clonedCircle);
        assertTrue(clonedCircle instanceof Circle);
        assertEquals("Circle", clonedCircle.getName());
        
        Circle circle = (Circle) clonedCircle;
        assertEquals(10, circle.getRadius());
        assertEquals("red", circle.getColor());
    }
    
    @Test
    void testRectangleCloning() {
        Shape clonedRectangle = rectanglePrototype.clone();
        
        assertNotNull(clonedRectangle);
        assertTrue(clonedRectangle instanceof Rectangle);
        assertEquals("Rectangle", clonedRectangle.getName());
        
        Rectangle rectangle = (Rectangle) clonedRectangle;
        assertEquals(20, rectangle.getWidth());
        assertEquals(10, rectangle.getHeight());
        assertEquals("blue", rectangle.getColor());
    }
    
    @Test
    void testIndependentClones() {
        Shape clonedCircle = circlePrototype.clone();
        
        circlePrototype.setRadius(20);
        circlePrototype.setColor("blue");
        
        Circle circle = (Circle) clonedCircle;
        assertEquals(10, circle.getRadius());
        assertEquals("red", circle.getColor());
        
        assertEquals(20, circlePrototype.getRadius());
        assertEquals("blue", circlePrototype.getColor());
    }
    
    @Test
    void testPrototypeRegistry() {
        registry.registerPrototype("test-circle", circlePrototype);
        registry.registerPrototype("test-rectangle", rectanglePrototype);
        
        assertEquals(2, registry.size());
        assertTrue(registry.hasPrototype("test-circle"));
        assertTrue(registry.hasPrototype("test-rectangle"));
        assertFalse(registry.hasPrototype("non-existent"));
    }
    
    @Test
    void testGetPrototypeFromRegistry() {
        registry.registerPrototype("test-circle", circlePrototype);
        
        Shape retrievedCircle = registry.getPrototype("test-circle");
        
        assertNotNull(retrievedCircle);
        assertTrue(retrievedCircle instanceof Circle);
        
        Circle circle = (Circle) retrievedCircle;
        assertEquals(10, circle.getRadius());
        assertEquals("red", circle.getColor());
    }
    
    @Test
    void testGetNonExistentPrototype() {
        assertThrows(IllegalArgumentException.class, () -> {
            registry.getPrototype("non-existent");
        });
    }
    
    @Test
    void testRemovePrototype() {
        registry.registerPrototype("test-circle", circlePrototype);
        assertEquals(1, registry.size());
        
        registry.removePrototype("test-circle");
        assertEquals(0, registry.size());
        assertFalse(registry.hasPrototype("test-circle"));
    }
    
    @Test
    void testMultipleClonesFromRegistry() {
        registry.registerPrototype("test-circle", circlePrototype);
        
        Shape clone1 = registry.getPrototype("test-circle");
        Shape clone2 = registry.getPrototype("test-circle");
        
        assertNotNull(clone1);
        assertNotNull(clone2);
        assertNotSame(clone1, clone2);
        
        Circle circle1 = (Circle) clone1;
        Circle circle2 = (Circle) clone2;
        
        assertEquals(circle1.getRadius(), circle2.getRadius());
        assertEquals(circle1.getColor(), circle2.getColor());
    }
    
    @Test
    void testShapeDrawing() {
        assertDoesNotThrow(() -> {
            circlePrototype.draw();
            rectanglePrototype.draw();
        });
    }
    
    @Test
    void testCloneModification() {
        Shape clonedCircle = circlePrototype.clone();
        
        if (clonedCircle instanceof Circle) {
            Circle circle = (Circle) clonedCircle;
            circle.setRadius(30);
            circle.setColor("green");
            
            assertEquals(30, circle.getRadius());
            assertEquals("green", circle.getColor());
            
            assertEquals(10, circlePrototype.getRadius());
            assertEquals("red", circlePrototype.getColor());
        }
    }
} 