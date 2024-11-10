// Q.2 Write python programs on Pi :
// a) Read your name and print Hello message with name
// b) Read two numbers and print their sum, difference, product and division.
// c) Word and character count of a given string.
// d) Area of a given shape (rectangle, triangle and circle) reading shape and appropriate
// values from standard input.
public class Slip_9_2 {
    
}

/*Here are the Python programs for the tasks specified:

### **a) Read your name and print Hello message with name**
```python
# Read the user's name
name = input("Enter your name: ")

# Print the Hello message
print(f"Hello, {name}!")
```

### **b) Read two numbers and print their sum, difference, product, and division**
```python
# Read two numbers from the user
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Perform and display the calculations
sum_result = num1 + num2
difference = num1 - num2
product = num1 * num2
division = None

if num2 != 0:
    division = num1 / num2
else:
    division = "undefined (cannot divide by zero)"

print(f"Sum: {sum_result}")
print(f"Difference: {difference}")
print(f"Product: {product}")
print(f"Division: {division}")
```

### **c) Word and character count of a given string**
```python
# Read a string from the user
input_string = input("Enter a string: ")

# Calculate word count and character count
word_count = len(input_string.split())
char_count = len(input_string)

print(f"Word count: {word_count}")
print(f"Character count: {char_count}")
```

### **d) Area of a given shape (rectangle, triangle, and circle) reading shape and appropriate values from standard input**
```python
import math

# Read the shape from the user
shape = input("Enter the shape (rectangle, triangle, circle): ").lower()

if shape == "rectangle":
    # Read length and width for rectangle
    length = float(input("Enter the length: "))
    width = float(input("Enter the width: "))
    area = length * width
    print(f"Area of the rectangle: {area}")

elif shape == "triangle":
    # Read base and height for triangle
    base = float(input("Enter the base: "))
    height = float(input("Enter the height: "))
    area = 0.5 * base * height
    print(f"Area of the triangle: {area}")

elif shape == "circle":
    # Read radius for circle
    radius = float(input("Enter the radius: "))
    area = math.pi * radius**2
    print(f"Area of the circle: {area:.2f}")

else:
    print("Invalid shape entered!")
```

### **Explanation:**
1. **a)** The program reads the user's name using the `input()` function and prints a greeting message with that name.
2. **b)** This program reads two floating-point numbers and calculates their sum, difference, product, and division. It handles division by zero to avoid errors.
3. **c)** The program reads a string, counts the number of words (by splitting the string on spaces), and counts the total number of characters in the string.
4. **d)** This program asks the user to enter a shape (rectangle, triangle, or circle). It then reads the necessary dimensions for that shape and calculates the area accordingly.

You can run these programs on a Raspberry Pi or any Python environment. */