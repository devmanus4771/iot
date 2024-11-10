// Q.1 Write a Java Program to implement Factory method for Pizza Store with createPizza(),
// orederPizza(), prepare(), Bake(), cut(), box(). Use this to create variety of pizza’s
// like NyStyleCheesePizza, ChicagoStyleCheesePizza etc.
public class Slip_19_1 {
    
}
/*To implement a **Factory Method Pattern** for a Pizza Store in Java, we need to define an abstract pizza class, concrete pizza classes for different types of pizzas (like **New York Style Cheese Pizza** and **Chicago Style Cheese Pizza**), and a pizza store class that uses a factory method to create different kinds of pizzas.

### Components:
1. **Pizza** (Abstract Class): Defines the structure for pizzas with methods like `prepare()`, `bake()`, `cut()`, and `box()`.
2. **Concrete Pizza Classes** (e.g., `NYStyleCheesePizza`, `ChicagoStyleCheesePizza`): These classes implement the specific details of a pizza.
3. **PizzaStore** (Abstract Class): Defines the template method `orderPizza()` which calls the factory method `createPizza()` to create the pizza.
4. **Concrete Pizza Store Classes** (e.g., `NYStylePizzaStore`, `ChicagoStylePizzaStore`): These classes implement the factory method to create specific types of pizzas.

### Step-by-Step Implementation:

#### 1. **Pizza (Abstract Class)**

```java
abstract class Pizza {
    String name;

    public String getName() {
        return name;
    }

    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    public void serve() {
        System.out.println("Serving " + name + " pizza");
    }
}
```

#### 2. **Concrete Pizza Classes**

##### **NYStyleCheesePizza**

```java
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "New York Style Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    @Override
    public void bake() {
        System.out.println("Baking " + name);
    }

    @Override
    public void cut() {
        System.out.println("Cutting " + name);
    }

    @Override
    public void box() {
        System.out.println("Boxing " + name);
    }
}
```

##### **ChicagoStyleCheesePizza**

```java
class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
    }

    @Override
    public void bake() {
        System.out.println("Baking " + name);
    }

    @Override
    public void cut() {
        System.out.println("Cutting " + name);
    }

    @Override
    public void box() {
        System.out.println("Boxing " + name);
    }
}
```

#### 3. **PizzaStore (Abstract Class)**

```java
abstract class PizzaStore {
    // Template Method
    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type); // Factory method to create the pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Factory Method
    protected abstract Pizza createPizza(String type);
}
```

#### 4. **Concrete Pizza Store Classes**

##### **NYStylePizzaStore**

```java
class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        }
        // You can add other pizza types here if needed
        return pizza;
    }
}
```

##### **ChicagoStylePizzaStore**

```java
class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        }
        // You can add other pizza types here if needed
        return pizza;
    }
}
```

#### 5. **Main Class (To Test the Application)**

```java
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        // Ordering a New York Style Cheese Pizza
        System.out.println("Order from New York Store:");
        Pizza nyPizza = nyStore.orderPizza("cheese");
        System.out.println("Ordered: " + nyPizza.getName() + "\n");

        // Ordering a Chicago Style Cheese Pizza
        System.out.println("Order from Chicago Store:");
        Pizza chicagoPizza = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered: " + chicagoPizza.getName() + "\n");
    }
}
```

### **Explanation of the Code**:

1. **Pizza (Abstract Class)**: 
   - This class defines the blueprint for all pizzas with methods like `prepare()`, `bake()`, `cut()`, and `box()`.
   - The `serve()` method is a simple method to serve the pizza after it has been prepared.
   
2. **Concrete Pizza Classes (NYStyleCheesePizza and ChicagoStyleCheesePizza)**: 
   - These classes extend `Pizza` and provide specific implementations for the `prepare()`, `bake()`, `cut()`, and `box()` methods.
   - Each type of pizza has its own unique name and preparation process.

3. **PizzaStore (Abstract Class)**: 
   - This class defines the `orderPizza()` template method which calls the factory method `createPizza()`.
   - The `createPizza()` method is abstract and must be implemented by concrete pizza store classes.

4. **Concrete Pizza Store Classes (NYStylePizzaStore and ChicagoStylePizzaStore)**: 
   - These classes implement the `createPizza()` method to instantiate and return specific types of pizzas.
   - For example, the `NYStylePizzaStore` creates a `NYStyleCheesePizza` when a "cheese" pizza is ordered.

5. **Main Class (PizzaTestDrive)**: 
   - The main method demonstrates ordering pizzas from different pizza stores. It uses the `orderPizza()` method to order pizzas, which internally calls the factory method to create the right pizza based on the type.

### **Expected Output**:

```
Order from New York Store:
Preparing New York Style Cheese Pizza
Baking New York Style Cheese Pizza
Cutting New York Style Cheese Pizza
Boxing New York Style Cheese Pizza
Ordered: New York Style Cheese Pizza

Order from Chicago Store:
Preparing Chicago Style Cheese Pizza
Baking Chicago Style Cheese Pizza
Cutting Chicago Style Cheese Pizza
Boxing Chicago Style Cheese Pizza
Ordered: Chicago Style Cheese Pizza
```

### **Key Concepts of the Factory Method Pattern**:
- The **Factory Method Pattern** allows for the creation of objects without specifying the exact class of object that will be created. In this case, the concrete pizza classes are created dynamically based on the type of pizza the customer orders.
- The `PizzaStore` class defines the template method (`orderPizza()`), and each subclass of `PizzaStore` implements the factory method (`createPizza()`), which is responsible for creating the correct type of pizza.

This design pattern provides flexibility in creating different types of pizzas and can be extended easily to include new pizza types or stores. */