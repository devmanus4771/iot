// Q.1 Write a Java Program to implement command pattern to test Remote Control
public class Slip_6_1 {
    
}

/*The **Command Pattern** is a behavioral design pattern that turns a request into a stand-alone object. This pattern allows you to decouple the sender of a request from the object that performs the action. It encapsulates the request as an object, thus allowing parameterization of clients with queues, requests, and operations.

In this case, we will create a **remote control** program using the Command Pattern. We will implement a `RemoteControl` that can execute various commands (like turning on or off devices), and these commands will be encapsulated in concrete `Command` classes.

### **Steps to Implement Command Pattern for Remote Control**:
1. **Command Interface**: Define a common interface for all commands.
2. **Concrete Command Classes**: Implement different commands that will be executed (e.g., turn on/off lights).
3. **Receiver**: The objects that perform the actual action (e.g., `Light` or `Fan`).
4. **Invoker**: The object that calls the command (e.g., `RemoteControl`).
5. **Client**: The object that initializes the command and associates it with the invoker.

### **Java Code Implementation**:

#### 1. **Command Interface**:
```java
// Command interface
public interface Command {
    void execute(); // All commands must implement this method
}
```

#### 2. **Receiver Classes** (e.g., `Light`, `Fan`):
```java
// Receiver class: Light
public class Light {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

// Receiver class: Fan
public class Fan {
    public void start() {
        System.out.println("Fan is ON");
    }

    public void stop() {
        System.out.println("Fan is OFF");
    }
}
```

#### 3. **Concrete Command Classes**:
```java
// Concrete command to turn on the light
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

// Concrete command to turn off the light
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

// Concrete command to start the fan
public class FanStartCommand implements Command {
    private Fan fan;

    public FanStartCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }
}

// Concrete command to stop the fan
public class FanStopCommand implements Command {
    private Fan fan;

    public FanStopCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }
}
```

#### 4. **Invoker (Remote Control)**:
```java
// The Invoker class
public class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute(); // Execute the command
    }
}
```

#### 5. **Client Code**:
```java
public class CommandPatternTest {
    public static void main(String[] args) {
        // Creating receiver objects
        Light light = new Light();
        Fan fan = new Fan();

        // Creating command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanStart = new FanStartCommand(fan);
        Command fanStop = new FanStopCommand(fan);

        // Creating remote control (Invoker)
        RemoteControl remote = new RemoteControl();

        // Testing light control
        remote.setCommand(lightOn);
        remote.pressButton(); // Light is ON

        remote.setCommand(lightOff);
        remote.pressButton(); // Light is OFF

        // Testing fan control
        remote.setCommand(fanStart);
        remote.pressButton(); // Fan is ON

        remote.setCommand(fanStop);
        remote.pressButton(); // Fan is OFF
    }
}
```

### **Explanation**:
1. **Command Interface**: The `Command` interface defines the `execute()` method that all concrete command classes must implement.
2. **Receiver Classes**: The `Light` and `Fan` classes represent the devices that will perform actions (like turning on/off).
3. **Concrete Commands**: Each command class implements the `Command` interface and contains a reference to a `Receiver` (e.g., `Light` or `Fan`). The `execute()` method performs the specific action on the receiver (like turning the light on or off).
4. **Invoker**: The `RemoteControl` class is the invoker that holds a reference to a `Command` object and triggers the command using the `pressButton()` method.
5. **Client**: The `CommandPatternTest` class is the client that sets up the commands, associating them with the `RemoteControl` and triggering them.

### **Output**:
```
Light is ON
Light is OFF
Fan is ON
Fan is OFF
```

### **Conclusion**:
The **Command Pattern** provides a clean way to decouple the requester (remote control) from the actual operation (turning on/off the light or fan). This approach makes it easy to add new commands without changing existing code, and it is very flexible for situations where multiple actions need to be performed on different devices with a common interface. */