public class Slip_17_1 {
    
}
/*The **Abstract Factory Pattern** is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. In this case, we will create an abstract factory to generate different shapes, like **Circle** and **Rectangle**, without specifying their exact classes.

### Components:
1. **Abstract Factory**: An interface that declares the creation methods for various abstract products.
2. **Concrete Factory**: Implements the abstract factory and creates specific products.
3. **Abstract Product**: An interface that declares a method for drawing shapes.
4. **Concrete Product**: Concrete implementations of the product interface, like **Circle** and **Rectangle**.
5. **Client**: Uses the abstract factory and abstract product classes to create objects without knowing their concrete classes.

### Java Program for Abstract Factory Pattern:

#### 1. **Shape Interface** (Abstract Product):

```java
public interface Shape {
    void draw();
}
```

#### 2. **Concrete Product - Circle**:

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
```

#### 3. **Concrete Product - Rectangle**:

```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
```

#### 4. **Abstract Factory**:

```java
public interface ShapeFactory {
    Shape createShape(String shapeType);
}
```

#### 5. **Concrete Factory - ShapeFactoryImpl**:

```java
public class ShapeFactoryImpl implements ShapeFactory {
    @Override
    public Shape createShape(String shapeType) {
        if(shapeType == null) {
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}
```

#### 6. **Client Code (Main)**:

```java
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactoryImpl();
        
        // Create Circle and call draw
        Shape shape1 = shapeFactory.createShape("CIRCLE");
        shape1.draw();
        
        // Create Rectangle and call draw
        Shape shape2 = shapeFactory.createShape("RECTANGLE");
        shape2.draw();
    }
}
```

### Explanation of the Code:
1. **Shape Interface**: The `Shape` interface defines a `draw()` method that all concrete shape classes must implement.
2. **Concrete Products**: `Circle` and `Rectangle` are concrete classes that implement the `Shape` interface and define the behavior of the `draw()` method for each shape.
3. **Abstract Factory**: `ShapeFactory` is the abstract factory interface that declares the `createShape()` method, which is responsible for creating different shapes.
4. **Concrete Factory**: `ShapeFactoryImpl` is a concrete class that implements the `ShapeFactory` interface. It creates specific objects (Circle or Rectangle) based on the input `shapeType`.
5. **Client**: In the `Main` class, we create an instance of `ShapeFactoryImpl` and use it to create and draw various shapes (Circle and Rectangle).

### Sample Output:

```
Drawing a Circle
Drawing a Rectangle
```

### How It Works:
1. The **Client** asks the **Abstract Factory** to create a shape (`ShapeFactory.createShape()`).
2. The **Concrete Factory** (`ShapeFactoryImpl`) decides which shape to create based on the type passed by the client.
3. The client then calls the `draw()` method on the created shape object to render the shape.

### Benefits of Abstract Factory Pattern:
- **Isolation of Concrete Classes**: The client code does not need to know about the concrete class (`Circle`, `Rectangle`) it is using. It only interacts with the abstract `Shape` interface.
- **Flexibility**: If you want to introduce a new shape, you can easily add it by extending the `Shape` interface and modifying the `ShapeFactory` without changing the client code.
- **Consistency**: You can create families of related products (shapes) with the same interface and ensure that they are used together. */