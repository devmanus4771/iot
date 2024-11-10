// Q.2 Write a program for LDR to vary the light intensity of LED using Arduino.
public class Slip_18_2 {
    
}
/*To control the intensity of an LED using a Light Dependent Resistor (LDR) with Arduino, the goal is to read the ambient light level from the LDR and adjust the brightness of the LED accordingly. We can do this by using **Pulse Width Modulation (PWM)** to vary the LED's brightness based on the light intensity detected by the LDR.

### **Components Needed**:
1. **Arduino Board** (e.g., Arduino Uno)
2. **LDR (Light Dependent Resistor)**
3. **LED**
4. **10kΩ Resistor** (for the LDR)
5. **220Ω Resistor** (for the LED)
6. **Breadboard**
7. **Jumper wires**

### **Wiring**:
- **LDR**:
  - One terminal of the LDR goes to **5V** (Arduino).
  - The other terminal of the LDR connects to **Analog Pin A0** on the Arduino and to one side of a 10kΩ resistor. The other side of the resistor is connected to **GND** (ground).
  
- **LED**:
  - The anode (long leg) of the LED goes to **Pin 9** on Arduino (PWM pin).
  - The cathode (short leg) of the LED connects to **GND** through a **220Ω resistor**.

### **Code Explanation**:
We will read the value from the LDR using the **analogRead()** function, which will give a value between 0 and 1023 based on the light intensity. Using **analogWrite()**, we will control the LED's brightness by adjusting the PWM signal sent to the LED.

### **Arduino Code**:

```cpp
// Define pin numbers
const int ldrPin = A0; // Pin where LDR is connected
const int ledPin = 9;  // Pin where LED is connected (PWM enabled pin)

void setup() {
  // Initialize the LED pin as an output
  pinMode(ledPin, OUTPUT);
  
  // Start the serial communication for debugging (optional)
  Serial.begin(9600);
}

void loop() {
  // Read the value from the LDR
  int ldrValue = analogRead(ldrPin);
  
  // Map the LDR value (range from 0 to 1023) to a PWM value (range from 0 to 255)
  int ledBrightness = map(ldrValue, 0, 1023, 0, 255);
  
  // Set the LED brightness using PWM
  analogWrite(ledPin, ledBrightness);
  
  // Optional: Print LDR value and LED brightness to the Serial Monitor for debugging
  Serial.print("LDR Value: ");
  Serial.print(ldrValue);
  Serial.print(" | LED Brightness: ");
  Serial.println(ledBrightness);
  
  // Delay for a short period before reading again
  delay(100);
}
```

### **Explanation of the Code**:
1. **Pin Definitions**:
   - `ldrPin`: Analog pin A0, where the LDR is connected.
   - `ledPin`: Digital PWM pin 9, where the LED is connected.

2. **Setup**:
   - We set the `ledPin` as an **OUTPUT** to control the LED.
   - We initialize serial communication to print the LDR and LED values for debugging purposes.

3. **Loop**:
   - `analogRead(ldrPin)` reads the value from the LDR. This returns a value between **0** and **1023**, where **0** indicates complete darkness and **1023** indicates full brightness.
   - `map(ldrValue, 0, 1023, 0, 255)` maps the LDR value (0-1023) to the range suitable for PWM (0-255). This is used to control the LED brightness.
   - `analogWrite(ledPin, ledBrightness)` sets the LED's brightness using PWM based on the mapped value.
   - The **Serial Monitor** displays the current LDR value and the corresponding LED brightness for debugging.

4. **PWM**:
   - The **analogWrite()** function generates a PWM signal to control the LED's brightness. The higher the value (closer to 255), the brighter the LED will be.

### **Expected Behavior**:
- When there is more light falling on the LDR (high ambient light), the resistance of the LDR decreases, which leads to a higher value read by the Arduino (closer to 1023). This will cause the LED to be brighter.
- When the light level decreases (darker conditions), the LDR resistance increases, and the Arduino reads a lower value (closer to 0), causing the LED to dim.

### **Sample Output in Serial Monitor**:
```
LDR Value: 850 | LED Brightness: 209
LDR Value: 780 | LED Brightness: 191
LDR Value: 450 | LED Brightness: 111
LDR Value: 200 | LED Brightness: 49
```

### **Troubleshooting**:
- If the LED doesn't respond correctly, make sure the wiring is correct and that the **PWM pin (pin 9)** is being used for controlling the LED.
- You can adjust the delay if you want the program to update faster or slower.
- Ensure the LDR is placed in a location with varying light levels to see changes in LED brightness.

This program will vary the brightness of the LED based on the ambient light detected by the LDR, making it a basic example of using analog sensors with PWM-controlled outputs. */