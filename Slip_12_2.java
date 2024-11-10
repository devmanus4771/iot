// Q.2 Write a program to sense the available networks using Arduino
public class Slip_12_2 {
    
}
/*To sense the available networks using Arduino, you would typically use an **ESP8266** or **ESP32** Wi-Fi module, as Arduino boards by themselves don't have the ability to directly detect Wi-Fi networks. These modules can scan for available Wi-Fi networks and report them back to an Arduino or a connected computer.

Here’s how you can write a Java program that interacts with an Arduino to detect Wi-Fi networks, using an **ESP8266** or **ESP32** module.

### **Step 1: Arduino Code for Scanning Available Wi-Fi Networks**

First, upload the following Arduino code to your **ESP8266** or **ESP32**. This code scans for available Wi-Fi networks and sends the results back to the serial monitor.

#### Arduino Code (ESP8266 or ESP32):

```cpp
#include <ESP8266WiFi.h>  // Use #include <WiFi.h> for ESP32

void setup() {
  Serial.begin(115200);  // Start the Serial Monitor at 115200 baud
  WiFi.mode(WIFI_STA);    // Set Wi-Fi mode to Station (client)
  WiFi.disconnect();      // Disconnect from any previous networks
  delay(100);
  
  Serial.println("Scanning for Wi-Fi networks...");

  // Start scanning for Wi-Fi networks
  int numNetworks = WiFi.scanNetworks();

  Serial.println("Scan complete!");
  
  // Display the networks found
  for (int i = 0; i < numNetworks; i++) {
    Serial.print("Network Name: ");
    Serial.print(WiFi.SSID(i));   // Print the network SSID (Name)
    Serial.print(" Signal Strength: ");
    Serial.print(WiFi.RSSI(i));   // Print the signal strength
    Serial.print(" Encryption: ");
    Serial.println(WiFi.encryptionType(i));  // Print encryption type
  }
}

void loop() {
  // No need to do anything in the loop
}
```

This Arduino sketch scans for Wi-Fi networks and prints their SSID (name), signal strength (RSSI), and encryption type to the serial monitor.

### **Step 2: Java Program to Read the Available Networks from Arduino**

Once you have the Arduino code running and your ESP8266 or ESP32 is scanning for networks, you can create a Java program to read the network scan results from the Arduino via the serial port.

#### Java Program to Read Data from Arduino:

This Java program uses the **RXTX** library to communicate with the serial port. You can also use the **JSerialComm** or **javax.comm** libraries, but **RXTX** is one of the most common ones.

##### **Steps to Set Up the RXTX Library in Java:**

1. Download and install the **RXTX** library: [RXTX Library](https://github.com/stanleyseow/rxtx).
2. Add the RXTX JAR file to your Java project classpath.
3. Ensure that the correct **serial port** (the one connected to your ESP8266/ESP32) is used.

Here is the Java program that reads the available networks from the Arduino over the serial port:

#### Java Code:

```java
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class WifiScanner {

    private static SerialPort serialPort;
    private static BufferedReader input;
    private static OutputStream output;

    public static void main(String[] args) {
        try {
            // Get the serial port (use the correct port name for your system)
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("COM3");  // COM3 is a typical port for Windows, change as needed

            if (portId.isCurrentlyOwned()) {
                System.out.println("Error: Port is currently in use");
            } else {
                // Open the port
                serialPort = (SerialPort) portId.open("WifiScanner", 2000);

                // Set port parameters
                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                // Set up the input and output streams
                input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                output = serialPort.getOutputStream();

                // Add event listener for serial data
                serialPort.addEventListener(new SerialDataListener());
                serialPort.notifyOnDataAvailable(true);

                // Wait for the data to be printed to the console
                System.out.println("Waiting for network scan results...");
                Thread.sleep(5000);  // Wait for 5 seconds to ensure the scan is done
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Listener class to read data from Arduino
    private static class SerialDataListener implements SerialPortEventListener {
        public void serialEvent(SerialPortEvent event) {
            if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                try {
                    String inputLine;
                    while ((inputLine = input.readLine()) != null) {
                        System.out.println(inputLine);  // Print the scanned Wi-Fi networks
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### **Explanation:**

1. **Arduino Code**:
   - The Arduino code initializes the Wi-Fi module, starts scanning for available networks, and prints the results (SSID, signal strength, and encryption type) to the serial monitor.

2. **Java Program**:
   - The Java program opens the serial port and listens for incoming data from the Arduino.
   - It reads the Wi-Fi network scan results from the Arduino via the serial connection.
   - The program prints the results in the console.

### **Important Notes**:

- **Serial Port**: Make sure you replace `"COM3"` in the Java program with the correct serial port name for your system. For example:
  - On **Windows**, it might be `"COM3"` or another port.
  - On **Linux**, it might be `"/dev/ttyUSB0"` or similar.
  - On **macOS**, it might be `"/dev/tty.usbserial-XXXXX"`.
  
- **Libraries**: The Java program uses the **RXTX** library to communicate with the serial port. You can also use libraries like **JSerialComm** or **SerialPort** from **javax.comm**, depending on what you have installed.

- **Baud Rate**: Ensure that the baud rate in the Java program matches the baud rate set in the Arduino program (`115200` in this case).

### **Result**:

Once the Java program runs, it will print the list of available Wi-Fi networks scanned by the Arduino over the serial connection. You will see output like this:

```
Waiting for network scan results...
Network Name: MyWiFi SSID Signal Strength: -45 Encryption: 4
Network Name: GuestWiFi SSID Signal Strength: -67 Encryption: 7
...
```

This approach allows you to scan for Wi-Fi networks using an Arduino with an ESP8266 or ESP32 module, and then process and display the results using a Java program. */