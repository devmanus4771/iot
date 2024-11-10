// Q.2 Write a program to connect with the available Wi-Fi using Arduino.
public class Slip_16_2 {
    
}
/*To connect an Arduino to a Wi-Fi network, you will need an Arduino board that supports Wi-Fi, such as the **Arduino Uno WiFi**, **Arduino MKR1000**, or an **ESP8266** or **ESP32** module. For this example, we will use an **ESP8266** module, which is a popular and affordable choice for connecting to Wi-Fi.

### **Components Required:**
1. **Arduino (ESP8266 or ESP32)**
2. **Arduino IDE** (with ESP8266/ESP32 board package installed)

### **Steps:**
1. Install the necessary board in the Arduino IDE (if you are using an ESP8266/ESP32).
2. Write a program to connect the ESP8266/ESP32 to a Wi-Fi network.
3. Monitor the connection status in the Serial Monitor.

### **Setup for ESP8266 (Wi-Fi Module)**:
If you're using the **ESP8266** (or **ESP32**), you'll need to select the correct board in the Arduino IDE.

1. **Install ESP8266 Board**: 
   - Open the Arduino IDE.
   - Go to **File** → **Preferences**.
   - In the **Additional Boards Manager URLs** field, add the following URL:
     ```
     http://arduino.esp8266.com/stable/package_esp8266com_index.json
     ```
   - Then go to **Tools** → **Board** → **Boards Manager**, search for **ESP8266**, and install it.

2. **Select the ESP8266 Board**:
   - Go to **Tools** → **Board** → Select **NodeMCU 1.0 (ESP-12E Module)** or the board you are using.

### **Arduino Code to Connect to Wi-Fi**:

```cpp
#include <ESP8266WiFi.h>  // Include the ESP8266 Wi-Fi library

const char* ssid = "your-SSID";        // Your Wi-Fi network name
const char* password = "your-password"; // Your Wi-Fi network password

void setup() {
  // Start the Serial Monitor to debug
  Serial.begin(115200);
  
  // Attempt to connect to Wi-Fi
  Serial.println();
  Serial.println("Connecting to WiFi...");
  
  WiFi.begin(ssid, password); // Begin Wi-Fi connection

  // Wait until connected to Wi-Fi
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
  }

  // Print the IP address once connected
  Serial.println("");
  Serial.println("Connected to WiFi!");
  Serial.print("IP Address: ");
  Serial.println(WiFi.localIP()); // Print the IP address assigned by the router
}

void loop() {
  // You can add any code here to run once connected to Wi-Fi
}
```

### **Explanation of Code**:
1. **Library Inclusion**: The code begins by including the `ESP8266WiFi.h` library, which provides all the necessary functions for working with the Wi-Fi module on the ESP8266.
   
2. **Wi-Fi Credentials**: You will need to set the Wi-Fi credentials (`ssid` and `password`) for the network you wish to connect to.

3. **Wi-Fi Connection**:
   - In the `setup()` function, the `WiFi.begin(ssid, password)` method is called to start the connection.
   - The program enters a `while` loop, repeatedly checking the Wi-Fi connection status with `WiFi.status()`. Once the connection is established (`WiFi.status() == WL_CONNECTED`), it exits the loop.

4. **IP Address**: After connecting, the ESP8266 will display the assigned IP address in the Serial Monitor using `WiFi.localIP()`.

5. **Serial Monitor**: The program uses `Serial.begin(115200)` to initialize serial communication for debugging. You can monitor the connection process by opening the **Serial Monitor** in the Arduino IDE at a baud rate of **115200**.

### **Upload and Monitor**:
1. **Upload** the code to your ESP8266 board.
2. Open the **Serial Monitor** in the Arduino IDE (set the baud rate to **115200**).
3. The program will print **“Connecting to WiFi...”** until it successfully connects to your Wi-Fi network.
4. Once connected, it will print the **IP address** assigned to the ESP8266.

### **Sample Output in the Serial Monitor**:
```
Connecting to WiFi...
.....
Connected to WiFi!
IP Address: 192.168.1.100
```

### **Troubleshooting**:
- If the ESP8266 is not connecting to the Wi-Fi, ensure that the SSID and password are correctly entered.
- Check that your Wi-Fi router is working properly and that the ESP8266 is within range.
- If you're still having issues, verify that the correct board and port are selected in the Arduino IDE.

This program demonstrates how to connect the **ESP8266** to a Wi-Fi network and print the assigned IP address once the connection is established. You can extend this code to connect to a web server, make HTTP requests, or control devices over Wi-Fi. */