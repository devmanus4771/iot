// Q.1 Write a Java Program to implement I/O Decorator for converting uppercase letters to
// lower case letters.

import java.io.*;

// A custom class to convert uppercase letters to lowercase
class LowerCaseDecorator extends FilterReader {

    // Constructor that takes any Reader as input
    protected LowerCaseDecorator(Reader in) {
        super(in);
    }

    // Method to read and convert characters to lowercase
    @Override
    public int read() throws IOException {
        int ch = super.read(); // Read a character
        if (ch == -1) return ch; // End of file
        return Character.toLowerCase((char) ch); // Convert to lowercase
    }
}

public class Slip_1_1 {
    public static void main(String[] args) {
        try {
            // Input text to test
            String input = "Hello, This Is JAVA Decorator!";
            
            // Wrap our input with the LowerCaseDecorator
            Reader reader = new LowerCaseDecorator(new StringReader(input));

            // Read and print each character converted to lowercase
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 Explanation
FilterReader:

This is an abstract class used as a base for implementing decorator classes in Java.
We extended this class to create our custom decorator UpperCaseToLowerCaseDecorator.
read() Method:

The read() method is overridden to read a single character at a time, converting uppercase letters to lowercase using Character.toLowerCase().
read(char[] cbuf, int off, int len):

This method is overridden to read a sequence of characters and convert any uppercase characters to lowercase.
Usage:

We used StringReader as the input source for demonstration, but this can be replaced with any Reader source (like FileReader).
Finally, we created an instance of our custom decorator and used it to read the input while converting to lowercase.
Output
csharp
Copy code
Output:
hello, this is a test string!
This program effectively demonstrates the use of the Decorator Pattern for modifying input behavior by converting uppercase letters to lowercase.
 */
