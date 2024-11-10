// Q.2 Write a program for LDR to vary the light intensity of LED using
// Arduino.
public class Slip_7_2 {
    
}
/*To create a program for controlling the light intensity of an LED using a Light Dependent Resistor (LDR) with Arduino, you will need to read the LDR's resistance value (which changes based on the light intensity) and use this value to adjust the brightness of the LED.

### **Components Needed**:
- **Arduino** (e.g., Arduino Uno)
- **LDR** (Light Dependent Resistor)
- **LED**
- **10kΩ Resistor** (for LDR)
- **220Ω Resistor** (for LED)
- **Breadboard and Jumper wires**

### **Circuit Diagram**:
1. **LDR Circuit**:
   - Connect one terminal of the LDR to **5V**.
   - Connect the other terminal of the LDR to **A0** (analog pin) and to one side of a **10kΩ resistor**.
   - Connect the other side of the **10kΩ resistor** to **GND**.
   
2. **LED Circuit**:
   - Connect the **longer leg (anode)** of the LED to **pin 9** on the Arduino.
   - Connect the **shorter leg (cathode)** of the LED to **GND** via a **220Ω resistor**.

### **Arduino Code**:

```cpp
// Pin Definitions
int ldrPin = A0;  // LDR connected to analog pin A0
int ledPin = 9;    // LED connected to digital pin 9

void setup() {
  // Start the serial communication
  Serial.begin(9600);

  // Set the LED pin as output
  pinMode(ledPin, OUTPUT);
}

void loop() {
  // Read the LDR value (analog signal)
  int ldrValue = analogRead(ldrPin);
  
  // Map the LDR value (0-1023) to the LED brightness (0-255)
  int ledBrightness = map(ldrValue, 0, 1023, 0, 255);
  
  // Adjust the LED brightness using PWM
  analogWrite(ledPin, ledBrightness);
  
  // Print the LDR value and LED brightness for debugging
  Serial.print("LDR Value: ");
  Serial.print(ldrValue);
  Serial.print("  LED Brightness: ");
  Serial.println(ledBrightness);
  
  // Small delay to make the output readable
  delay(100);
}
```

### **Explanation of Code**:

1. **Pin Setup**:
   - `ldrPin`: The analog pin where the LDR is connected (A0).
   - `ledPin`: The digital pin (9) where the LED is connected.

2. **Reading the LDR Value**:
   - The `analogRead()` function reads the voltage from the LDR and returns a value between `0` (no light) and `1023` (maximum light).
   
3. **Mapping LDR Value to LED Brightness**:
   - The `map()` function is used to scale the LDR value from the range `0-1023` to the range `0-255`, which is the valid range for controlling the brightness of the LED using **PWM** (Pulse Width Modulation).
   
4. **Controlling the LED**:
   - The `analogWrite()` function is used to adjust the brightness of the LED based on the mapped LDR value.

5. **Serial Monitoring**:
   - The `Serial.print()` and `Serial.println()` functions are used for debugging. They print the LDR value and corresponding LED brightness in the Serial Monitor to observe how the LDR's light intensity affects the LED brightness.

### **How It Works**:
- When the LDR is exposed to light, its resistance decreases, allowing more current to flow. This causes the analog read value to increase. The Arduino reads this value and maps it to control the brightness of the LED using PWM.
- When there is more light on the LDR, the LED will become brighter; when there's less light, the LED will dim.

### **Testing**:
- Open the Arduino IDE, upload the code to the Arduino board.
- Open the **Serial Monitor** (set to 9600 baud rate).
- When you change the light intensity falling on the LDR (e.g., by covering it or exposing it to more light), you should see the LED's brightness change accordingly.

This simple setup allows you to vary the LED's brightness in response to the ambient light detected by the LDR. */