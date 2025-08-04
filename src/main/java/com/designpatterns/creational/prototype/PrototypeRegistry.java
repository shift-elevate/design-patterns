package com.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private final Map<String, Shape> prototypes = new HashMap<>();

    public void registerPrototype(String key, Shape prototype) {
        prototypes.put(key, prototype);
    }

    public Shape getPrototype(String key) {
        Shape prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }
        return prototype.clone();
    }

    public boolean hasPrototype(String key) {
        return prototypes.containsKey(key);
    }

    public void removePrototype(String key) {
        prototypes.remove(key);
    }

    public int size() {
        return prototypes.size();
    }
} 