// Q.1 Write a Java Program to implement an Adapter design pattern in mobile charger.
// Define two classes – Volt (to measure volts) and Socket (producing constant volts of
// 120V). Build an adapter that can produce 3 volts, 12 volts and default 120 volts.
// Implements Adapter pattern using Class Adapter
public class Slip_13_1 {
    
}

/*To implement the **Adapter Design Pattern** in the context of a **mobile charger**, we need to define a few classes:

1. **Volt Class**: This class will be used to measure voltage.
2. **Socket Class**: This class will provide a constant output voltage of 120V.
3. **Adapter Class**: This will adapt the output of the `Socket` class to provide 3V, 12V, or the default 120V.
4. **MobileCharger Class**: This class uses the adapter to charge the mobile phone at different voltages.

We will use the **Class Adapter** approach, which uses inheritance to adapt the functionality.

### **Steps to Implement the Adapter Pattern:**

1. **Volt Class**: This will contain the voltage value.
2. **Socket Class**: This class will always provide a constant 120V output.
3. **MobileChargerAdapter Class**: This will extend the `Socket` class and adapt the 120V output to 3V or 12V as needed.
4. **Client Code (MobileCharger)**: This will use the adapter to get the required voltage for charging.

### **Java Code Implementation:**

#### 1. **Volt Class** (Represents the voltage output):

```java
public class Volt {
    private int volts;

    public Volt(int volts) {
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}
```

#### 2. **Socket Class** (Represents a socket that produces 120V):

```java
public class Socket {
    public Volt getVolt() {
        return new Volt(120); // Provides 120 volts by default
    }
}
```

#### 3. **MobileChargerAdapter Class** (Adapts the socket to provide different voltages):

```java
public class MobileChargerAdapter extends Socket {
    private Socket socket;

    public MobileChargerAdapter(Socket socket) {
        this.socket = socket;
    }

    // Adapter method to return 3V
    public Volt get3Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 40);  // 120V/40 = 3V
    }

    // Adapter method to return 12V
    public Volt get12Volt() {
        Volt v = socket.getVolt();
        return convertVolt(v, 10);  // 120V/10 = 12V
    }

    // Default adapter method to return 120V
    public Volt get120Volt() {
        return socket.getVolt();  // Return 120V from Socket
    }

    // Helper method to convert the voltage
    private Volt convertVolt(Volt v, int divider) {
        return new Volt(v.getVolts() / divider);
    }
}
```

#### 4. **MobileCharger Class** (Client code using the adapter):

```java
public class MobileCharger {
    public static void main(String[] args) {
        Socket socket = new Socket();  // A socket providing 120V
        MobileChargerAdapter adapter = new MobileChargerAdapter(socket);

        // Getting the required voltages
        Volt v3 = adapter.get3Volt();
        System.out.println("Mobile charger is getting " + v3.getVolts() + " volts.");

        Volt v12 = adapter.get12Volt();
        System.out.println("Mobile charger is getting " + v12.getVolts() + " volts.");

        Volt v120 = adapter.get120Volt();
        System.out.println("Mobile charger is getting " + v120.getVolts() + " volts.");
    }
}
```

### **Explanation of the Code:**

1. **Volt Class**: This class is used to represent voltage. It has a single property `volts` that stores the voltage level, and getter and setter methods to access it.
  
2. **Socket Class**: This class represents a power socket, which by default provides a constant voltage of **120V**. The `getVolt()` method returns a `Volt` object with a 120V value.

3. **MobileChargerAdapter Class**:
   - This is the adapter class that extends the `Socket` class. It has methods to convert the 120V output from the socket to **3V** and **12V**.
   - It uses a helper method `convertVolt()` to divide the 120V by a given factor to get the desired voltage.
   - The `get3Volt()`, `get12Volt()`, and `get120Volt()` methods adapt the socket’s voltage for different mobile devices.

4. **MobileCharger Class (Client Code)**: 
   - The main method creates an instance of `Socket` and uses the `MobileChargerAdapter` to get voltages of **3V**, **12V**, and **120V**.
   - The client code demonstrates how the adapter is used to retrieve different voltages, which can be used to charge mobile devices with different voltage requirements.

### **Output:**

```
Mobile charger is getting 3 volts.
Mobile charger is getting 12 volts.
Mobile charger is getting 120 volts.
```

### **Benefits of Using the Adapter Pattern:**

- **Reusability**: You can reuse the `Socket` class without modifying it. The adapter class is responsible for adapting the voltage to the required level.
- **Flexibility**: You can add more adapters if needed to support other voltage levels without changing the existing codebase.
- **Extensibility**: New voltage levels can easily be added to the `MobileChargerAdapter` class.
  
This example demonstrates how the Adapter Pattern is used to allow a mobile charger to adapt the voltage from a standard 120V socket to the required voltages (3V, 12V, or 120V). */