// Q.2 Write a program to measure the distance using ultrasonic sensor and make LED blink
// using Arduino.
public class Slip_13_2 {
    
}

/*To measure distance using an ultrasonic sensor (like the **HC-SR04**) and make an LED blink based on the measured distance, follow the steps below. The ultrasonic sensor will measure the distance, and depending on the result, the LED will blink.

### **Components Needed:**

1. **Arduino Board** (e.g., Arduino Uno)
2. **HC-SR04 Ultrasonic Sensor**
   - **VCC** to **5V** pin of Arduino
   - **GND** to **GND** pin of Arduino
   - **TRIG** to any digital pin (e.g., pin 9)
   - **ECHO** to any digital pin (e.g., pin 10)
3. **LED**
   - **Anode (long leg)** to any digital pin (e.g., pin 13)
   - **Cathode (short leg)** to **GND** through a 220-ohm resistor

### **Working:**

- The **HC-SR04** ultrasonic sensor emits sound waves from the **TRIG** pin and receives the reflected waves on the **ECHO** pin.
- Based on the time it takes for the echo to return, the Arduino calculates the distance.
- If the distance is below a certain threshold (e.g., 10 cm), it makes an LED blink.

### **Arduino Code:**

```cpp
// Define pins for ultrasonic sensor and LED
const int trigPin = 9;  // Pin for the TRIG signal
const int echoPin = 10; // Pin for the ECHO signal
const int ledPin = 13;  // Pin for the LED

// Variables to store distance and duration of pulse
long duration;
int distance;

void setup() {
  // Start the serial communication
  Serial.begin(9600);
  
  // Set the pins
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // Clear the TRIG pin by setting it low
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);

  // Send a pulse to the TRIG pin to initiate measurement
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Read the ECHO pin to measure the time it took for the pulse to return
  duration = pulseIn(echoPin, HIGH);

  // Calculate the distance in cm (speed of sound = 34300 cm/s)
  distance = duration * 0.034 / 2;

  // Print the distance to the Serial Monitor
  Serial.print("Distance: ");
  Serial.print(distance);
  Serial.println(" cm");

  // If the distance is less than or equal to 10 cm, blink the LED
  if (distance <= 10) {
    digitalWrite(ledPin, HIGH);  // Turn the LED ON
    delay(500);                  // Wait for 500ms
    digitalWrite(ledPin, LOW);   // Turn the LED OFF
    delay(500);                  // Wait for 500ms
  } else {
    digitalWrite(ledPin, LOW);   // Turn off LED if distance is greater than 10 cm
  }

  // Add a small delay before the next reading
  delay(100);
}
```

### **Explanation:**

1. **Pins Initialization:**
   - The **TRIG** pin is used to trigger the ultrasonic sensor to send out a pulse.
   - The **ECHO** pin reads the time taken for the pulse to travel to the object and back.
   - The **LED** pin controls the LED to blink based on the distance.

2. **Distance Calculation:**
   - The ultrasonic sensor works by emitting a sound pulse and measuring the time it takes for the echo to return. The duration is then converted into distance using the formula:
     \[
     \text{Distance} = \frac{\text{Duration} \times \text{Speed of Sound}}{2}
     \]
     The speed of sound is approximately **34300 cm/s**.

3. **LED Blinking Logic:**
   - If the measured distance is less than or equal to **10 cm**, the LED blinks with a 500 ms ON and 500 ms OFF cycle.
   - If the distance is greater than **10 cm**, the LED remains off.

4. **Serial Output:**
   - The distance is printed to the **Serial Monitor** for real-time feedback.

### **Wiring Diagram:**

- **HC-SR04** Ultrasonic Sensor:
  - **VCC** → 5V on Arduino
  - **GND** → GND on Arduino
  - **TRIG** → Pin 9 on Arduino
  - **ECHO** → Pin 10 on Arduino
- **LED:**
  - **Anode (long leg)** → Pin 13 on Arduino
  - **Cathode (short leg)** → GND through a 220-ohm resistor

### **Output:**

- **Serial Monitor**: It will display the distance measured by the ultrasonic sensor in centimeters (cm).
- **LED Behavior**: The LED will blink when the distance is less than or equal to 10 cm, and will remain off when the distance is greater than 10 cm.

### **Result:**
- When the ultrasonic sensor detects an object within 10 cm, the LED will blink every half second (500ms on and 500ms off).
- The **Serial Monitor** will show the measured distance in cm, helping you track the object’s distance.

This project effectively demonstrates how to use an ultrasonic sensor to measure distance and use that information to control the state of an LED. */