// Q.2 Write a program to sense a finger when it is placed on the board Arduino.
public class Slip_4_2 {
    
}
/*
 To sense a finger placed on a board (e.g., **capacitive touch sensor** like **TTP223** or **FDC2214**), we will use an **Arduino** to detect the touch, and a **Java program** to read the data from the Arduino through serial communication.

Here's the solution broken down into two parts:

### **Part 1: Arduino Code**
This part of the code will read input from the **capacitive touch sensor** and send the data over the serial port to the Java program.

#### **Arduino Code**:
```cpp
const int sensorPin = 2; // Pin connected to capacitive touch sensor
const int ledPin = 13;   // Pin connected to LED (optional, for feedback)

void setup() {
    pinMode(sensorPin, INPUT); // Set sensor pin as input
    pinMode(ledPin, OUTPUT);   // Set LED pin as output
    Serial.begin(9600);        // Start serial communication at 9600 baud rate
}

void loop() {
    int sensorValue = digitalRead(sensorPin); // Read sensor value

    if (sensorValue == HIGH) {
        digitalWrite(ledPin, HIGH); // Turn on LED when finger is placed
        Serial.println("Finger Detected"); // Send message to serial port
    } else {
        digitalWrite(ledPin, LOW); // Turn off LED when no finger is placed
        Serial.println("No Finger Detected"); // Send message to serial port
    }

    delay(100); // Wait for 100ms before reading again
}
```

### **Explanation (Arduino Code)**:
- **sensorPin**: This is the digital pin connected to the capacitive touch sensor.
- **ledPin**: A built-in LED connected to pin 13, used for visual feedback.
- **digitalRead(sensorPin)**: Reads the sensor input. If the sensor detects a finger, it returns `HIGH`, and `LOW` if no finger is detected.
- **Serial.println()**: Sends messages over the serial port for Java to read.

### **Part 2: Java Code to Read the Sensor Data**
Now we will write the Java program that will read the serial data from the Arduino and print the output to the console. We'll use the **jSerialComm** library for serial communication.

#### **Java Code**:
```java
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.util.Scanner;

public class FingerSensorReader {
    public static void main(String[] args) {
        // Find the Arduino Serial Port (use appropriate port index)
        SerialPort arduinoPort = SerialPort.getCommPorts()[0]; // Change the index if necessary
        arduinoPort.setBaudRate(9600);  // Set baud rate to match the Arduino baud rate

        // Open the serial port
        if (arduinoPort.openPort()) {
            System.out.println("Connected to Arduino successfully!");
        } else {
            System.out.println("Failed to connect to Arduino.");
            return;
        }

        // Set up the input stream to read from Arduino
        InputStream inputStream = arduinoPort.getInputStream();
        Scanner scanner = new Scanner(inputStream);

        // Continuously read the data from Arduino
        while (true) {
            try {
                if (scanner.hasNextLine()) {
                    String sensorStatus = scanner.nextLine(); // Read sensor data
                    if (sensorStatus.contains("Finger Detected")) {
                        System.out.println("Finger detected on the sensor!");
                    } else if (sensorStatus.contains("No Finger Detected")) {
                        System.out.println("No finger detected.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

### **Explanation (Java Code)**:
- **SerialPort.getCommPorts()**: This method retrieves all available serial ports on your system. Ensure you use the correct index (e.g., `[0]`).
- **arduinoPort.setBaudRate(9600)**: This matches the baud rate used in the Arduino code.
- **InputStream inputStream = arduinoPort.getInputStream()**: Sets up an input stream to receive data from the Arduino.
- **Scanner scanner = new Scanner(inputStream)**: Reads the data from the input stream.
- The program continuously reads the serial data and checks whether a finger is detected based on the Arduino output.

### **Setting Up the Environment**:
1. **Install jSerialComm Library**:
   - You need to add the **jSerialComm** library to your project. You can download it from [jSerialComm GitHub](https://github.com/Fazecast/jSerialComm) or use Maven/Gradle to include it.
   
   Example Maven dependency:
   ```xml
   <dependency>
       <groupId>com.fazecast</groupId>
       <artifactId>jSerialComm</artifactId>
       <version>2.6.0</version>
   </dependency>
   ```

2. **Finding the Serial Port**:
   - In the `SerialPort.getCommPorts()` method, the correct index should be used to match the port to which your Arduino is connected.
   - You can check the port using your system's **Device Manager** (Windows) or dev/tty** (macOS/Linux).

### **Output**:
Once the Arduino and Java programs are running, the Java console will print the message indicating whether a finger is detected on the sensor:

```
Connected to Arduino successfully!
No finger detected.
Finger detected on the sensor!
No finger detected.
Finger detected on the sensor!
```

### **Conclusion**:
This solution involves using an Arduino to detect whether a finger is placed on a capacitive touch sensor, and the status is sent to a Java program via serial communication. The Java program reads the serial data and prints messages indicating whether a finger is detected or not.
 */