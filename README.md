# Design Patterns in Java 🎓

An educational Maven project demonstrating various design patterns in Java with practical, real-world examples.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites) 
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [Available Design Patterns](#available-design-patterns)
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
    │   └── builder/
    └── structural/
        ├── adapter/
        └── bridge/
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

## 🎮 Available Design Patterns

### 🏗️ Creational Patterns

#### 1. Factory Method Pattern
- **Location**: `src/main/java/com/designpatterns/creational/factorymethod/`
- **Example**: RPG Character Creation System
- **Demonstrates**: Object creation without specifying exact classes
- **Key Classes**: `GameCharacter`, `CharacterFactory`, `WarriorFactory`, `MageFactory`, `ArcherFactory`, `RogueFactory`
- **Test**: `FactoryMethodTest`

#### 2. Builder Pattern
- **Location**: `src/main/java/com/designpatterns/creational/builder/`
- **Example**: E-Commerce Product Creation System
- **Demonstrates**: Complex object construction with fluent interface
- **Key Classes**: `Product`, `ProductBuilder`, `StandardProductBuilder`, `PremiumProductBuilder`, `ProductDirector`
- **Test**: `BuilderPatternTest`

### 🔄 Structural Patterns

#### 3. Adapter Pattern
- **Location**: `src/main/java/com/designpatterns/structural/adapter/`
- **Example**: Legacy Payment System Integration
- **Demonstrates**: Bridging incompatible interfaces
- **Key Classes**: `PaymentProcessor`, `LegacyPaymentAdapter`, `LegacyPaymentSystem`, `PaymentService`
- **Test**: `AdapterPatternTest`

#### 4. Bridge Pattern
- **Location**: `src/main/java/com/designpatterns/structural/bridge/`
- **Example**: Cross-Platform Drawing System
- **Demonstrates**: Decoupling abstraction from implementation
- **Key Classes**: `Shape`, `Circle`, `Rectangle`, `Renderer`, `OpenGLRenderer`, `DirectXRenderer`
- **Test**: `BridgePatternTest`

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

```bash
# Factory Method Pattern
mvn test -Dtest=FactoryMethodTest

# Builder Pattern
mvn test -Dtest=BuilderPatternTest

# Adapter Pattern
mvn test -Dtest=AdapterPatternTest

# Bridge Pattern
mvn test -Dtest=BridgePatternTest
```

### **Generate Test Report**

```bash
mvn surefire-report:report
```

Test reports will be available in `target/site/surefire-report.html`

## 🎯 Pattern Demonstrations

### Factory Method Pattern
- Creates different character types (Warrior, Mage, Archer, Rogue) using specialized factories
- Each character has unique abilities and attributes
- Demonstrates polymorphic object creation

### Builder Pattern
- Constructs complex product objects with many optional parameters
- Uses fluent interface for readable object construction
- Includes director for common product configurations
- Supports different product types (Standard, Premium)

### Adapter Pattern
- Integrates legacy payment system with modern payment interface
- Demonstrates transparent translation between incompatible APIs
- Shows enhanced functionality through adapter layer
- Includes comprehensive payment processing and validation

### Bridge Pattern
- Decouples shape abstraction from rendering implementation
- Supports multiple graphics APIs (OpenGL, DirectX) without subclass explosion
- Demonstrates runtime renderer switching
- Shows independent evolution of abstractions and implementations



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
