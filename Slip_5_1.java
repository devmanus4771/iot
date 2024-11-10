// Q.1 Write a Java Program to implement Adapter pattern for Enumeration iterator
public class Slip_5_1 {
    
}

/* The **Adapter Pattern** is a structural design pattern that allows incompatible interfaces to work together by converting the interface of a class into another interface expected by the client. In this case, we can use the **Adapter Pattern** to convert the `Enumeration` interface into an `Iterator` interface.

In Java, `Enumeration` and `Iterator` are both interfaces used to iterate over collections, but they have different method names and behaviors. The `Enumeration` interface is older, while the `Iterator` interface is more modern and widely used in Java.

The goal here is to create an adapter that allows an `Enumeration` to be used where an `Iterator` is expected. This can be helpful when you are working with an older collection that uses `Enumeration` and need to adapt it to work with more modern code that uses `Iterator`.

### **Steps**:
1. **Enumeration Interface**: The older interface that we want to adapt.
2. **Iterator Interface**: The interface that the client expects.
3. **Adapter Class**: A class that implements the `Iterator` interface but wraps an existing `Enumeration` object and delegates its methods to the `Enumeration` methods.

### **Java Code**:

#### 1. **Enumeration Interface (Older Version)**:
The `Enumeration` interface has two primary methods: `hasMoreElements()` and `nextElement()`.

```java
import java.util.Vector;
import java.util.Enumeration;

public class EnumerationExample {
    public static void main(String[] args) {
        // Creating a Vector with some elements
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Creating an Enumeration to iterate over the Vector
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
```

#### 2. **Iterator Interface (Modern Version)**:
The `Iterator` interface has three main methods: `hasNext()`, `next()`, and `remove()`.

```java
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        // Creating a collection
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Using Iterator to iterate over the List
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

#### 3. **Adapter Class**: This class will convert the `Enumeration` into an `Iterator`.

```java
import java.util.Iterator;
import java.util.Enumeration;

public class EnumerationIteratorAdapter implements Iterator<Object> {
    private Enumeration<Object> enumeration;

    // Constructor to initialize with an Enumeration object
    public EnumerationIteratorAdapter(Enumeration<Object> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();  // Adapting the hasMoreElements() method to hasNext()
    }

    @Override
    public Object next() {
        return enumeration.nextElement();  // Adapting the nextElement() method to next()
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}
```

#### 4. **Using the Adapter in the Main Program**:

```java
import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Creating a Vector and adding some elements
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Creating an Enumeration to iterate over the Vector
        Enumeration<String> enumeration = vector.elements();

        // Using the Adapter to convert Enumeration to Iterator
        Iterator<String> iterator = new EnumerationIteratorAdapter(enumeration);

        // Now we can use Iterator methods
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

### **Explanation**:
1. **EnumerationIteratorAdapter Class**: 
   - This class implements the `Iterator` interface but delegates the `hasNext()` and `next()` methods to the `Enumeration` interface's `hasMoreElements()` and `nextElement()` methods.
   - The `remove()` method is not supported in this case, so an `UnsupportedOperationException` is thrown.

2. **Adapter Usage**:
   - We create an `Enumeration` from a `Vector` and then pass it to the `EnumerationIteratorAdapter`.
   - The adapter allows us to use the `Iterator` interface's methods (`hasNext()` and `next()`) while working with an `Enumeration`.

### **Output**:
```
Apple
Banana
Cherry
```

### **Conclusion**:
- The **Adapter Pattern** is used here to adapt the `Enumeration` interface to the `Iterator` interface, allowing the `Enumeration` to be used in contexts that expect an `Iterator`.
- This pattern provides a flexible solution to make old code work with newer APIs without modifying the existing code structure. */
