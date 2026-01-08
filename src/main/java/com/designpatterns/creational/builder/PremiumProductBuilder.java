package com.designpatterns.creational.builder;

import com.designpatterns.creational.builder.Product;

public class PremiumProductBuilder extends ProductBuilder {
    protected int warrantyMonths = 12;
    protected String supportLevel = "Standard";
    
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