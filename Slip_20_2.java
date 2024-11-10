// Q.2 Write python programs on Pi like:
// a) Read your name and print Hello message with name
// b) Read two numbers and print their sum, difference, product and division.
// c) Word and character count of a given string.
// d) Area of a given shape (rectangle, triangle and circle) reading shape and appropriate
// values from standard input.

public class Slip_20_2 {
    
}

/*Here are the Python programs for each of the tasks you specified, which can be executed on a Raspberry Pi:

### a) Read your name and print a Hello message with your name

```python
# Program to read your name and print Hello message

name = input("Enter your name: ")
print(f"Hello, {name}!")
```

**Explanation:**
- This program prompts the user to input their name using `input()`, and then prints a greeting message using `print()`.

### b) Read two numbers and print their sum, difference, product, and division

```python
# Program to read two numbers and perform arithmetic operations

# Read two numbers from user input
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Perform operations
sum_result = num1 + num2
difference_result = num1 - num2
product_result = num1 * num2
if num2 != 0:
    division_result = num1 / num2
else:
    division_result = "undefined (division by zero)"

# Print results
print(f"Sum: {sum_result}")
print(f"Difference: {difference_result}")
print(f"Product: {product_result}")
print(f"Division: {division_result}")
```

**Explanation:**
- The program prompts for two numbers, performs arithmetic operations (addition, subtraction, multiplication, division), and handles the case where division by zero may occur.

### c) Word and character count of a given string

```python
# Program to count words and characters in a given string

# Read input string
input_string = input("Enter a string: ")

# Count words and characters
word_count = len(input_string.split())
char_count = len(input_string)

# Print results
print(f"Word Count: {word_count}")
print(f"Character Count (including spaces): {char_count}")
```

**Explanation:**
- The program uses `split()` to break the string into words and calculates the number of words. It also uses `len()` to count the total number of characters (including spaces).

### d) Area of a given shape (rectangle, triangle, and circle) reading shape and appropriate values from standard input

```python
# Program to calculate the area of a shape based on user input

# Read the shape type
shape = input("Enter the shape (rectangle, triangle, or circle): ").lower()

if shape == "rectangle":
    # For rectangle: Area = length * width
    length = float(input("Enter the length: "))
    width = float(input("Enter the width: "))
    area = length * width
    print(f"Area of the rectangle: {area} square units")

elif shape == "triangle":
    # For triangle: Area = 0.5 * base * height
    base = float(input("Enter the base: "))
    height = float(input("Enter the height: "))
    area = 0.5 * base * height
    print(f"Area of the triangle: {area} square units")

elif shape == "circle":
    # For circle: Area = pi * radius^2
    import math
    radius = float(input("Enter the radius: "))
    area = math.pi * (radius ** 2)
    print(f"Area of the circle: {area} square units")

else:
    print("Invalid shape!")
```

**Explanation:**
- The program prompts the user to input the shape (rectangle, triangle, or circle).
- It then asks for the necessary dimensions (e.g., length and width for a rectangle, base and height for a triangle, or radius for a circle).
- The program calculates and prints the area based on the formula for the respective shape.

### Running these programs on Raspberry Pi:

1. You can run these Python programs by opening a terminal and creating a Python file (e.g., `program.py`).
2. Type `nano program.py` to create or edit the file.
3. Paste the code and save it.
4. Run the program with the following command:  
   ```bash
   python3 program.py
   ```

These are simple Python programs that will work on your Raspberry Pi to perform basic input/output tasks and computations. */