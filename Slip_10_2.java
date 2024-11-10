// Q.2 Write python programs on Pi like:
// a) Print a name 'n' times, where name and n are read from standard input, using for and
// while loops.
// b) Handle Divided by Zero Exception.
// c) Print current time for 10 times with an interval of10seconds.
// d) Read a fileline byline and print the word count of each line 
public class Slip_10_2 {
    
}
/*Here are the Python programs for the tasks you specified:

### **a) Print a name 'n' times, where name and n are read from standard input, using `for` and `while` loops**

```python
# Read the name and the number of times to print
name = input("Enter the name: ")
n = int(input("Enter the number of times to print the name: "))

# Using for loop
print("Using for loop:")
for _ in range(n):
    print(name)

# Using while loop
print("\nUsing while loop:")
count = 0
while count < n:
    print(name)
    count += 1
```

### **b) Handle Divided by Zero Exception**

```python
# Read two numbers from the user
num1 = float(input("Enter the numerator: "))
num2 = float(input("Enter the denominator: "))

try:
    result = num1 / num2
    print(f"The result of division is: {result}")
except ZeroDivisionError:
    print("Error: Cannot divide by zero!")
```

### **c) Print current time for 10 times with an interval of 10 seconds**

```python
import time
from datetime import datetime

# Print current time 10 times with a 10-second interval
for _ in range(10):
    current_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    print(f"Current time: {current_time}")
    time.sleep(10)  # Wait for 10 seconds
```

### **d) Read a file line by line and print the word count of each line**

```python
# Read a file and print word count of each line
filename = input("Enter the filename: ")

try:
    with open(filename, 'r') as file:
        for line_number, line in enumerate(file, start=1):
            words = line.split()  # Split line into words
            word_count = len(words)
            print(f"Line {line_number} - Word count: {word_count}")
except FileNotFoundError:
    print(f"Error: The file '{filename}' was not found.")
```

### **Explanation:**

1. **a)** The program reads a name and a number `n` from the user and prints the name `n` times using both `for` and `while` loops.
   
2. **b)** This program reads two numbers from the user and handles division. If a division by zero occurs, it catches the exception and prints an error message.
   
3. **c)** This program prints the current time 10 times with a 10-second interval. It uses `time.sleep(10)` to pause execution for 10 seconds between each print.

4. **d)** This program reads a file line by line and counts the number of words in each line. It handles the case where the file does not exist by printing an error message.

These Python programs will work on your Raspberry Pi or any other Python environment. */