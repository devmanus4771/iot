// Q.1 Write a java program to implement Adapter pattern to design Heart Model to Beat
// Model 
public class Slip_11_1 {
    
}
/*The **Adapter Pattern** is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two interfaces, allowing them to communicate and work together even if their interfaces are different.

### **Problem**:
We want to implement an adapter pattern where a `HeartModel` has a method `beat()` that simulates a heartbeat, but we want to use the `BeatModel` interface for a different kind of system that also handles a heartbeat-like behavior. The adapter will allow us to use the `HeartModel` in the context of `BeatModel`.

### **Steps to Implement the Adapter Pattern for HeartModel to BeatModel**:

1. **Create the `BeatModel` interface** with the required method `play()`.
2. **Create the `HeartModel` class** with the method `beat()` simulating a heartbeat.
3. **Create an adapter** class that implements the `BeatModel` interface and adapts `HeartModel` to fit the expected behavior.
4. **Test the Adapter** by using `HeartModel` as a `BeatModel`.

### **Java Code Implementation**:

#### 1. Define the `BeatModel` Interface:

This interface represents the expected behavior for any class that simulates a "beat."

```java
public interface BeatModel {
    void play();
}
```

#### 2. Create the `HeartModel` Class:

This class simulates the heartbeat by having a `beat()` method.

```java
public class HeartModel {
    public void beat() {
        System.out.println("Heart is beating...");
    }
}
```

#### 3. Create the `HeartAdapter` Class:

This class adapts the `HeartModel` to the `BeatModel` interface by implementing `BeatModel` and using `HeartModel`'s `beat()` method inside the `play()` method.

```java
public class HeartAdapter implements BeatModel {
    private HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    @Override
    public void play() {
        // Adapt the play method to call the HeartModel's beat method
        heartModel.beat();
    }
}
```

#### 4. Testing the Adapter:

The main program will create an instance of `HeartModel`, adapt it to `BeatModel` using the `HeartAdapter`, and then call the `play()` method, which internally calls `beat()`.

```java
public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create a HeartModel instance
        HeartModel heartModel = new HeartModel();

        // Use the HeartAdapter to adapt HeartModel to BeatModel
        BeatModel heartAdapter = new HeartAdapter(heartModel);

        // Now we can use the BeatModel interface and call play(), which will use beat()
        heartAdapter.play();
    }
}
```

### **Explanation**:

1. **BeatModel Interface**:
   - This interface represents the expected behavior (playing a beat), which requires a `play()` method.

2. **HeartModel Class**:
   - This class has a `beat()` method that simulates a heartbeat. It is not directly compatible with `BeatModel`, but we want to adapt it.

3. **HeartAdapter Class**:
   - This adapter implements `BeatModel` and delegates the `play()` method to `heartModel.beat()`. It allows the `HeartModel` to be used where a `BeatModel` is expected, without modifying the `HeartModel`.

4. **AdapterPatternTest**:
   - This class demonstrates how to use the adapter pattern. It creates a `HeartModel`, adapts it to `BeatModel` via the `HeartAdapter`, and calls the `play()` method.

### **Output**:

```
Heart is beating...
```

### **Benefits of the Adapter Pattern**:
- **Reusability**: The `HeartModel` class can now be used in contexts where `BeatModel` is expected, without changing its implementation.
- **Flexibility**: If more models with different behavior (e.g., `DrumModel`, `MetronomeModel`) need to be added, you can simply create adapters for them to conform to the `BeatModel` interface.
- **Separation of Concerns**: The `HeartAdapter` handles the conversion between `HeartModel` and `BeatModel`, so the two classes don't need to know about each other.

This is an example of how you can apply the **Adapter Pattern** in Java to convert a `HeartModel` into a `BeatModel` for a consistent interface. */