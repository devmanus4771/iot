// Q. 2 Write a program to detects the vibration of an object with sensor using Arduino.

/*
 To detect the vibration of an object using a **vibration sensor** (like the **SW-420** vibration sensor) with **Arduino** and read the data using a **Java program**, we need to follow these steps:

### **Components Required:**
1. **Arduino UNO** (or any compatible board)
2. **SW-420 Vibration Sensor Module**
3. **LED** (optional, to indicate vibration detection)
4. **220-ohm Resistor** (for LED)
5. **Breadboard** and **Jumper Wires**

### **Circuit Connections:**
1. **Vibration Sensor (SW-420) Connections**:
   - **VCC** → 5V on Arduino
   - **GND** → GND on Arduino
   - **DO (Digital Output)** → Digital Pin 2 on Arduino
2. **LED (Optional)**:
   - Anode (long leg) → Digital Pin 13 (through a 220-ohm resistor)
   - Cathode (short leg) → GND

### **Step 1: Arduino Code**
Upload this code to your Arduino.

```cpp
const int sensorPin = 2; // Pin connected to vibration sensor
const int ledPin = 13;   // Pin connected to LED (optional)

void setup() {
    pinMode(sensorPin, INPUT); // Set sensor pin as input
    pinMode(ledPin, OUTPUT);   // Set LED pin as output
    Serial.begin(9600);        // Initialize serial communication
}

void loop() {
    int sensorValue = digitalRead(sensorPin); // Read vibration sensor output

    if (sensorValue == HIGH) { // Vibration detected
        digitalWrite(ledPin, HIGH); // Turn on LED (optional)
        Serial.println("Vibration Detected");
    } else {
        digitalWrite(ledPin, LOW); // Turn off LED
        Serial.println("No Vibration");
    }

    delay(100); // Wait for 100 ms before next reading
}
```

### **Explanation (Arduino Code):**
1. **Sensor Reading**:
   - Reads the digital output from the vibration sensor.
   - If the sensor output is `HIGH`, it indicates that vibration is detected.
   - If `LOW`, no vibration is detected.
2. **Serial Communication**:
   - The message "Vibration Detected" or "No Vibration" is sent via the serial port.

### **Step 2: Java Code**
This Java code will read the vibration status from the Arduino via the serial port.

**Dependencies**:
- Use the **jSerialComm** library. You can download it from [jSerialComm GitHub](https://github.com/Fazecast/jSerialComm).

```java
*/
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.util.Scanner;

public class Slip_3_2 {
    public static void main(String[] args) {
        // Find the Arduino Serial Port
        SerialPort arduinoPort = SerialPort.getCommPorts()[0]; // Change index if needed
        arduinoPort.setBaudRate(9600);

        if (arduinoPort.openPort()) {
            System.out.println("Connected to Arduino successfully!");
        } else {
            System.out.println("Failed to connect to Arduino.");
            return;
        }

        // Reading from the Serial Port
        InputStream inputStream = arduinoPort.getInputStream();
        Scanner scanner = new Scanner(inputStream);

        // Reading vibration data
        while (true) {
            try {
                if (scanner.hasNextLine()) {
                    String sensorStatus = scanner.nextLine();

                    if (sensorStatus.contains("Vibration Detected")) {
                        System.out.println("Vibration detected: LED ON");
                    } else if (sensorStatus.contains("No Vibration")) {
                        System.out.println("No Vibration detected: LED OFF");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
/*
```

### **Explanation (Java Code):**
1. **Serial Communication**:
   - The Java program connects to the Arduino via the serial port using the **jSerialComm** library.
   - It reads the status message from the Arduino.
2. **Reading and Displaying Vibration Status**:
   - If "Vibration Detected" is read, it displays that the vibration is detected.
   - If "No Vibration" is read, it indicates no vibration detected.

### **Output:**
```
Connected to Arduino successfully!
No Vibration detected: LED OFF
Vibration detected: LED ON
No Vibration detected: LED OFF
```

### **Additional Notes**:
- **Serial Port**: You may need to adjust the serial port index `[0]` based on your system configuration. Check the Arduino port in your system's device manager.
- **jSerialComm Library**: Place the `jSerialComm.jar` in your Java project's library folder to enable serial communication.

This setup allows you to detect vibrations using the sensor and monitor the status using a Java program that communicates with Arduino via the serial port.
 */