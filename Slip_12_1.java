// Q.1 Write a Java Program to implement Decorator Pattern for interface Car to define the
// assemble() method and then decorate it to Sports car and Luxury Car
public class Slip_12_1 {
    
}

/*The **Decorator Pattern** is a structural design pattern that allows behavior to be added to an individual object, dynamically, without affecting the behavior of other objects from the same class. It allows you to extend the functionality of a class by wrapping it in an object of another class that provides the extended behavior.

In this case, we will implement a `Car` interface that defines the method `assemble()`, and we will use decorators to add additional features to the basic car, such as `SportsCar` and `LuxuryCar`.

### **Steps to Implement the Decorator Pattern**:

1. **Create a `Car` interface** with the `assemble()` method.
2. **Create a `BasicCar` class** that implements the `Car` interface and provides a base implementation of the `assemble()` method.
3. **Create abstract decorator class `CarDecorator`** that implements `Car` and holds a reference to a `Car` object.
4. **Create concrete decorators (`SportsCar` and `LuxuryCar`)** that extend `CarDecorator` and add additional features to the car.
5. **Test the implementation** by assembling different types of cars using the decorators.

### **Java Code Implementation**:

#### 1. **Car Interface**:

```java
public interface Car {
    void assemble();
}
```

#### 2. **BasicCar Class**:

This is the base implementation of a car, which can be decorated with additional features.

```java
public class BasicCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Basic Car Assembly");
    }
}
```

#### 3. **CarDecorator Class**:

This is an abstract class that implements `Car` and contains a reference to another `Car` object, allowing it to decorate the base functionality.

```java
public abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    @Override
    public void assemble() {
        this.decoratedCar.assemble(); // Delegate the call to the decorated car
    }
}
```

#### 4. **SportsCar Class** (Concrete Decorator):

This class adds sports car features to the basic car.

```java
public class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        decoratedCar.assemble();  // Assemble the basic car
        addSportsCarFeatures();   // Add sports car features
    }

    private void addSportsCarFeatures() {
        System.out.println("Adding features of Sports Car.");
    }
}
```

#### 5. **LuxuryCar Class** (Concrete Decorator):

This class adds luxury car features to the basic car.

```java
public class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        decoratedCar.assemble();  // Assemble the basic car
        addLuxuryCarFeatures();   // Add luxury car features
    }

    private void addLuxuryCarFeatures() {
        System.out.println("Adding features of Luxury Car.");
    }
}
```

#### 6. **Test the Implementation**:

Now, let's create a `CarTest` class that demonstrates how the decorators can be used.

```java
public class CarTest {
    public static void main(String[] args) {
        // Create a basic car
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();  // Assemble basic car + sports car features

        System.out.println("\n*****");

        // Create a luxury car
        Car sportsLuxuryCar = new LuxuryCar(new SportsCar(new BasicCar()));
        sportsLuxuryCar.assemble();  // Assemble basic car + sports car features + luxury features
    }
}
```

### **Explanation**:

1. **Car Interface**:
   - The `Car` interface defines a single method `assemble()` which is implemented by all car types.

2. **BasicCar Class**:
   - This is the base car class that provides the default implementation of the `assemble()` method, which simply prints `"Basic Car Assembly"`.

3. **CarDecorator Class**:
   - This is an abstract decorator class that holds a reference to a `Car` object, and calls its `assemble()` method. Concrete decorators will extend this class to add additional features.

4. **SportsCar Class**:
   - This is a concrete decorator that adds sports car features to the basic car by calling `addSportsCarFeatures()` after the base car is assembled.

5. **LuxuryCar Class**:
   - This is another concrete decorator that adds luxury car features to the basic car (or any previously decorated car).

6. **CarTest Class**:
   - This class demonstrates how the decorator pattern works. First, it assembles a basic car and then adds sports car features. Then it assembles a car with both sports and luxury features.

### **Output**:

```
Basic Car Assembly
Adding features of Sports Car.

*****
Basic Car Assembly
Adding features of Sports Car.
Adding features of Luxury Car.
```

### **Benefits of the Decorator Pattern**:

- **Extensibility**: We can easily add more features (e.g., `ElectricCar`, `ConvertibleCar`) without changing the existing code.
- **Flexibility**: We can combine multiple decorators to create cars with different combinations of features.
- **Separation of Concerns**: Each decorator adds a specific set of features, keeping each class focused on a single responsibility.

This implementation of the **Decorator Pattern** allows you to extend the functionality of a basic `Car` class dynamically without altering the base class or its subclasses. */
