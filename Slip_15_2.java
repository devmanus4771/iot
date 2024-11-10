// Q.2 Write a program to sense a finger when it is placed on the board Arduino.
public class Slip_15_2 {
    
}
/*To sense when a finger is placed on the board using an Arduino, you can use a **capacitive touch sensor** such as the **TTP223** or similar sensors, which can detect the presence of a finger. When a finger is placed on the sensor, it sends a signal to the Arduino.

### **Components:**
- **Arduino board** (e.g., Arduino Uno)
- **Capacitive Touch Sensor Module** (e.g., TTP223)
- **Jumper wires**

### **Wiring the Sensor:**
1. **VCC** pin of the capacitive touch sensor → **5V** on the Arduino.
2. **GND** pin of the capacitive touch sensor → **GND** on the Arduino.
3. **OUT** pin of the capacitive touch sensor → **Digital Pin 2** on Arduino (for reading the finger touch signal).

### **Arduino Code:**

```cpp
// Define the pin where the touch sensor is connected
const int touchSensorPin = 2;

void setup() {
  // Initialize serial communication at 9600 baudrate
  Serial.begin(9600);
  
  // Set the touch sensor pin as an input
  pinMode(touchSensorPin, INPUT);
}

void loop() {
  // Read the state of the touch sensor
  int sensorState = digitalRead(touchSensorPin);

  // Check if the sensor is being touched
  if (sensorState == HIGH) {
    // Finger is placed on the sensor
    Serial.println("Finger Detected!");
  } else {
    // No finger detected
    Serial.println("No Finger Detected");
  }

  // Delay to avoid too many messages being printed
  delay(500);
}
```

### **Explanation of the Arduino Code:**

1. **Pin Definition**: The `touchSensorPin` is defined as the pin where the touch sensor's **OUT** pin is connected to the Arduino (Pin 2 in this case).
2. **Setup Function**: In the `setup()` function, we initialize serial communication with `Serial.begin(9600)`, which will allow us to monitor the sensor's output through the Arduino IDE's Serial Monitor.
3. **Loop Function**: The `loop()` function constantly reads the state of the touch sensor using `digitalRead(touchSensorPin)`. If a finger is detected (the sensor output goes HIGH), it prints "Finger Detected!" to the Serial Monitor. If no finger is detected, it prints "No Finger Detected".
4. **Delay**: A delay of 500ms is added to prevent the Serial Monitor from printing too many messages in a short time.

### **Expected Output in the Serial Monitor:**

When you place your finger on the sensor, the output will be:
```
Finger Detected!
```

When you remove your finger from the sensor, the output will be:
```
No Finger Detected
```

### **Testing the Program:**
1. Upload the code to your Arduino board.
2. Open the **Serial Monitor** in the Arduino IDE (set the baud rate to 9600).
3. Place your finger on the capacitive touch sensor. The Serial Monitor should print "Finger Detected!" when your finger is on the sensor.
4. Remove your finger, and it should print "No Finger Detected".

This simple program uses a capacitive touch sensor to detect the presence of a finger and print the corresponding message to the Serial Monitor. */