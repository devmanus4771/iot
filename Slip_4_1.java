// Q.1 Write a Java Program to implement Factory method for Pizza Store with createPizza(),
// orederPizza(), prepare(), Bake(), cut(), box(). Use this to create variety of pizza’s
// like NyStyleCheesePizza, ChicagoStyleCheesePizza etc. 

public class Slip_4_1 {
    
}

/*
 The **Factory Method Pattern** is a creational design pattern that provides an interface for creating objects in a super class, but allows subclasses to alter the type of objects that will be created. This is useful when you want to create objects based on certain conditions or requirements without specifying the exact class of object that will be created.

In this case, we will implement a **Pizza Store** where the store offers different varieties of pizzas such as **New York Style Cheese Pizza** and **Chicago Style Cheese Pizza**.

### **Steps**:
1. Create an abstract class `Pizza` with methods like `prepare()`, `bake()`, `cut()`, and `box()`.
2. Implement concrete classes like `NYStyleCheesePizza` and `ChicagoStyleCheesePizza` that extend `Pizza`.
3. Create a `PizzaStore` class with a `createPizza()` method to instantiate pizzas based on the order type.
4. The `orderPizza()` method in `PizzaStore` will call the `createPizza()` method to prepare the pizza.

### **Java Code:**

#### 1. **Pizza (Abstract Class)**:
```java
abstract class Pizza {
    String name;
    String dough;
    String sauce;
    String cheese;

    // Abstract methods
    public abstract void prepare();
    public abstract void bake();
    public abstract void cut();
    public abstract void box();

    // Method to get the pizza name
    public String getName() {
        return name;
    }

    // Display pizza preparation steps
    public void displayPizzaDetails() {
        System.out.println("Preparing: " + name);
        System.out.println("Dough: " + dough);
        System.out.println("Sauce: " + sauce);
        System.out.println("Cheese: " + cheese);
    }
}
```

#### 2. **Concrete Pizza Classes** (for New York and Chicago styles):

##### **NYStyleCheesePizza**:
```java
class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "New York Style Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        cheese = "Reggiano Cheese";
    }

    @Override
    public void prepare() {
        displayPizzaDetails();
        System.out.println("Preparing New York Style Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking at 450 degrees for 15 minutes...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into slices...");
    }

    @Override
    public void box() {
        System.out.println("Boxing the pizza in a classic New York pizza box...");
    }
}
```

##### **ChicagoStyleCheesePizza**:
```java
class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Thick Crust Dough";
        sauce = "Tomato Sauce";
        cheese = "Mozzarella Cheese";
    }

    @Override
    public void prepare() {
        displayPizzaDetails();
        System.out.println("Preparing Chicago Style Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("Baking at 400 degrees for 30 minutes...");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into square slices...");
    }

    @Override
    public void box() {
        System.out.println("Boxing the pizza in a deep dish box...");
    }
}
```

#### 3. **PizzaStore (Abstract Class)**:
```java
abstract class PizzaStore {

    // Template method to order a pizza
    public Pizza orderPizza(String type) {
        Pizza pizza;

        // Create the pizza using the factory method
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    // Factory method to create a pizza
    protected abstract Pizza createPizza(String type);
}
```

#### 4. **Concrete Pizza Store (NY Style and Chicago Style)**:

##### **NYPizzaStore**:
```java
class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return null;  // Add more pizza types as needed
        }
    }
}
```

##### **ChicagoPizzaStore**:
```java
class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null;  // Add more pizza types as needed
        }
    }
}
```

#### 5. **Main Class (Pizza Ordering System)**:
```java
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        // Order a NY Style Cheese Pizza
        System.out.println("Ordering a New York Style Cheese Pizza:");
        nyStore.orderPizza("cheese");

        System.out.println("\nOrdering a Chicago Style Cheese Pizza:");
        chicagoStore.orderPizza("cheese");
    }
}
```

### **Explanation**:
1. **Pizza (Abstract Class)**:
   - The `Pizza` class contains the common pizza properties and methods such as `prepare()`, `bake()`, `cut()`, and `box()`.
   - The `displayPizzaDetails()` method provides detailed information about the pizza being prepared.

2. **Concrete Pizza Classes (NY and Chicago Style)**:
   - `NYStyleCheesePizza` and `ChicagoStyleCheesePizza` are concrete implementations of the abstract `Pizza` class. They define how to prepare, bake, cut, and box their respective pizzas.

3. **PizzaStore (Abstract Class)**:
   - `PizzaStore` defines the template method `orderPizza()` to handle the common pizza ordering process.
   - The `createPizza()` method is abstract and must be implemented by subclasses to create the specific type of pizza.

4. **Concrete PizzaStore Classes**:
   - `NYPizzaStore` and `ChicagoPizzaStore` extend `PizzaStore` and implement the `createPizza()` method to create specific pizzas based on the input.

5. **PizzaTestDrive**:
   - In the `main()` method, we create instances of `NYPizzaStore` and `ChicagoPizzaStore` and order pizzas using the `orderPizza()` method.

### **Output**:
```
Ordering a New York Style Cheese Pizza:
Preparing: New York Style Cheese Pizza
Dough: Thin Crust Dough
Sauce: Marinara Sauce
Cheese: Reggiano Cheese
Preparing New York Style Pizza...
Baking at 450 degrees for 15 minutes...
Cutting pizza into slices...
Boxing the pizza in a classic New York pizza box...

Ordering a Chicago Style Cheese Pizza:
Preparing: Chicago Style Deep Dish Cheese Pizza
Dough: Thick Crust Dough
Sauce: Tomato Sauce
Cheese: Mozzarella Cheese
Preparing Chicago Style Pizza...
Baking at 400 degrees for 30 minutes...
Cutting pizza into square slices...
Boxing the pizza in a deep dish box...
```

### **Conclusion**:
- This implementation follows the **Factory Method Pattern** where each `PizzaStore` class (NY and Chicago) decides which type of pizza to create via the `createPizza()` method.
- The template method `orderPizza()` defines the steps for preparing a pizza, ensuring consistency while allowing flexibility for different pizza types.
 */
