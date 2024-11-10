// Q.2 Run some python programs on Pi like
//  a) Light an LED through Python program
//  b) Get input from two switches and switch on corresponding LEDs
//  c) Flash an LED at a given on time and off time cycle, where the two times are taken
// from a file
public class Slip_11_2 {
    
}
/*Here are the Python programs for your tasks that can be run on a Raspberry Pi:

### **a) Light an LED through Python Program**

For this, we'll use the GPIO library to control the LED on the Raspberry Pi.

#### **Program to Light an LED:**

```python
import RPi.GPIO as GPIO
import time

# Set up the GPIO mode
GPIO.setmode(GPIO.BCM)  # or GPIO.BOARD based on your pin numbering
GPIO.setwarnings(False)

# Define the pin connected to the LED
LED_PIN = 17  # GPIO pin 17 (BCM)

# Set the pin as an output pin
GPIO.setup(LED_PIN, GPIO.OUT)

# Turn on the LED
GPIO.output(LED_PIN, GPIO.HIGH)

# Wait for 5 seconds
time.sleep(5)

# Turn off the LED
GPIO.output(LED_PIN, GPIO.LOW)

# Clean up GPIO setup
GPIO.cleanup()
```

### **b) Get Input from Two Switches and Switch on Corresponding LEDs**

This program reads inputs from two switches (connected to GPIO pins) and switches on corresponding LEDs based on which switch is pressed.

#### **Program for Two Switches and LEDs:**

```python
import RPi.GPIO as GPIO
import time

# Set up the GPIO mode
GPIO.setmode(GPIO.BCM)  # or GPIO.BOARD based on your pin numbering
GPIO.setwarnings(False)

# Define pins for switches and LEDs
SWITCH1_PIN = 17  # GPIO pin 17 for Switch 1
SWITCH2_PIN = 27  # GPIO pin 27 for Switch 2
LED1_PIN = 22     # GPIO pin 22 for LED 1
LED2_PIN = 23     # GPIO pin 23 for LED 2

# Set up the GPIO pins
GPIO.setup(SWITCH1_PIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(SWITCH2_PIN, GPIO.IN, pull_up_down=GPIO.PUD_UP)
GPIO.setup(LED1_PIN, GPIO.OUT)
GPIO.setup(LED2_PIN, GPIO.OUT)

try:
    while True:
        # Check if Switch 1 is pressed
        if GPIO.input(SWITCH1_PIN) == GPIO.LOW:
            GPIO.output(LED1_PIN, GPIO.HIGH)  # Turn on LED 1
        else:
            GPIO.output(LED1_PIN, GPIO.LOW)   # Turn off LED 1

        # Check if Switch 2 is pressed
        if GPIO.input(SWITCH2_PIN) == GPIO.LOW:
            GPIO.output(LED2_PIN, GPIO.HIGH)  # Turn on LED 2
        else:
            GPIO.output(LED2_PIN, GPIO.LOW)   # Turn off LED 2

        time.sleep(0.1)  # Small delay to prevent excessive CPU usage

except KeyboardInterrupt:
    print("Program exited")

finally:
    GPIO.cleanup()
```

In this program:
- **Switches** are connected to GPIO pins 17 and 27.
- **LEDs** are connected to GPIO pins 22 and 23.
- When a switch is pressed (GPIO pin goes LOW), the corresponding LED turns on. Otherwise, the LED is off.

### **c) Flash an LED at a Given On Time and Off Time Cycle, Where the Two Times are Taken from a File**

This program will read a file for the on and off time of an LED, and then flash the LED accordingly.

#### **Program to Flash LED Based on Time from File:**

**Step 1**: Create a file `led_times.txt` with two lines, one for the on-time and one for the off-time, like this:
```
2   # On time in seconds
1   # Off time in seconds
```

**Step 2**: Python program to flash the LED based on the times read from the file.

```python
import RPi.GPIO as GPIO
import time

# Set up the GPIO mode
GPIO.setmode(GPIO.BCM)  # or GPIO.BOARD based on your pin numbering
GPIO.setwarnings(False)

# Define the pin for the LED
LED_PIN = 17  # GPIO pin 17 for the LED

# Set up the GPIO pin
GPIO.setup(LED_PIN, GPIO.OUT)

# Read the on-time and off-time from the file
try:
    with open('led_times.txt', 'r') as file:
        on_time = int(file.readline().strip())  # Read the on-time
        off_time = int(file.readline().strip())  # Read the off-time
except FileNotFoundError:
    print("Error: The file 'led_times.txt' was not found.")
    GPIO.cleanup()
    exit()

# Flash the LED based on the read times
try:
    while True:
        GPIO.output(LED_PIN, GPIO.HIGH)  # Turn on the LED
        time.sleep(on_time)              # Wait for the on-time
        GPIO.output(LED_PIN, GPIO.LOW)   # Turn off the LED
        time.sleep(off_time)             # Wait for the off-time

except KeyboardInterrupt:
    print("Program exited")

finally:
    GPIO.cleanup()
```

### **Explanation:**

1. **LED Lighting (`a`)**:
   - The program uses the Raspberry Pi's GPIO library to control the LED. It turns the LED on for 5 seconds and then turns it off.

2. **Input from Two Switches (`b`)**:
   - This program reads input from two switches connected to GPIO pins 17 and 27. If a switch is pressed (input goes LOW), the corresponding LED is turned on, otherwise, it stays off.

3. **Flashing LED Based on Time from File (`c`)**:
   - This program reads the on-time and off-time from a file `led_times.txt` and uses those values to flash an LED. The LED is turned on for the specified on-time and then turned off for the off-time.

### **Requirements**:
- Ensure that the Raspberry Pi is properly set up with the `RPi.GPIO` library installed (`sudo apt-get install python3-rpi.gpio`).
- Connect your switches and LEDs to the appropriate GPIO pins (refer to the code for pin numbers).
 */