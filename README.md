# Design Patterns in Java 🎓

An educational Maven project demonstrating various design patterns in Java with practical, real-world examples.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites) 
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [Running Instructions](#running-instructions)
- [Testing](#testing)
- [Contributing](#contributing)

## 🎯 Project Overview

This project serves as an educational resource for learning design patterns through hands-on implementation. Each pattern is demonstrated with:

- ✅ Clear, practical examples
- ✅ Comprehensive documentation
- ✅ Interactive console demonstrations
- ✅ Unit tests
- ✅ Real-world use cases

## 🔧 Prerequisites

- **Java 21** (OpenJDK 21.0.7+)
- **Maven 3.9+**
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installing Java 21

```bash
# Using SDKMAN (recommended)
sdk install java 21.0.7-tem

# For this project only (recommended approach)
# The project includes .sdkmanrc file for automatic environment switching
sdk env

# Or manually switch for this session only
sdk use java 21.0.7-tem

# Verify installation
java --version
```

## 📁 Project Structure

```
design-patterns/
└── src/main/java/com/designpatterns/
    ├── creational/
    │   ├── factorymethod/
    │   ├── abstractfactory/
    │   ├── builder/
    │   └── prototype/
    ├── structural/
    │   ├── adapter/
    │   ├── bridge/
    │   ├── composite/
    │   ├── decorator/
    │   ├── facade/
    │   └── flyweight/
    └── behavioural/
        ├── observer/
        ├── command/
        └── state/
```

**Pattern Organization:**
- Each design pattern has its own dedicated package
- Clean separation between domain objects and creation logic
- Extensible structure for adding new patterns
- Comprehensive test coverage for each pattern

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/shift-elevate/design-patterns.git
cd design-patterns
```

### 2. Setup Environment (Automatic with SDKMAN)

The project includes a `.sdkmanrc` file that automatically configures Java 21 and Maven when you enter the directory:

```bash
# Activate the project environment (Java 21 + Maven)
sdk env

# This will automatically switch to:
# - Java 21.0.7-tem
# - Maven 3.9.10
```

### 3. Build the Project

```bash
mvn clean compile
```

### 4. Run the Main Application

```bash
mvn exec:java -Dexec.mainClass="com.designpatterns.Main"
```

This will launch the main demonstration showing all implemented design patterns.

## 📚 Running Instructions

### 🎯 **Recommended: Run Main Application for Complete Demo**

The best way to see all design patterns in action:

```bash
# Run the main application with all pattern demonstrations
mvn exec:java -Dexec.mainClass="com.designpatterns.Main"

# Or compile and run directly
mvn clean compile
java -cp target/classes com.designpatterns.Main
```

### 📦 **Advanced: Build and Run JAR**

For standalone execution:

```bash
# Build executable JAR
mvn clean package

# Run the JAR
java -jar target/design-patterns-1.0.0.jar
```

### 💻 **IDE Integration**

1. **Import Project**: Import as Maven project in your IDE
2. **Set Java Version**: Ensure Java 21 is configured
3. **Run Main Class**: Execute `com.designpatterns.Main`
4. **Run Tests**: Execute individual test classes for detailed pattern demonstrations

## 🧪 Testing

### **Run All Tests**

```bash
mvn test
```

### **Run Specific Test Class**

#### 🏗️ **Creational Patterns**

```bash
# Factory Method Pattern
mvn test -Dtest=FactoryMethodTest

# Abstract Factory Pattern
mvn test -Dtest=AbstractFactoryTest

# Builder Pattern
mvn test -Dtest=BuilderPatternTest

# Prototype Pattern
mvn test -Dtest=PrototypePatternTest
```

#### 🏛️ **Structural Patterns**

```bash
# Adapter Pattern
mvn test -Dtest=AdapterPatternTest

# Bridge Pattern
mvn test -Dtest=BridgePatternTest

# Composite Pattern
mvn test -Dtest=CompositePatternTest

# Decorator Pattern
mvn test -Dtest=DecoratorPatternTest

# Facade Pattern
mvn test -Dtest=FacadePatternTest

# Flyweight Pattern
mvn test -Dtest=FlyweightPatternTest
```

#### 🎭 **Behavioural Patterns**

```bash
# Observer Pattern
mvn test -Dtest=ObserverPatternTest

# Command Pattern
mvn test -Dtest=CommandPatternTest

# State Pattern
mvn test -Dtest=StatePatternTest
```

## 🚀 Running Launcher Classes

### **Run Specific Launcher Class**

#### 🏗️ **Creational Patterns**

```bash
# Factory Method Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.factorymethod.GameLauncher"

# Abstract Factory Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.abstractfactory.GameLauncher"

# Builder Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.builder.ECommerceLauncher"

# Prototype Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.creational.prototype.PrototypeLauncher"
```

#### 🏛️ **Structural Patterns**

```bash
# Adapter Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.adapter.ECommerceLauncher"

# Bridge Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.bridge.BridgeLauncher"

# Composite Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.composite.CompositeLauncher"

# Decorator Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.decorator.CoffeeShopLauncher"

# Facade Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.facade.CodeEditorClient"

# Flyweight Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.structural.flyweight.FlyweightLauncher"
```

#### 🎭 **Behavioural Patterns**

```bash
# Observer Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.behavioural.observer.ObserverLauncher"

# Command Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.behavioural.command.SmartHomeLauncher"

# State Pattern
mvn exec:java -Dexec.mainClass="com.designpatterns.behavioural.state.DocumentWorkflowLauncher"
```


## 🐛 Troubleshooting

### **Common Issues**

**Java Version Issues**:
```bash
# Check Java version
java --version

# Ensure Java 21 is active
sdk current java
```

**Maven Compilation Issues**:
```bash
# Clean and rebuild
mvn clean compile

# Skip tests if needed
mvn compile -DskipTests
```

**Class Path Issues**:
```bash
# Ensure proper classpath when running
java -cp target/classes com.designpatterns.Main
```

## 📄 License

This project is created for educational purposes. Feel free to use and modify for learning.

---

**Happy Learning! 🚀**

*Remember: Understanding design patterns is about recognizing when and how to apply them, not just memorizing their structure.* 
