// Q.1 Write a Java Program to implement Strategy Pattern for Duck Behavior. Create
// instance variable that holds current state of Duck from there, we just need to handle
// all Flying Behaviors and Quack Behavior
public class Slip_10_1 {
    
}
/*The **Strategy Pattern** is a behavioral design pattern that allows a method to be selected at runtime based on the behavior required. In the case of a **Duck Behavior** scenario, we can define different behaviors for flying and quacking, and these behaviors can be selected and changed dynamically.

### **Steps to Implement the Strategy Pattern for Duck Behavior**

1. **Create Interfaces for Duck Behaviors**:
   - One interface for **FlyingBehavior**.
   - One interface for **QuackBehavior**.

2. **Implement Concrete Classes for Flying and Quacking Behaviors**:
   - Create different concrete implementations of these behaviors, such as flying with wings, flying with a jetpack, and quacking loudly, softly, or not at all.

3. **Create a Duck Class that Uses These Behaviors**:
   - The Duck class will have instances of FlyingBehavior and QuackBehavior, which can be set at runtime.

### **Java Code Implementation**

#### 1. Define the `FlyBehavior` Interface

```java
public interface FlyBehavior {
    void fly();
}
```

#### 2. Implement Concrete Flying Behaviors

```java
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with wings!");
    }
}

public class FlyWithJetpack implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a jetpack!");
    }
}

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
```

#### 3. Define the `QuackBehavior` Interface

```java
public interface QuackBehavior {
    void quack();
}
```

#### 4. Implement Concrete Quacking Behaviors

```java
public class QuackLoudly implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack! Quack!");
    }
}

public class QuackSoftly implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack...");
    }
}

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
```

#### 5. Create the `Duck` Class with Strategy Pattern

The `Duck` class will have the behaviors for flying and quacking. These behaviors can be set dynamically at runtime.

```java
public abstract class Duck {
    // These are the strategy interfaces that will be used for specific behaviors
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    // Duck's behavior is initialized by the constructor or setter methods
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    // Each duck has a display method (to show its type)
    public abstract void display();

    // Delegate flying behavior to the flyBehavior strategy
    public void performFly() {
        flyBehavior.fly();
    }

    // Delegate quacking behavior to the quackBehavior strategy
    public void performQuack() {
        quackBehavior.quack();
    }

    // Duck can swim, so all ducks can swim
    public void swim() {
        System.out.println("All ducks can swim!");
    }

    // Setters to change behaviors dynamically
    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
```

#### 6. Concrete Duck Classes

Now, we can define specific types of ducks that use the behaviors.

```java
public class MallardDuck extends Duck {
    public MallardDuck() {
        super(new FlyWithWings(), new QuackLoudly());
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck!");
    }
}

public class ModelDuck extends Duck {
    public ModelDuck() {
        super(new NoFly(), new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a Model Duck!");
    }
}
```

#### 7. Main Program to Test Strategy Pattern

The main class will create different types of ducks and demonstrate how their behaviors can be changed at runtime.

```java
public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println();

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.performQuack();

        System.out.println("Changing behaviors at runtime...");

        // Changing the behaviors dynamically
        model.setFlyBehavior(new FlyWithJetpack());
        model.setQuackBehavior(new QuackSoftly());

        model.performFly();
        model.performQuack();
    }
}
```

### **Explanation**:

1. **Strategy Interfaces**:
   - `FlyBehavior` and `QuackBehavior` define common interfaces for different behaviors.
   
2. **Concrete Behaviors**:
   - `FlyWithWings`, `FlyWithJetpack`, `NoFly` are concrete implementations of `FlyBehavior`.
   - `QuackLoudly`, `QuackSoftly`, `MuteQuack` are concrete implementations of `QuackBehavior`.

3. **Duck Class**:
   - The `Duck` class is abstract and contains the `FlyBehavior` and `QuackBehavior` strategies. 
   - The `performFly()` and `performQuack()` methods delegate the flying and quacking behavior to the appropriate strategy.

4. **Concrete Duck Classes**:
   - `MallardDuck` and `ModelDuck` are concrete duck classes that use specific flying and quacking behaviors.
   - The behaviors can be changed dynamically using the `setFlyBehavior()` and `setQuackBehavior()` methods.

### **Output Example**:

```
I'm a Mallard Duck!
I'm flying with wings!
Quack! Quack!

I'm a Model Duck!
I can't fly!
<< Silence >>
Changing behaviors at runtime...
I'm flying with a jetpack!
quack...
```

### **Benefits of the Strategy Pattern in This Scenario**:

- **Flexibility**: Duck behavior can be changed dynamically at runtime (for example, from `NoFly` to `FlyWithJetpack`).
- **Separation of Concerns**: Each behavior (flying, quacking) is encapsulated in separate classes, making the system more maintainable and extendable.
- **Extensibility**: New behaviors can be added easily without modifying the existing code, adhering to the Open-Closed Principle.

This is a clear implementation of the **Strategy Pattern** for Duck behaviors in Java. */
