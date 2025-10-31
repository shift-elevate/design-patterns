package com.designpatterns.structural.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorPatternTest {

    private Coffee simpleCoffee;
    private Coffee espresso;
    private Coffee latte;

    @BeforeEach
    void setUp() {
        simpleCoffee = new SimpleCoffee();
        espresso = new Espresso();
        latte = new Latte();
    }

    // ===========================
    // Base Coffee Tests
    // ===========================

    @Test
    @DisplayName("Should create SimpleCoffee with correct description and cost")
    void testSimpleCoffeeCreation() {
        assertNotNull(simpleCoffee);
        assertEquals("Simple coffee", simpleCoffee.getDescription());
        assertEquals(2.0, simpleCoffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should create Espresso with correct description and cost")
    void testEspressoCreation() {
        assertNotNull(espresso);
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(2.5, espresso.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should create Latte with correct description and cost")
    void testLatteCreation() {
        assertNotNull(latte);
        assertEquals("Latte", latte.getDescription());
        assertEquals(3.0, latte.getCost(), 0.01);
    }

    // ===========================
    // Single Decorator Tests
    // ===========================

    @Test
    @DisplayName("Should add vanilla to SimpleCoffee correctly")
    void testVanillaDecoratorOnSimpleCoffee() {
        Coffee coffeeWithVanilla = new VanillaDecorator(simpleCoffee);

        assertEquals("Simple coffee, vanilla", coffeeWithVanilla.getDescription());
        assertEquals(2.6, coffeeWithVanilla.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should add caramel to Espresso correctly")
    void testCaramelDecoratorOnEspresso() {
        Coffee espressoWithCaramel = new CaramelDecorator(espresso);

        assertEquals("Espresso, caramel", espressoWithCaramel.getDescription());
        assertEquals(3.2, espressoWithCaramel.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should add whipped cream to Latte correctly")
    void testWhippedCreamDecoratorOnLatte() {
        Coffee latteWithWhippedCream = new WhippedCreamDecorator(latte);

        assertEquals("Latte, whipped cream", latteWithWhippedCream.getDescription());
        assertEquals(3.8, latteWithWhippedCream.getCost(), 0.01);
    }

    // ===========================
    // Multiple Decorator Tests (Stacking)
    // ===========================

    @Test
    @DisplayName("Should stack vanilla and whipped cream on SimpleCoffee")
    void testDoubleDecoratorOnSimpleCoffee() {
        Coffee decoratedCoffee = new WhippedCreamDecorator(
            new VanillaDecorator(simpleCoffee)
        );

        assertEquals("Simple coffee, vanilla, whipped cream", decoratedCoffee.getDescription());
        assertEquals(3.4, decoratedCoffee.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should stack vanilla, caramel, and whipped cream on Espresso")
    void testTripleDecoratorOnEspresso() {
        Coffee ultimateEspresso = new WhippedCreamDecorator(
            new CaramelDecorator(
                new VanillaDecorator(espresso)
            )
        );

        assertEquals("Espresso, vanilla, caramel, whipped cream", ultimateEspresso.getDescription());
        assertEquals(4.6, ultimateEspresso.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should stack all three decorators on Latte")
    void testTripleDecoratorOnLatte() {
        Coffee fancyLatte = new CaramelDecorator(
            new WhippedCreamDecorator(
                new VanillaDecorator(latte)
            )
        );

        assertEquals("Latte, vanilla, whipped cream, caramel", fancyLatte.getDescription());
        assertEquals(5.1, fancyLatte.getCost(), 0.01);
    }

    // ===========================
    // Decorator Order Tests
    // ===========================

    @Test
    @DisplayName("Should produce different description order based on decoration order")
    void testDecoratorOrderMatters() {
        Coffee order1 = new VanillaDecorator(new CaramelDecorator(simpleCoffee));
        Coffee order2 = new CaramelDecorator(new VanillaDecorator(simpleCoffee));

        assertEquals("Simple coffee, caramel, vanilla", order1.getDescription());
        assertEquals("Simple coffee, vanilla, caramel", order2.getDescription());

        // Cost should be the same regardless of order
        assertEquals(order1.getCost(), order2.getCost(), 0.01);
        assertEquals(3.3, order1.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should allow same decorator to be applied multiple times")
    void testSameDecoratorMultipleTimes() {
        Coffee doubleVanilla = new VanillaDecorator(new VanillaDecorator(simpleCoffee));

        assertEquals("Simple coffee, vanilla, vanilla", doubleVanilla.getDescription());
        assertEquals(3.2, doubleVanilla.getCost(), 0.01);
    }

    // ===========================
    // All Decorator Combinations
    // ===========================

    @Test
    @DisplayName("Should handle vanilla decorator on all coffee types")
    void testVanillaOnAllCoffeeTypes() {
        Coffee simpleCoffeeWithVanilla = new VanillaDecorator(simpleCoffee);
        Coffee espressoWithVanilla = new VanillaDecorator(espresso);
        Coffee latteWithVanilla = new VanillaDecorator(latte);

        assertEquals(2.6, simpleCoffeeWithVanilla.getCost(), 0.01);
        assertEquals(3.1, espressoWithVanilla.getCost(), 0.01);
        assertEquals(3.6, latteWithVanilla.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should handle caramel decorator on all coffee types")
    void testCaramelOnAllCoffeeTypes() {
        Coffee simpleCoffeeWithCaramel = new CaramelDecorator(simpleCoffee);
        Coffee espressoWithCaramel = new CaramelDecorator(espresso);
        Coffee latteWithCaramel = new CaramelDecorator(latte);

        assertEquals(2.7, simpleCoffeeWithCaramel.getCost(), 0.01);
        assertEquals(3.2, espressoWithCaramel.getCost(), 0.01);
        assertEquals(3.7, latteWithCaramel.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should handle whipped cream decorator on all coffee types")
    void testWhippedCreamOnAllCoffeeTypes() {
        Coffee simpleCoffeeWithWhippedCream = new WhippedCreamDecorator(simpleCoffee);
        Coffee espressoWithWhippedCream = new WhippedCreamDecorator(espresso);
        Coffee latteWithWhippedCream = new WhippedCreamDecorator(latte);

        assertEquals(2.8, simpleCoffeeWithWhippedCream.getCost(), 0.01);
        assertEquals(3.3, espressoWithWhippedCream.getCost(), 0.01);
        assertEquals(3.8, latteWithWhippedCream.getCost(), 0.01);
    }

    // ===========================
    // Complex Combination Tests
    // ===========================

    @Test
    @DisplayName("Should handle complex nested decorators correctly")
    void testComplexNesting() {
        Coffee complexOrder = new CaramelDecorator(
            new VanillaDecorator(
                new WhippedCreamDecorator(
                    new VanillaDecorator(
                        new SimpleCoffee()
                    )
                )
            )
        );

        assertEquals("Simple coffee, vanilla, whipped cream, vanilla, caramel",
                     complexOrder.getDescription());
        // Base: 2.0, Vanilla: 0.6, Whipped Cream: 0.8, Vanilla: 0.6, Caramel: 0.7 = 4.7
        assertEquals(4.7, complexOrder.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should verify decorator follows Coffee interface")
    void testDecoratorImplementsCoffeeInterface() {
        Coffee decorated = new VanillaDecorator(simpleCoffee);

        assertTrue(decorated instanceof Coffee);
        assertTrue(decorated instanceof CoffeeDecorator);
    }

    // ===========================
    // Edge Case Tests
    // ===========================

    @Test
    @DisplayName("Should handle deeply nested decorators")
    void testDeeplyNestedDecorators() {
        Coffee deeplyNested = simpleCoffee;

        for (int i = 0; i < 5; i++) {
            deeplyNested = new VanillaDecorator(deeplyNested);
        }

        String description = deeplyNested.getDescription();
        assertTrue(description.contains("Simple coffee"));
        // Count occurrences of "vanilla" - should be 5
        long vanillaCount = description.chars().filter(ch -> ch == 'v').count();
        assertTrue(vanillaCount >= 5, "Should have at least 5 'v' characters from vanilla");
        // Base: 2.0 + (5 * 0.6) = 5.0
        assertEquals(5.0, deeplyNested.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should maintain immutability of original coffee object")
    void testOriginalCoffeeImmutability() {
        Coffee original = new SimpleCoffee();
        double originalCost = original.getCost();
        String originalDescription = original.getDescription();

        new VanillaDecorator(original);
        new CaramelDecorator(original);

        assertEquals(originalCost, original.getCost(), 0.01);
        assertEquals(originalDescription, original.getDescription());
    }

    // ===========================
    // Dynamic Building Tests
    // ===========================

    @Test
    @DisplayName("Should allow dynamic order building")
    void testDynamicOrderBuilding() {
        Coffee order = new SimpleCoffee();
        assertEquals(2.0, order.getCost(), 0.01);

        order = new VanillaDecorator(order);
        assertEquals(2.6, order.getCost(), 0.01);

        order = new CaramelDecorator(order);
        assertEquals(3.3, order.getCost(), 0.01);

        order = new WhippedCreamDecorator(order);
        assertEquals(4.1, order.getCost(), 0.01);

        assertEquals("Simple coffee, vanilla, caramel, whipped cream", order.getDescription());
    }

    // ===========================
    // Cost Calculation Precision Tests
    // ===========================

    @Test
    @DisplayName("Should calculate total cost correctly for multiple decorators")
    void testCostCalculationAccuracy() {
        // Base: 2.0, Vanilla: 0.6, Caramel: 0.7, Whipped Cream: 0.8
        Coffee order = new WhippedCreamDecorator(
            new CaramelDecorator(
                new VanillaDecorator(
                    new SimpleCoffee()
                )
            )
        );

        double expectedCost = 2.0 + 0.6 + 0.7 + 0.8;
        assertEquals(expectedCost, order.getCost(), 0.01);
        assertEquals(4.1, order.getCost(), 0.01);
    }

    @Test
    @DisplayName("Should verify individual decorator costs")
    void testIndividualDecoratorCosts() {
        Coffee base = new SimpleCoffee();

        Coffee withVanilla = new VanillaDecorator(base);
        assertEquals(0.6, withVanilla.getCost() - base.getCost(), 0.01);

        Coffee withCaramel = new CaramelDecorator(base);
        assertEquals(0.7, withCaramel.getCost() - base.getCost(), 0.01);

        Coffee withWhippedCream = new WhippedCreamDecorator(base);
        assertEquals(0.8, withWhippedCream.getCost() - base.getCost(), 0.01);
    }

    // ===========================
    // Pattern Demonstration Test
    // ===========================

    @Test
    @DisplayName("Should demonstrate decorator pattern benefits")
    void testDecoratorPatternDemo() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("☕ DECORATOR PATTERN DEMONSTRATION");
        System.out.println("=".repeat(60));

        Coffee order1 = new SimpleCoffee();
        System.out.println("Order 1: " + order1.getDescription() + " - $" + order1.getCost());

        Coffee order2 = new VanillaDecorator(new SimpleCoffee());
        System.out.println("Order 2: " + order2.getDescription() + " - $" + order2.getCost());

        Coffee order3 = new WhippedCreamDecorator(new VanillaDecorator(new Latte()));
        System.out.println("Order 3: " + order3.getDescription() + " - $" + order3.getCost());

        Coffee order4 = new CaramelDecorator(
            new WhippedCreamDecorator(
                new VanillaDecorator(new Espresso())
            )
        );
        System.out.println("Order 4: " + order4.getDescription() + " - $" + order4.getCost());

        System.out.println("\n✓ Add behaviors dynamically without altering structure");
        System.out.println("✓ Combine decorators in any order");
        System.out.println("✓ Avoid class explosion");
        System.out.println("✓ Follow Open/Closed Principle");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ DECORATOR PATTERN DEMONSTRATION COMPLETE!");
        System.out.println("=".repeat(60));

        assertNotNull(order1);
        assertNotNull(order2);
        assertNotNull(order3);
        assertNotNull(order4);
    }

    // ===========================
    // Description Format Tests
    // ===========================

    @Test
    @DisplayName("Should format description correctly with commas and spaces")
    void testDescriptionFormatting() {
        Coffee order = new VanillaDecorator(new SimpleCoffee());
        String description = order.getDescription();

        assertTrue(description.contains(", "));
        assertFalse(description.contains(",,"));
        assertFalse(description.startsWith(","));
        assertFalse(description.endsWith(","));
    }

    @Test
    @DisplayName("Should maintain description readability with multiple decorators")
    void testDescriptionReadability() {
        Coffee order = new CaramelDecorator(
            new WhippedCreamDecorator(
                new VanillaDecorator(new Latte())
            )
        );

        String description = order.getDescription();
        assertTrue(description.startsWith("Latte"));
        assertTrue(description.contains("vanilla"));
        assertTrue(description.contains("whipped cream"));
        assertTrue(description.contains("caramel"));
    }
}
