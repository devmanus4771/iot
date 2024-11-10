// Q.1 Write a Java Program to implement Observer Design Pattern for number conversion.
// Accept a number in Decimal form and represent it in Hexadecimal, Octal and Binary.
// Change the Number and it reflects in other forms also
public class Slip_16_1 {
    
}

/*The **Observer Design Pattern** is a behavioral pattern where an object (the "subject") maintains a list of dependent observers that need to be notified whenever the state of the subject changes. In this case, the **Subject** is the number, and the **Observers** are the different representations of the number (Hexadecimal, Octal, and Binary).

### Steps:
1. **Create the Subject** (Number): This will hold the decimal number and notify observers whenever it changes.
2. **Create the Observer Interface**: This will define the `update()` method to reflect changes in the number.
3. **Concrete Observers** (Hexadecimal, Octal, and Binary): Each observer will update its representation of the number when the number changes.
4. **Client Code**: This will allow the user to change the decimal number, and the changes will reflect in the other representations.

### Java Code Implementation:

#### 1. **Observer Interface**:

```java
public interface Observer {
    void update(String number);
}
```

#### 2. **Subject (Number) Class**:

```java
import java.util.ArrayList;
import java.util.List;

public class Number {
    private String number;
    private List<Observer> observers = new ArrayList<>();

    // Add an observer to the list
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove an observer from the list
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify all observers of the change
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.number);
        }
    }

    // Set the new number and notify observers
    public void setNumber(String number) {
        this.number = number;
        notifyObservers();
    }

    public String getNumber() {
        return this.number;
    }
}
```

#### 3. **Concrete Observers**:

- **Hexadecimal Observer**:

```java
public class HexadecimalObserver implements Observer {
    private Number number;

    public HexadecimalObserver(Number number) {
        this.number = number;
        number.addObserver(this);  // Register as an observer
    }

    @Override
    public void update(String number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(Integer.parseInt(number)));
    }
}
```

- **Octal Observer**:

```java
public class OctalObserver implements Observer {
    private Number number;

    public OctalObserver(Number number) {
        this.number = number;
        number.addObserver(this);  // Register as an observer
    }

    @Override
    public void update(String number) {
        System.out.println("Octal: " + Integer.toOctalString(Integer.parseInt(number)));
    }
}
```

- **Binary Observer**:

```java
public class BinaryObserver implements Observer {
    private Number number;

    public BinaryObserver(Number number) {
        this.number = number;
        number.addObserver(this);  // Register as an observer
    }

    @Override
    public void update(String number) {
        System.out.println("Binary: " + Integer.toBinaryString(Integer.parseInt(number)));
    }
}
```

#### 4. **Client Code**:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the Subject (Number)
        Number number = new Number();
        
        // Create the Observers (Hexadecimal, Octal, Binary)
        HexadecimalObserver hexObserver = new HexadecimalObserver(number);
        OctalObserver octObserver = new OctalObserver(number);
        BinaryObserver binObserver = new BinaryObserver(number);

        // Take the initial input for the number
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in Decimal: ");
        String input = scanner.nextLine();
        
        // Set the initial number
        number.setNumber(input);
        
        // Allow the user to change the number and observe the updates
        while (true) {
            System.out.print("\nEnter a new number in Decimal or 'exit' to quit: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            number.setNumber(input);  // Change the number and notify observers
        }

        scanner.close();
    }
}
```

### **Explanation**:

1. **Observer Interface**: The `Observer` interface defines the `update()` method, which will be called when the state of the subject (number) changes.

2. **Number Class**: 
   - The `Number` class is the subject. It maintains a list of observers and notifies them whenever the decimal number changes using the `setNumber()` method. 
   - When the number changes, the `notifyObservers()` method is called to update all observers.

3. **Concrete Observers**:
   - The `HexadecimalObserver`, `OctalObserver`, and `BinaryObserver` implement the `Observer` interface. Each observer will print the number in a different format (Hexadecimal, Octal, Binary) when the number changes.
   - The number is converted to different representations using Java's built-in `Integer.toHexString()`, `Integer.toOctalString()`, and `Integer.toBinaryString()` methods.

4. **Client Code**:
   - The client allows the user to input a decimal number. The number is then converted into hexadecimal, octal, and binary formats and displayed.
   - The user can change the decimal number at any time, and the observers will automatically update to reflect the new number.

### **Sample Output**:

```
Enter a number in Decimal: 10
Hexadecimal: a
Octal: 12
Binary: 1010

Enter a new number in Decimal or 'exit' to quit: 255
Hexadecimal: ff
Octal: 377
Binary: 11111111

Enter a new number in Decimal or 'exit' to quit: 100
Hexadecimal: 64
Octal: 144
Binary: 1100100

Enter a new number in Decimal or 'exit' to quit: exit
```

### **How it Works**:
- Initially, the user enters a decimal number, and all observers (Hexadecimal, Octal, Binary) display the number in their respective formats.
- When the user changes the number, the observers automatically update their output to reflect the new number in all three formats.
- The observers are decoupled from the `Number` class, which makes the design flexible and easy to extend (e.g., adding more representations of the number). */