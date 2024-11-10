// Q.1 Write a Java Program to implement undo command to test Ceiling fan
public class Slip_7_1 {
    
}
/*To implement the **Undo Command** using the Command Pattern for a **Ceiling Fan**, we need to create a system where we can execute commands on the fan (like turning it on or off) and then "undo" those actions. In the Command Pattern, we will encapsulate the actions (turning the fan on or off) in command objects, and each command object will also be able to undo its action.

### **Steps to Implement Undo Command for Ceiling Fan**:

1. **Command Interface**: Define the `Command` interface that includes both `execute()` and `undo()` methods.
2. **Concrete Command Classes**: Implement specific commands like turning the fan on or off.
3. **Receiver Class**: The `CeilingFan` class represents the object that performs the actions.
4. **Invoker**: The `RemoteControl` class will invoke commands and store the last executed command for undo.
5. **Client**: The `Client` class will set up the fan and invoke commands.

### **Java Code Implementation**:

#### 1. **Command Interface**:
```java
public interface Command {
    void execute();  // Method to execute the command
    void undo();     // Method to undo the command
}
```

#### 2. **Receiver Class (Ceiling Fan)**:
```java
public class CeilingFan {
    private String speed;

    public CeilingFan() {
        speed = "OFF"; // Initially the fan is off
    }

    public void on() {
        speed = "ON";
        System.out.println("Ceiling Fan is ON");
    }

    public void off() {
        speed = "OFF";
        System.out.println("Ceiling Fan is OFF");
    }

    public void setSpeed(String speed) {
        this.speed = speed;
        System.out.println("Ceiling Fan speed is set to: " + speed);
    }

    public String getSpeed() {
        return speed;
    }
}
```

#### 3. **Concrete Command Classes**:
- **FanOnCommand**: Turns the fan on.
- **FanOffCommand**: Turns the fan off.

```java
// Concrete Command to turn the fan ON
public class FanOnCommand implements Command {
    private CeilingFan fan;

    public FanOnCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.off(); // Undo turning the fan on
    }
}

// Concrete Command to turn the fan OFF
public class FanOffCommand implements Command {
    private CeilingFan fan;

    public FanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        fan.on(); // Undo turning the fan off
    }
}
```

#### 4. **Invoker (Remote Control)**:
```java
public class RemoteControl {
    private Command lastCommand; // Keep track of the last executed command for undo

    public void pressButton(Command command) {
        command.execute();        // Execute the command
        lastCommand = command;    // Save the last executed command
    }

    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.undo();  // Undo the last command
        }
    }
}
```

#### 5. **Client Code (Test Program)**:
```java
public class UndoCommandTest {
    public static void main(String[] args) {
        // Create a ceiling fan (Receiver)
        CeilingFan fan = new CeilingFan();

        // Create commands (Concrete Commands)
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);

        // Create the Remote Control (Invoker)
        RemoteControl remote = new RemoteControl();

        // Test the functionality
        System.out.println("Testing Undo Command for Ceiling Fan:\n");

        // Turn the fan ON
        remote.pressButton(fanOn);

        // Turn the fan OFF
        remote.pressButton(fanOff);

        // Undo the OFF command (turns the fan ON again)
        remote.pressUndo();

        // Undo the ON command (turns the fan OFF again)
        remote.pressUndo();
    }
}
```

### **Explanation**:
1. **Command Interface**:
   - The `Command` interface includes the `execute()` method to perform the action and the `undo()` method to reverse it.

2. **Receiver (Ceiling Fan)**:
   - The `CeilingFan` class is the receiver, which actually performs the actions like turning on or off the fan. It also has a method to get and set the fan's speed.

3. **Concrete Command Classes**:
   - **FanOnCommand**: This command turns the fan on when `execute()` is called and turns it off when `undo()` is called.
   - **FanOffCommand**: This command turns the fan off when `execute()` is called and turns it on when `undo()` is called.

4. **Invoker (RemoteControl)**:
   - The `RemoteControl` class is the invoker that keeps track of the last executed command. It has a `pressButton()` method to execute the command and a `pressUndo()` method to undo the last command.

5. **Client (UndoCommandTest)**:
   - The client code demonstrates the use of the Command Pattern. It creates the fan, commands, and remote control. It tests the functionality of turning the fan on and off, and then undoes those actions.

### **Expected Output**:
```
Testing Undo Command for Ceiling Fan:

Ceiling Fan is ON
Ceiling Fan is OFF
Ceiling Fan is ON
Ceiling Fan is OFF
```

### **Conclusion**:
In this example, the **Undo Command** was implemented using the **Command Pattern**. The `RemoteControl` class invokes the commands and supports undo functionality. This approach makes it easy to add more commands and undo operations without changing the existing code. */