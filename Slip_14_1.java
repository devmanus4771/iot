// Q.1 Write a Java Program to implement Command Design Pattern for Command Interface
// with execute() . Use this to create variety of commands for LightOnCommand,
// LightOffCommand, GarageDoorUpCommand, StereoOnWithCDComman
public class Slip_14_1 {
    
}
/*To implement the **Command Design Pattern** in Java, we need to define several components:

1. **Command Interface**: This will define the `execute()` method that all command classes will implement.
2. **Concrete Command Classes**: These will implement the `execute()` method for specific actions like turning the light on or off, opening the garage door, or turning on the stereo.
3. **Invoker**: This will store and invoke the commands.
4. **Receiver**: This will perform the actual action (like turning on the light, opening the garage door, etc.).

### Step-by-Step Design:

1. **Command Interface**: It defines the `execute()` method that every command must implement.
2. **Concrete Command Classes**: These represent various commands (LightOnCommand, LightOffCommand, etc.).
3. **Invoker Class**: This is responsible for triggering the command when needed.
4. **Receiver Classes**: These are the objects that will actually carry out the action when the command is executed.

### **Java Code Implementation**

#### 1. **Command Interface**:

```java
public interface Command {
    void execute();
}
```

#### 2. **Receiver Classes** (Actions to perform):

- **Light Class** (Receiver for LightOn and LightOff commands):

```java
public class Light {
    public void on() {
        System.out.println("The light is ON");
    }

    public void off() {
        System.out.println("The light is OFF");
    }
}
```

- **GarageDoor Class** (Receiver for GarageDoorUp command):

```java
public class GarageDoor {
    public void up() {
        System.out.println("The garage door is UP");
    }

    public void down() {
        System.out.println("The garage door is DOWN");
    }
}
```

- **Stereo Class** (Receiver for StereoOnWithCD command):

```java
public class Stereo {
    public void on() {
        System.out.println("The stereo is ON");
    }

    public void off() {
        System.out.println("The stereo is OFF");
    }

    public void setCD() {
        System.out.println("The stereo is set to CD");
    }
}
```

#### 3. **Concrete Command Classes**:

- **LightOnCommand**:

```java
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
```

- **LightOffCommand**:

```java
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
```

- **GarageDoorUpCommand**:

```java
public class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
```

- **StereoOnWithCDCommand**:

```java
public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
    }
}
```

#### 4. **Invoker Class** (Controls the execution of commands):

```java
public class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}
```

#### 5. **Client Code** (Testing the implementation):

```java
public class Main {
    public static void main(String[] args) {
        // Create the receivers (objects that will perform actions)
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        // Create the command objects and associate them with the receivers
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command stereoOnWithCD = new StereoOnWithCDCommand(stereo);

        // Create the invoker (remote control)
        RemoteControl remoteControl = new RemoteControl();

        // Turn on the light
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        // Turn off the light
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();

        // Open the garage door
        remoteControl.setCommand(garageDoorUp);
        remoteControl.pressButton();

        // Turn on the stereo with CD
        remoteControl.setCommand(stereoOnWithCD);
        remoteControl.pressButton();
    }
}
```

### **Explanation of the Code**:

1. **Command Interface**: The `Command` interface defines the method `execute()` that is implemented by all concrete command classes.
   
2. **Receiver Classes**:
   - The `Light`, `GarageDoor`, and `Stereo` classes represent the objects that perform the actions (turning on the light, opening the garage door, etc.).
   - These are the **receivers** that the commands operate on.

3. **Concrete Command Classes**:
   - `LightOnCommand`, `LightOffCommand`, `GarageDoorUpCommand`, and `StereoOnWithCDCommand` are concrete implementations of the `Command` interface.
   - Each command class encapsulates the action to be performed (such as turning on/off the light, opening the garage door, or turning on the stereo with a CD).
   
4. **Invoker Class**:
   - The `RemoteControl` class acts as the **invoker**. It stores a reference to a command and invokes it when the `pressButton()` method is called.

5. **Client Code**:
   - In the `Main` class, the client creates instances of receivers, creates command objects, and associates them with the appropriate receivers.
   - Then, it sets the commands in the `RemoteControl` (invoker) and presses the button to execute the command.

### **Output**:

```
The light is ON
The light is OFF
The garage door is UP
The stereo is ON
The stereo is set to CD
```

### **Key Concepts of the Command Pattern**:

1. **Command Interface**: This defines the `execute()` method that is used by all command classes.
2. **Concrete Commands**: These classes encapsulate a request and delegate the action to the receiver.
3. **Invoker**: This class triggers the command but does not need to know how the command is executed.
4. **Receiver**: These are the objects that perform the actual actions when the command is executed.

The **Command Pattern** helps decouple the invoker (client) from the actual actions performed by the receivers. It also allows for easy extension (adding new commands) without modifying existing code. */
