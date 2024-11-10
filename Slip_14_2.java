// Q.2 Write a program to detects the vibration of an object with sensor using Arduino
public class Slip_14_2 {
    
}

/*To detect the vibration of an object using a sensor with Arduino and then send data to a Java program, we can use an **Arduino vibration sensor** (such as the **SW-420 Vibration Sensor Module**) connected to an Arduino board. The vibration sensor detects the presence of vibrations and sends a digital HIGH or LOW signal to the Arduino. We can then send this data to a Java program using **Serial Communication**.

### **Hardware Setup:**

1. **Arduino Board** (e.g., Arduino Uno)
2. **Vibration Sensor** (e.g., SW-420)
3. **Jumper wires** for connections

### **Wiring:**

- **Vibration Sensor**:
  - **VCC** → **5V** on Arduino
  - **GND** → **GND** on Arduino
  - **DO (Digital Output)** → **Pin 2** on Arduino (for detecting vibration)
  
- The **Arduino** will send a signal to a Java program via **Serial Communication**.

### **Arduino Code:**

```cpp
// Define the pin for vibration sensor
const int vibrationSensorPin = 2;

void setup() {
  // Start serial communication
  Serial.begin(9600);

  // Set the vibration sensor pin as input
  pinMode(vibrationSensorPin, INPUT);
}

void loop() {
  // Read the sensor's digital output (HIGH if vibration detected, LOW if not)
  int vibrationState = digitalRead(vibrationSensorPin);

  // Send the vibration state to the serial monitor
  if (vibrationState == HIGH) {
    Serial.println("Vibration Detected!");
  } else {
    Serial.println("No Vibration Detected");
  }

  // Add a small delay for stability
  delay(500);
}
```

### **Explanation of Arduino Code:**

1. **Pin Setup**: The vibration sensor is connected to pin 2 on the Arduino. The `pinMode()` function sets the vibration sensor pin to `INPUT` mode.
2. **Vibration Detection**: In the `loop()`, we continuously check the digital state of the vibration sensor pin using `digitalRead()`. If it detects vibration (sensor output HIGH), it sends `"Vibration Detected!"` to the Serial Monitor. Otherwise, it sends `"No Vibration Detected"`.
3. **Serial Communication**: The data is sent via `Serial.println()` to communicate with the Java program over the serial port.

### **Java Code for Serial Communication:**

In Java, you will need to use a library for serial communication, such as **RXTX** or **JSerialComm**. In this case, I will demonstrate using **JSerialComm** for simplicity.

1. **Add the JSerialComm library**: You can download and add the JSerialComm library to your project [here](https://fazecast.github.io/jSerialComm/).

2. **Java Code**:

```java
import com.fazecast.jSerialComm.SerialPort;

public class VibrationSensorReader {

    public static void main(String[] args) {
        // Open the serial port that Arduino is connected to
        SerialPort chosenPort = SerialPort.getCommPorts()[0]; // Choose the correct port
        chosenPort.openPort();

        try {
            while (true) {
                // Read the data sent from Arduino via Serial
                byte[] readBuffer = new byte[1024];
                int numBytes = chosenPort.readBytes(readBuffer, readBuffer.length);

                // Print the data received from the Arduino
                String data = new String(readBuffer, 0, numBytes);
                System.out.println(data);

                // Delay for a short time before reading again
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the port when done
            chosenPort.closePort();
        }
    }
}
```

### **Explanation of Java Code**:

1. **Serial Communication Setup**: We use `SerialPort.getCommPorts()` to retrieve the available serial ports. The code assumes that the Arduino is connected to the first port (`[0]`), so adjust if necessary.
2. **Reading Data**: The program continuously reads data from the Arduino using `chosenPort.readBytes()`, which reads bytes from the Arduino's serial output.
3. **Displaying Data**: The data received from the Arduino is converted to a string and printed to the console.
4. **Delay**: `Thread.sleep(500)` pauses the loop for 500ms to simulate periodic reading.
5. **Clean-up**: The port is closed when done using `chosenPort.closePort()`.

### **Steps to Run the Program**:

1. **Upload Arduino Code**:
   - Connect your Arduino to your computer via USB.
   - Upload the Arduino code above to the board.
   
2. **Run Java Program**:
   - Install the **JSerialComm** library and make sure it is included in your Java project.
   - Run the Java program, which will listen to the Arduino's serial output and print the vibration status ("Vibration Detected!" or "No Vibration Detected").

### **Expected Output**:

The Java program will display the following output in the console based on the vibration sensor's state:

```
Vibration Detected!
No Vibration Detected
Vibration Detected!
No Vibration Detected
...
```

### **Key Concepts**:

- **Arduino**: Detects vibration using a vibration sensor and sends the status to the Serial Monitor.
- **Java Program**: Reads the data from the Arduino over serial communication using the **JSerialComm** library and displays it.

This setup allows you to detect vibration using a sensor connected to an Arduino and monitor the data on a Java program in real-time. */
