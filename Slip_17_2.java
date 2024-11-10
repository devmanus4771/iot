// Q.2 Write a program to get temperature notification using Arduino.
public class Slip_17_2 {
    
}
/*To get a temperature notification using Arduino, you need to set up a **temperature sensor** (e.g., **LM35** or **DHT11**) and send the temperature data to the **Serial Monitor** or trigger a notification in the form of a message or LED indication. For this example, we will use an **LM35** temperature sensor, which outputs an analog voltage that can be converted into a temperature value.

### **Components Required:**
1. **Arduino Board** (e.g., Arduino Uno)
2. **LM35 Temperature Sensor**
3. **Jumper wires**
4. **Breadboard** (optional)
5. **Arduino IDE**

### **Steps:**
1. Connect the LM35 sensor to the Arduino.
2. Write a program to read the temperature value from the LM35 sensor.
3. If the temperature exceeds a threshold, send a notification to the **Serial Monitor** or trigger an LED to turn on.

### **Wiring for LM35**:
- **VCC (LM35)** → **5V (Arduino)**
- **GND (LM35)** → **GND (Arduino)**
- **OUT (LM35)** → **A0 (Analog pin 0 of Arduino)**

### **Code for Temperature Monitoring and Notification**:

```cpp
int sensorPin = A0; // Pin where LM35 is connected
int ledPin = 13; // Pin where LED is connected (optional for notification)
float temperature = 0.0; // Variable to store temperature value
float threshold = 30.0; // Set temperature threshold for notification

void setup() {
  // Start Serial communication
  Serial.begin(9600);
  
  // Initialize the LED pin
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // Read the analog value from LM35 sensor
  int sensorValue = analogRead(sensorPin);
  
  // Convert the analog reading to voltage (5V reference)
  float voltage = sensorValue * (5.0 / 1023.0);
  
  // Convert the voltage to temperature (LM35 provides 10mV per degree Celsius)
  temperature = voltage * 100.0; // LM35 gives 10mV per degree
  
  // Print the temperature to the Serial Monitor
  Serial.print("Temperature: ");
  Serial.print(temperature);
  Serial.println(" °C");
  
  // Check if the temperature exceeds the threshold
  if (temperature > threshold) {
    // If the temperature exceeds threshold, turn on the LED (Notification)
    digitalWrite(ledPin, HIGH);
    Serial.println("Temperature exceeds threshold! LED ON");
  } else {
    // If temperature is below threshold, turn off the LED
    digitalWrite(ledPin, LOW);
  }
  
  // Wait for 1 second before reading the temperature again
  delay(1000);
}
```

### **Explanation of the Code**:
1. **Variables**:
   - `sensorPin` is the analog pin to which the LM35 sensor is connected.
   - `ledPin` is the digital pin used to control the LED for temperature notification (pin 13 is typically used for onboard LED).
   - `temperature` stores the temperature reading in Celsius.
   - `threshold` is the temperature value at which the notification is triggered.

2. **Setup**:
   - `Serial.begin(9600)` initializes the Serial Monitor to display temperature values.
   - `pinMode(ledPin, OUTPUT)` sets the LED pin as an output.

3. **Main Logic**:
   - `analogRead(sensorPin)` reads the analog value from the LM35 sensor (0 to 1023).
   - The voltage corresponding to the sensor value is calculated using the formula: `voltage = sensorValue * (5.0 / 1023.0)`.
   - The temperature is then calculated based on the LM35's characteristic (10mV per degree Celsius), hence `temperature = voltage * 100.0`.
   - The temperature is displayed on the **Serial Monitor**.
   - If the temperature exceeds the defined threshold (`30°C`), the LED is turned on as a notification and a message is printed. Otherwise, the LED remains off.

4. **Notification**:
   - If the temperature exceeds the threshold, the LED turns on (indicating a temperature warning), and a message is sent to the Serial Monitor.
   - If the temperature is below the threshold, the LED is turned off, and no message is displayed.

### **Sample Output in the Serial Monitor**:

```
Temperature: 27.50 °C
Temperature: 28.30 °C
Temperature: 30.10 °C
Temperature exceeds threshold! LED ON
Temperature: 29.90 °C
Temperature: 30.50 °C
Temperature exceeds threshold! LED ON
```

### **Troubleshooting**:
- Ensure the LM35 sensor is correctly wired to the Arduino.
- If you are using an external LED, make sure it is connected with a current-limiting resistor (typically 220Ω or 330Ω).
- Adjust the threshold value based on the temperature you want to set for notifications.
- If the Serial Monitor does not show any output, check the baud rate in the Serial Monitor to ensure it matches `9600`.

This program monitors the temperature using the LM35 sensor and notifies when the temperature exceeds a specified threshold by turning on an LED and sending a message to the Serial Monitor. You can customize it further by adding more complex notifications, such as sending messages over a network or triggering alarms. */