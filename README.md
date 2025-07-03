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

- **Java 25** (with preview features enabled)
- **Maven 3.8+**
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installing Java 25

```bash
# Using SDKMAN (recommended)
sdk install java 25.ea.27-open

# For this project only (recommended approach)
# The project includes .sdkmanrc file for automatic environment switching
sdk env

# Or manually switch for this session only
sdk use java 25.ea.27-open

# Verify installation
java --version
```

## 📁 Project Structure

```
design-patterns/
└── src/main/java/com/designpatterns/
    └── creational/
        └── factorymethod/             # Factory Method Pattern
```

**Pattern Organization:**
- Each design pattern has its own dedicated package
- Clean separation between domain objects and creation logic
- Extensible structure for adding new patterns

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd design-patterns
```

### 2. Setup Environment (Automatic with SDKMAN)

The project includes a `.sdkmanrc` file that automatically configures Java 25 and Maven when you enter the directory:

```bash
# Activate the project environment (Java 25 + Maven)
sdk env

# This will automatically switch to:
# - Java 25.ea.27-open
# - Maven 3.9.10
```

### 3. Build the Project

```bash
mvn clean compile
```

### 4. Run the Main Application

```bash
mvn exec:java
```

This will launch the main menu where you can select different design patterns to explore.

## 🎮 Available Design Patterns

### 🏗️ Creational Patterns

#### 1. Factory Method Pattern
- **Example**: RPG Character Creation System
- **Demonstrates**: Object creation without specifying exact classes
- **Best Demo**: Run the tests to see the pattern in action

## 📚 Running Instructions

### 🎯 **Recommended: Run Tests for Best Experience**

The most comprehensive way to see design patterns in action is through our test suite:

```bash
# Run all tests with detailed output
mvn test

# Run specific Factory Method pattern tests
mvn test -Dtest=FactoryMethodTest

# Run specific test method for full demo
mvn test -Dtest=FactoryMethodTest#testFactoryMethodDemo
```

**Expected Output:**
```
=== Character Created for DragonSlayer ===
Warrior swings mighty sword! Dealing 25 damage.
Warrior raises shield, reducing incoming damage by 50%

=== Character Created for Gandalf ===
Mage casts Fireball! Dealing 35 magic damage.
Mage creates magical barrier, absorbing 30 damage
```

### 🚀 **Alternative: Interactive Main Application**

For a menu-driven experience:

```bash
# Compile and run the main application
mvn clean compile exec:java

# Or run with Maven wrapper (if available)
./mvnw clean compile exec:java
```

This launches an interactive menu where you can select different design patterns to explore.

### 📦 **Advanced: Build and Run JAR**

For standalone execution:

```bash
# Build executable JAR
mvn clean package

# Run the JAR with preview features
java --enable-preview -jar target/design-patterns-1.0.0.jar
```

### 💻 **IDE Integration**

1. **Import Project**: Import as Maven project in your IDE
2. **Set Java Version**: Ensure Java 25 is configured
3. **Enable Preview Features**: Add `--enable-preview` to VM options
4. **Run Main Class**: Execute `com.designpatterns.Main`

## 🧪 Testing

### **Run All Tests**

```bash
mvn test
```

### **Run Specific Test Class**

```bash
mvn test -Dtest=FactoryMethodTest
```

### **Generate Test Report**

```bash
mvn surefire-report:report
```

Test reports will be available in `target/site/surefire-report.html`

## 🎯 Expected Output

When you run the tests (`mvn test`), you'll see the design patterns in action with clear demonstrations and explanations of how each pattern works.

## 🛠️ Development Setup

### Adding New Design Patterns

1. **Create Package Structure**:
   ```
   src/main/java/com/designpatterns/{category}/{pattern}/
   ```

2. **Implement Pattern Classes**:
   - Interface/Abstract classes
   - Concrete implementations
   - Demo/Client class

3. **Add to Main Menu**:
   - Update `Main.java` to include new pattern
   - Add execution configuration in `pom.xml`

4. **Write Tests**:
   - Create test class in corresponding test package
   - Test pattern functionality and correctness

## 🐛 Troubleshooting

### **Common Issues**

**Java Version Issues**:
```bash
# Check Java version
java --version

# Ensure Java 25 is active
sdk current java
```

**Maven Compilation Issues**:
```bash
# Clean and rebuild
mvn clean compile

# Skip tests if needed
mvn compile -DskipTests
```

**Preview Features Not Enabled**:
- Ensure `--enable-preview` is in your run configuration
- Check IDE settings for preview feature support

## 📄 License

This project is created for educational purposes. Feel free to use and modify for learning.

---

**Happy Learning! 🚀**

*Remember: Understanding design patterns is about recognizing when and how to apply them, not just memorizing their structure.* 
*Remember: Understanding design patterns is about recognizing when and how to apply them, not just memorizing their structure.* 
