// Q.1 Write a Java Program to implement I/O Decorator for converting uppercase letters to
// lower case letters
public class Slip_20_1 {
    
}
/*To implement an **I/O Decorator** pattern in Java for converting uppercase letters to lowercase letters, we'll use the **Decorator Pattern** to extend the functionality of an existing `Reader` class to convert all uppercase letters to lowercase while reading data.

### Steps:
1. Create a base `Reader` class (or use `InputStreamReader` or `BufferedReader`).
2. Create a `Decorator` class that wraps around the `Reader` and overrides the `read()` method.
3. In the `Decorator`, implement the logic to convert uppercase letters to lowercase.

### Java Code Implementation:

#### 1. **Base Class (Uppercase to Lowercase Decorator)**

```java
import java.io.*;

class UpperCaseToLowerCaseDecorator extends Reader {
    private Reader reader;

    public UpperCaseToLowerCaseDecorator(Reader reader) {
        this.reader = reader;
    }

    @Override
    public int read() throws IOException {
        int character = reader.read();
        if (character == -1) {
            return -1; // End of stream
        }
        return Character.toLowerCase(character); // Convert to lowercase
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
```

#### 2. **Main Class for Testing the Decorator**

```java
import java.io.*;

public class IODecoratorTest {
    public static void main(String[] args) {
        String input = "HELLO WORLD! THIS IS A TEST."; // Example input string

        // Convert the input string into a string reader
        StringReader stringReader = new StringReader(input);

        // Wrap the StringReader with our decorator
        Reader lowerCaseReader = new UpperCaseToLowerCaseDecorator(stringReader);

        try {
            int data;
            while ((data = lowerCaseReader.read()) != -1) {
                System.out.print((char) data); // Print each character after conversion to lowercase
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                lowerCaseReader.close(); // Close the reader
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### Explanation:
1. **UpperCaseToLowerCaseDecorator**: This is the main decorator class. It wraps the `Reader` and overrides the `read()` method to convert any uppercase character to a lowercase character.
2. **IODecoratorTest**: This class demonstrates how the decorator works. It creates a `StringReader` object (to simulate input) and wraps it with `UpperCaseToLowerCaseDecorator`. Then it reads from the decorated reader and prints the converted text (i.e., lowercase).

### Expected Output:
```
hello world! this is a test.
```

### How the Decorator Works:
- The `UpperCaseToLowerCaseDecorator` class acts as a wrapper around a `Reader` object. When data is read from the stream, it converts any uppercase character to a lowercase character using `Character.toLowerCase()`.
- This allows you to easily add more functionality (e.g., logging, filtering, encryption) to any existing `Reader` object without modifying the original class.

This is a simple demonstration of the **Decorator Pattern** in Java applied to I/O streams. */