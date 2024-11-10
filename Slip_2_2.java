// Q.2 Write a program to measure the distance using ultrasonic sensor and make LED blink
// using Arduino. 

/*
To measure the distance using an **ultrasonic sensor** (like **HC-SR04**) and control an LED using **Java** and **Arduino**, we can utilize the **Java-Arduino Communication Library** (like **jSerialComm** or **RXTX**). The Java program will communicate with the Arduino via the **serial port** to get the distance measurement and control the LED based on this input.

### Steps:
1. **Write the Arduino Code** to measure distance and send it via the serial port.
2. **Write the Java Code** to read the serial data and control an LED based on the distance.

### Components Required:
1. **Arduino UNO** (or any other Arduino board)
2. **HC-SR04 Ultrasonic Sensor**
3. **LED**
4. **220-ohm Resistor** for LED
5. **Breadboard** and **Jumper Wires**

### **Step 1: Arduino Code**
Upload this code to your Arduino.

```cpp
const int trigPin = 9;
const int echoPin = 10;
const int ledPin = 13;

void setup() {
    Serial.begin(9600);
    pinMode(trigPin, OUTPUT);
    pinMode(echoPin, INPUT);
    pinMode(ledPin, OUTPUT);
}

void loop() {
    long duration;
    int distance;

    // Send a pulse
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    // Measure the pulse duration
    duration = pulseIn(echoPin, HIGH);
    distance = (duration / 2) / 29.1;

    // Send the distance to the Serial Monitor
    Serial.println(distance);

    // Blink LED if the object is closer than 20 cm
    if (distance < 20) {
        digitalWrite(ledPin, HIGH);
    } else {
        digitalWrite(ledPin, LOW);
    }

    delay(100); // Delay before the next measurement
}
```

### **Step 2: Java Code**
This code will read the distance from the Arduino via the serial port and display it.

**Dependencies**:
- Add the **jSerialComm** library to your Java project. You can download it from [jSerialComm GitHub](https://github.com/Fazecast/jSerialComm).

```java */
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.util.Scanner;

public class Slip_2_2 {
    public static void main(String[] args) {
        // Find the Arduino Serial Port
        SerialPort arduinoPort = SerialPort.getCommPorts()[0]; // Change index if multiple ports
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

        // Reading distance and controlling LED
        while (true) {
            try {
                if (scanner.hasNextLine()) {
                    String distanceStr = scanner.nextLine();
                    int distance = Integer.parseInt(distanceStr.trim());

                    System.out.println("Distance: " + distance + " cm");

                    if (distance < 20) {
                        System.out.println("LED Blinking: Object detected within 20 cm.");
                    } else {
                        System.out.println("LED Off: No object within 20 cm.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```
/*
### **Explanation**:
1. **Arduino Code**:
   - Sends the measured distance to the serial port every cycle.
   - Controls an LED based on the distance (on if closer than 20 cm).

2. **Java Code**:
   - Connects to the Arduino via the serial port using **jSerialComm**.
   - Reads the distance value from the serial input.
   - Displays the distance and shows messages based on the distance.

### **Output**:
```
Connected to Arduino successfully!
Distance: 15 cm
LED Blinking: Object detected within 20 cm.
Distance: 25 cm
LED Off: No object within 20 cm.
```

### **Additional Notes**:
- **Serial Port**: You may need to adjust the serial port index `[0]` based on your setup.
- **jSerialComm Library**: Place the `jSerialComm.jar` in your Java project's library folder to enable serial communication.
- **Dependencies**: Add the library to your project using your IDE (e.g., Eclipse, IntelliJ).

This setup allows you to measure the distance using an ultrasonic sensor with Arduino and control the LED via Java. The Java program reads distance measurements and outputs them to the console.


 */