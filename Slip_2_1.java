// Q.1 Write a Java Program to implement Singleton pattern for multithreading 

class Singleton {
    // Volatile keyword ensures visibility and ordering of changes across threads
    private static volatile Singleton instance = null;

    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // Method to provide the global access point with double-checked locking
    public static Singleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void displayMessage() {
        System.out.println("Singleton instance is running: " + this.hashCode());
    }
}

public class Slip_2_1 {
    public static void main(String[] args) {
        // Creating multiple threads to test Singleton behavior in multithreading
        Runnable task = () -> {
            Singleton singleton = Singleton.getInstance();
            singleton.displayMessage();
        };

        // Starting multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


/*

Explanation:
Volatile Keyword:

The instance is declared as volatile to prevent thread caching issues and ensure that the changes made by one thread are visible to others.
Double-Checked Locking:

First Check: If the instance is already created, it skips the locking for better performance.
Synchronized Block: Ensures that only one thread can create an instance at a time.
Second Check: After acquiring the lock, it checks again to prevent multiple threads from creating instances simultaneously.
Private Constructor:

The constructor is private to restrict the creation of the instance from outside the class.
Global Access Point:

The getInstance() method provides a global access point to get the Singleton instance.
Thread Creation:

We create multiple threads (thread1, thread2, thread3) and start them to test the Singleton's behavior.
Output:
arduino
Copy code
Singleton Instance Created
Singleton instance is running: 12345678
Singleton instance is running: 12345678
Singleton instance is running: 12345678
In the output, you can see that the "Singleton Instance Created" message is printed only once, and all threads access the same Singleton instance (same hash code).

Why Use Double-Checked Locking?
It reduces the overhead of acquiring a lock every time getInstance() is called.
It ensures that only one instance of the Singleton class is created even when multiple threads try to access it simultaneously.
This approach is efficient and thread-safe, making it a popular way to implement the Singleton pattern in Java for multithreading scenarios.

*/
