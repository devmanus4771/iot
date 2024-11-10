// Q.2 Write a program to get temperature notification using Arduino.

public class Slip_6_2 {
    
}
/*To send a temperature notification using Arduino, you would need a **temperature sensor** (such as the **DHT11** or **LM35**) connected to your Arduino. The Arduino will read the temperature and send it to a Java program running on your computer. The Java program can then handle the temperature data and send a notification if the temperature exceeds a certain threshold.

For this solution, we will use the **DHT11** temperature sensor, but you can easily modify the code for other sensors like the **LM35**.

### **Required Components**:
1. **Arduino Board** (e.g., Arduino UNO)
2. **DHT11 Temperature and Humidity Sensor** (or another temperature sensor like LM35)
3. **JDK installed on your computer** (for running the Java program)
4. **Arduino IDE** installed

### **Steps**:
1. **Arduino Code**: This code will read temperature from the DHT11 sensor and send the data via **Serial Communication** to the computer.
2. **Java Code**: The Java program will read the data from the Arduino over the serial port, check the temperature, and send a notification when the temperature exceeds a certain threshold.

### **1. Arduino Code** (Reading Temperature and Sending it Over Serial):
You'll need to install the **DHT sensor library** in the Arduino IDE to interface with the DHT11 sensor. To install it, go to **Sketch** > **Include Library** > **Manage Libraries** and search for `DHT sensor library`, then install it.

Here’s the Arduino code that reads the temperature from the DHT11 sensor and sends it to the serial port.

```cpp
#include <DHT.h>

#define DHTPIN 2      // Pin where the DHT11 sensor is connected
#define DHTTYPE DHT11 // Define the type of DHT sensor

DHT dht(DHTPIN, DHTTYPE); // Create DHT sensor object

void setup() {
  Serial.begin(9600); // Start the serial communication
  dht.begin();        // Initialize the DHT sensor
}

void loop() {
  // Wait a few seconds between readings
  delay(2000); 

  // Reading temperature as Celsius
  float temperature = dht.readTemperature();
  
  // Check if the reading is valid
  if (isnan(temperature)) {
    Serial.println("Failed to read from DHT sensor!");
  } else {
    // Send the temperature to the serial port
    Serial.print("Temperature: ");
    Serial.print(temperature);
    Serial.println(" C");
  }
}
```

### **2. Java Code** (Reading Temperature Data from Serial Port and Sending Notifications):

To communicate with the Arduino over the serial port, we will use the **RXTX** or **JSerialComm** library. For simplicity, we'll use the **JSerialComm** library. To add this library to your Java project, you can download it from [here](https://github.com/Fazecast/jSerialComm) or add it using Maven.

Here is the Java code to read the temperature from the Arduino and send a notification:

#### **Java Code**:

```java
import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class TemperatureNotification {

    public static void main(String[] args) {
        // Set the serial port
        SerialPort comPort = SerialPort.getCommPorts()[0];  // Assuming first available port
        comPort.openPort();
        
        InputStream inputStream = comPort.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        
        // Read data from the Arduino continuously
        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                System.out.println(input); // Display the temperature on the console
                
                // Parse the temperature from the Arduino message
                if (input.contains("Temperature:")) {
                    String tempStr = input.split(":")[1].split("C")[0].trim();
                    float temperature = Float.parseFloat(tempStr);
                    
                    // Check if the temperature exceeds a threshold and send a notification
                    if (temperature > 30) {
                        sendTemperatureNotification(temperature);
                    }
                }
            }
        }
    }

    // Method to send a temperature notification
    public static void sendTemperatureNotification(float temperature) {
        // In this example, we simply print a notification, but this can be modified to trigger
        // real notifications (e.g., email, desktop notification)
        System.out.println("Warning: High Temperature Detected! " + temperature + "C");
    }
}
```

### **Explanation**:
1. **Arduino Code**:
   - The Arduino reads the temperature from the **DHT11** sensor every 2 seconds and sends the value to the **Serial Monitor** in the format: `Temperature: 25.0 C`.
   - The temperature value is sent in Celsius.
   
2. **Java Code**:
   - The Java program opens the **serial port** (assumed to be the first available one).
   - It continuously reads data from the serial port and looks for lines containing "Temperature:".
   - If the temperature exceeds **30°C**, it triggers a simple console notification. This can be extended to show **desktop notifications** or **email alerts** using libraries like **JavaFX** or **JavaMail**.

### **Required Libraries for Java**:
- **JSerialComm Library**: This is used to communicate with the Arduino over the serial port. You can download the JSerialComm library from [here](https://github.com/Fazecast/jSerialComm).
  
  If you are using Maven, you can add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.fazecast</groupId>
    <artifactId>jSerialComm</artifactId>
    <version>2.6.0</version>
</dependency>
```

### **To Run the Program**:
1. **Upload the Arduino Code** to your Arduino board using the Arduino IDE.
2. **Run the Java Program**: Make sure the Arduino is connected to the correct **COM port**. The Java program will listen to the serial port and process the temperature data from the Arduino.

### **Example Output**:

**Console Output (Java Program)**:
```
Temperature: 25.0 C
Temperature: 32.5 C
Warning: High Temperature Detected! 32.5C
Temperature: 29.8 C
Temperature: 34.2 C
Warning: High Temperature Detected! 34.2C
```

### **Conclusion**:
This program reads temperature data from an Arduino board, and when the temperature exceeds a set threshold (e.g., 30°C), it sends a notification. You can further enhance the notification system by integrating with email systems, desktop notifications, or even mobile apps for real-time alerts. */