package com.designpatterns.structural.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Composite Pattern Tests")
public class CompositePatternTest {
    
    private Manager ceo;
    private Manager cto;
    private Manager engineeringManager;
    private IndividualContributor dev1;
    private IndividualContributor dev2;
    private IndividualContributor qa;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    
    @BeforeEach
    void setUp() {
        ceo = new Manager("Sarah Johnson", "CEO");
        cto = new Manager("Mike Chen", "CTO");
        engineeringManager = new Manager("Lisa Wang", "Engineering Manager");
        
        dev1 = new IndividualContributor("Alex Smith", "Senior Developer");
        dev2 = new IndividualContributor("Emma Davis", "Developer");
        qa = new IndividualContributor("Tom Wilson", "QA Engineer");
        
        engineeringManager.addSubordinate(dev1);
        engineeringManager.addSubordinate(dev2);
        engineeringManager.addSubordinate(qa);
        cto.addSubordinate(engineeringManager);
        ceo.addSubordinate(cto);
        
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }
    
    @Test
    @DisplayName("Should create organizational hierarchy correctly")
    void testOrganizationalHierarchy() {
        assertEquals(6, ceo.getTeamSize());
        assertEquals(5, cto.getTeamSize());
        assertEquals(4, engineeringManager.getTeamSize());
        assertEquals(1, dev1.getTeamSize());
    }
    
    @Test
    @DisplayName("Should display organizational chart correctly")
    void testDisplayOrganizationalChart() {
        ceo.display(0);
        String output = outputStream.toString();
        
        assertTrue(output.contains("👔 Sarah Johnson (CEO)"));
        assertTrue(output.contains("👔 Mike Chen (CTO)"));
        assertTrue(output.contains("👔 Lisa Wang (Engineering Manager)"));
        assertTrue(output.contains("👤 Alex Smith (Senior Developer)"));
        assertTrue(output.contains("👤 Emma Davis (Developer)"));
        assertTrue(output.contains("👤 Tom Wilson (QA Engineer)"));
    }
    
    @Test
    @DisplayName("Should throw exception when adding subordinate to individual contributor")
    void testIndividualContributorCannotHaveSubordinates() {
        IndividualContributor dev = new IndividualContributor("Test Dev", "Developer");
        IndividualContributor subordinate = new IndividualContributor("Subordinate", "Junior Dev");
        
        assertThrows(UnsupportedOperationException.class, () -> {
            dev.addSubordinate(subordinate);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            dev.removeSubordinate(subordinate);
        });
    }
    
    @Test
    @DisplayName("Should handle empty team correctly")
    void testEmptyTeam() {
        Manager emptyManager = new Manager("Empty Manager", "Manager");
        assertEquals(1, emptyManager.getTeamSize());
        assertTrue(emptyManager.getSubordinates().isEmpty());
    }
    
    @Test
    @DisplayName("Should add and remove subordinates correctly")
    void testAddRemoveSubordinates() {
        Manager manager = new Manager("Test Manager", "Manager");
        IndividualContributor employee = new IndividualContributor("Test Employee", "Employee");
        
        assertEquals(1, manager.getTeamSize());
        
        manager.addSubordinate(employee);
        assertEquals(2, manager.getTeamSize());
        assertEquals(1, manager.getSubordinates().size());
        
        manager.removeSubordinate(employee);
        assertEquals(1, manager.getTeamSize());
        assertEquals(0, manager.getSubordinates().size());
    }
    
    @Test
    @DisplayName("Should get employee information correctly")
    void testEmployeeInformation() {
        assertEquals("Sarah Johnson", ceo.getName());
        assertEquals("CEO", ceo.getTitle());
        
        assertEquals("Alex Smith", dev1.getName());
        assertEquals("Senior Developer", dev1.getTitle());
    }
}
