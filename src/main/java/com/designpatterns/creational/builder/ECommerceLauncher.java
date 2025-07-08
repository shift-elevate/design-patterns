package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.builders.StandardProductBuilder;
import com.designpatterns.creational.builder.builders.PremiumProductBuilder;

/**
 * ECommerceLauncher - Client code that demonstrates the Builder pattern
 * This class shows how to use different builders and the director
 * to create complex products with clean, readable code
 */
public class ECommerceLauncher {
    
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo: E-Commerce Product Creation ===\n");
        
        // Direct builder usage - maximum flexibility
        System.out.println("1. Direct Builder Usage:");
        Product laptop = new StandardProductBuilder()
            .setName("Gaming Laptop Pro")
            .setPrice(1299.99)
            .setDescription("High-performance gaming laptop with RTX 4070")
            .addTag("gaming")
            .addTag("laptop")
            .addTag("high-performance")
            .build();
        
        displayProduct(laptop);
        System.out.println();
        
        // Using director for common configurations
        System.out.println("2. Using Director for Common Configurations:");
        ProductDirector director = new ProductDirector();
        
        Product basicMouse = director.createBasicProduct(
            new StandardProductBuilder(), 
            "Wireless Mouse", 
            29.99
        );
        
        displayProduct(basicMouse);
        System.out.println();
        
        Product featuredKeyboard = director.createFeaturedProduct(
            new StandardProductBuilder(),
            "Mechanical Keyboard RGB",
            149.99,
            "Premium mechanical keyboard with RGB lighting"
        );
        
        displayProduct(featuredKeyboard);
        System.out.println();
        
        // Premium product with extended features
        System.out.println("3. Premium Product with Extended Features:");
        Product premiumHeadset = director.createPremiumProduct(
            new PremiumProductBuilder(),
            "Professional Gaming Headset",
            299.99,
            "Premium gaming headset with 7.1 surround sound"
        );
        
        displayProduct(premiumHeadset);
        System.out.println();
        
        // Gaming product configuration
        System.out.println("4. Gaming Product Configuration:");
        Product gamingChair = director.createGamingProduct(
            new StandardProductBuilder(),
            "Ergonomic Gaming Chair",
            399.99,
            "Professional gaming chair with lumbar support"
        );
        
        displayProduct(gamingChair);
        System.out.println();
        
        // Business product for enterprise
        System.out.println("5. Business Product for Enterprise:");
        Product businessMonitor = director.createBusinessProduct(
            new StandardProductBuilder(),
            "4K Business Monitor",
            599.99,
            "Professional 4K monitor for business applications"
        );
        
        displayProduct(businessMonitor);
        System.out.println();
        
        // Demonstrating builder reuse
        System.out.println("6. Builder Reuse:");
        StandardProductBuilder reusableBuilder = new StandardProductBuilder();
        
        Product accessory1 = reusableBuilder
            .setName("USB-C Hub")
            .setPrice(49.99)
            .setDescription("Multi-port USB-C hub")
            .addTag("connectivity")
            .build();
        
        displayProduct(accessory1);
        System.out.println();
        
        // Reset and reuse the same builder
        Product accessory2 = reusableBuilder
            .reset()
            .setName("Wireless Charger")
            .setPrice(39.99)
            .setDescription("Fast wireless charging pad")
            .addTag("wireless")
            .addTag("charging")
            .build();
        
        displayProduct(accessory2);
        
        System.out.println("\n=== Builder Pattern Demo Complete ===");
    }
    
    /**
     * Helper method to display product information
     * Since we simplified the Product interface, we handle display logic here
     */
    private static void displayProduct(Product product) {
        System.out.println("=== " + product.getName() + " ===");
        System.out.println("Price: $" + String.format("%.2f", product.getPrice()));
        System.out.println("Description: " + product.getDescription());
        System.out.println("Tags: " + String.join(", ", product.getTags()));
    }
} 