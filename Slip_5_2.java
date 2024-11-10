// Q.2 Write a program to connect with the available Wi-Fi using Arduino.
public class Slip_5_2 {
    
}

/*To connect to an available Wi-Fi network using Arduino, we typically use an **ESP8266** or **ESP32** board. These boards have built-in Wi-Fi capabilities and allow us to easily connect to Wi-Fi networks.

Here’s how to write a program to connect to an available Wi-Fi network using the **ESP8266** or **ESP32** board:

### **Required Components**:
- **ESP8266** or **ESP32** board (e.g., ESP8266 NodeMCU or ESP32 DevKit)
- **Arduino IDE** installed
- **Wi-Fi Network Name (SSID)** and **Password**

### **Steps**:
1. **Install the ESP8266 or ESP32 Board** in Arduino IDE:
   - Go to **File** > **Preferences**, and in the "Additional Boards Manager URLs" field, enter the following URL:
     - For ESP8266: `http://arduino.esp8266.com/stable/package_esp8266com_index.json`
     - For ESP32: `https://dl.espressif.com/dl/package_esp32_index.json`
   - Then, go to **Tools** > **Board** > **Boards Manager** and install the ESP8266 or ESP32 package.

2. **Write the Arduino Code** to connect to Wi-Fi.

### **Code for ESP8266 or ESP32 to Connect to Wi-Fi**:

```cpp
#include <ESP8266WiFi.h>  // For ESP8266
// #include <WiFi.h>        // Uncomment this for ESP32

const char* ssid = "your-SSID";        // Replace with your Wi-Fi network name (SSID)
const char* password = "your-password"; // Replace with your Wi-Fi password

void setup() {
  // Start Serial Monitor for debugging
  Serial.begin(115200); 

  // Connect to Wi-Fi
  Serial.println("Connecting to WiFi...");
  
  // Connect to Wi-Fi network
  WiFi.begin(ssid, password);

  // Wait for connection
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  // Connection successful
  Serial.println();
  Serial.println("Connected to WiFi");
  Serial.print("IP Address: ");
  Serial.println(WiFi.localIP());  // Print the IP address assigned to the ESP
}

void loop() {
  // You can add code here to do tasks once connected
}
```

### **Explanation of the Code**:
- **WiFi.begin(ssid, password)**: This initiates the connection to the specified Wi-Fi network.
- **WiFi.status()**: This method checks the current Wi-Fi connection status. If it returns `WL_CONNECTED`, the device is connected to Wi-Fi.
- **WiFi.localIP()**: After a successful connection, this method will print the IP address assigned to the device by the router.

### **Steps to Upload Code**:
1. Connect your **ESP8266** or **ESP32** board to your computer using a USB cable.
2. Select the correct board and port in the Arduino IDE:
   - For **ESP8266**: Go to **Tools** > **Board** > **NodeMCU 1.0 (ESP-12E Module)** or other ESP8266 variants.
   - For **ESP32**: Go to **Tools** > **Board** > **ESP32 Dev Module**.
   - Select the correct port under **Tools** > **Port**.
3. Click **Upload** to upload the code to your ESP board.
4. Open the **Serial Monitor** (set baud rate to 115200), and you should see messages indicating whether the board has connected to the Wi-Fi or not.

### **Output on Serial Monitor**:
```
Connecting to WiFi...
.....
Connected to WiFi
IP Address: 192.168.1.100
```

### **Conclusion**:
This simple program will allow your ESP8266 or ESP32 to connect to a Wi-Fi network. Once connected, it will display the device’s IP address on the Serial Monitor. You can use this connection to interact with IoT projects, sensors, or control devices over the network. */
