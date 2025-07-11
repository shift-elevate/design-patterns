package com.designpatterns.creational.builder.builders;

import com.designpatterns.creational.builder.Product;
import com.designpatterns.creational.builder.products.PremiumProduct;

/**
 * PremiumProductBuilder - Concrete builder for creating PremiumProduct instances
 * This builder extends the base functionality with premium-specific features
 * like warranty and support level
 */
public class PremiumProductBuilder extends ProductBuilder {
    protected int warrantyMonths = 12; // Default warranty
    protected String supportLevel = "Standard"; // Default support level
    
    // Override parent methods to return PremiumProductBuilder for fluent interface
    @Override
    public PremiumProductBuilder setName(String name) {
        super.setName(name);
        return this;
    }
    
    @Override
    public PremiumProductBuilder setPrice(double price) {
        super.setPrice(price);
        return this;
    }
    
    @Override
    public PremiumProductBuilder setDescription(String description) {
        super.setDescription(description);
        return this;
    }
    
    @Override
    public PremiumProductBuilder addTag(String tag) {
        super.addTag(tag);
        return this;
    }
    
    // Additional fluent interface methods for premium features
    public PremiumProductBuilder setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
        return this;
    }
    
    public PremiumProductBuilder setSupportLevel(String supportLevel) {
        this.supportLevel = supportLevel;
        return this;
    }
    
    @Override
    public Product build() {
        validate();
        return new PremiumProduct(name, price, description, tags, 
                                warrantyMonths, supportLevel);
    }
    
    @Override
    public PremiumProductBuilder reset() {
        super.reset();
        this.warrantyMonths = 12;
        this.supportLevel = "Standard";
        return this;
    }
} 