package com.designpatterns.structural.decorator;

public class CoffeeShopLauncher {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo: Coffee Shop ===\n");

        System.out.println("1. Simple Coffee Orders:");
        System.out.println("=".repeat(50));
        Coffee simpleCoffee = new SimpleCoffee();
        displayOrder(simpleCoffee);

        Coffee espresso = new Espresso();
        displayOrder(espresso);

        Coffee latte = new Latte();
        displayOrder(latte);
        System.out.println();

        System.out.println("2. Single Decorator Orders:");
        System.out.println("=".repeat(50));
        Coffee coffeeWithVanilla = new VanillaDecorator(new SimpleCoffee());
        displayOrder(coffeeWithVanilla);

        Coffee espressoWithCaramel = new CaramelDecorator(new Espresso());
        displayOrder(espressoWithCaramel);

        Coffee latteWithWhippedCream = new WhippedCreamDecorator(new Latte());
        displayOrder(latteWithWhippedCream);
        System.out.println();

        System.out.println("3. Multiple Decorators (Stacking):");
        System.out.println("=".repeat(50));
        Coffee fancyLatte = new WhippedCreamDecorator(
            new VanillaDecorator(new Latte())
        );
        displayOrder(fancyLatte);

        Coffee ultimateCoffee = new CaramelDecorator(
            new WhippedCreamDecorator(
                new VanillaDecorator(new Espresso())
            )
        );
        displayOrder(ultimateCoffee);
        System.out.println();

        System.out.println("4. Dynamic Order Building:");
        System.out.println("=".repeat(50));
        Coffee customOrder = buildDynamicOrder();
        System.out.println("\nFinal Order:");
        displayOrder(customOrder);
        System.out.println();

        System.out.println("5. Different Combination Possibilities:");
        System.out.println("=".repeat(50));
        demonstrateCombinations();
        System.out.println();

        System.out.println("=".repeat(70));
        System.out.println("Decorator Pattern Benefits Demonstrated:");
        System.out.println("• Add behaviors dynamically without altering structure");
        System.out.println("• Combine decorators in any order");
        System.out.println("• Avoid class explosion (no need for separate classes)");
        System.out.println("• Follow Open/Closed Principle");
        System.out.println("• Flexible and composable design");
        System.out.println("=".repeat(70));
    }

    private static void displayOrder(Coffee coffee) {
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee.getCost()));
        System.out.println();
    }

    private static Coffee buildDynamicOrder() {
        Coffee order = new SimpleCoffee();

        System.out.println("Building custom order step by step:");
        System.out.println("Step 1 - Base: " + order.getDescription() +
                         " ($" + String.format("%.2f", order.getCost()) + ")");

        order = new VanillaDecorator(order);
        System.out.println("Step 2 - Add Vanilla: " + order.getDescription() +
                         " ($" + String.format("%.2f", order.getCost()) + ")");

        order = new CaramelDecorator(order);
        System.out.println("Step 3 - Add Caramel: " + order.getDescription() +
                         " ($" + String.format("%.2f", order.getCost()) + ")");

        order = new WhippedCreamDecorator(order);
        System.out.println("Step 4 - Add Whipped Cream: " + order.getDescription() +
                         " ($" + String.format("%.2f", order.getCost()) + ")");

        return order;
    }

    private static void demonstrateCombinations() {
        Coffee[] orders = {
            new VanillaDecorator(new CaramelDecorator(new SimpleCoffee())),
            new CaramelDecorator(new VanillaDecorator(new SimpleCoffee())),
            new WhippedCreamDecorator(new CaramelDecorator(new VanillaDecorator(new Latte()))),
            new VanillaDecorator(new VanillaDecorator(new Espresso()))
        };

        for (int i = 0; i < orders.length; i++) {
            System.out.println("Combination " + (i + 1) + ": " + orders[i].getDescription());
            System.out.println("Cost: $" + String.format("%.2f", orders[i].getCost()));
            System.out.println();
        }
    }
}
