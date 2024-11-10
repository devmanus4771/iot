// Q.1 Write a Java Program to implement Facade Design Pattern for Home Theater
public class Slip_15_1 {
    
}
/*The **Facade Design Pattern** provides a simplified interface to a complex subsystem, making it easier to use. In the context of a **Home Theater** system, the subsystem may involve various components like a **Projector**, **DVD Player**, **Lights**, **Sound System**, etc. The **Facade** will simplify the interaction with these components, providing a unified interface to the user.

### **Key Components of the Home Theater:**
1. **Projector**
2. **DVD Player**
3. **Sound System**
4. **Lights**

### **Facade Class**:
The Facade class will provide an easy-to-use interface to control all the components of the Home Theater system, without needing to interact with each component individually.

### **Java Code Implementation:**

#### 1. **Component Classes** (Subsystem):

**Projector Class:**

```java
public class Projector {
    public void on() {
        System.out.println("Projector is now ON.");
    }
    public void off() {
        System.out.println("Projector is now OFF.");
    }
    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }
}
```

**DVD Player Class:**

```java
public class DvdPlayer {
    public void on() {
        System.out.println("DVD Player is now ON.");
    }
    public void off() {
        System.out.println("DVD Player is now OFF.");
    }
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
    public void stop() {
        System.out.println("Stopping the movie.");
    }
}
```

**SoundSystem Class:**

```java
public class SoundSystem {
    public void on() {
        System.out.println("Sound system is now ON.");
    }
    public void off() {
        System.out.println("Sound system is now OFF.");
    }
    public void setVolume(int volume) {
        System.out.println("Setting sound system volume to: " + volume);
    }
}
```

**Lights Class:**

```java
public class Lights {
    public void on() {
        System.out.println("Lights are now ON.");
    }
    public void off() {
        System.out.println("Lights are now OFF.");
    }
    public void dim(int level) {
        System.out.println("Lights dimmed to " + level + "%.");
    }
}
```

#### 2. **Facade Class:**

The **Facade** class will simplify the interactions with the subsystems.

```java
public class HomeTheaterFacade {
    private Projector projector;
    private DvdPlayer dvdPlayer;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheaterFacade(Projector projector, DvdPlayer dvdPlayer, SoundSystem soundSystem, Lights lights) {
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");

        lights.dim(10);        // Dim the lights
        projector.on();        // Turn on the projector
        projector.setInput("DVD");  // Set projector input to DVD
        soundSystem.on();      // Turn on the sound system
        soundSystem.setVolume(5); // Set volume to 5
        dvdPlayer.on();        // Turn on the DVD player
        dvdPlayer.play(movie); // Play the movie
    }

    public void endMovie() {
        System.out.println("\nShutting down the movie...");

        lights.on();           // Turn on the lights
        projector.off();       // Turn off the projector
        dvdPlayer.stop();      // Stop the movie
        dvdPlayer.off();       // Turn off the DVD player
        soundSystem.off();     // Turn off the sound system
    }
}
```

#### 3. **Client Code:**

```java
public class Main {
    public static void main(String[] args) {
        // Create subsystems
        Projector projector = new Projector();
        DvdPlayer dvdPlayer = new DvdPlayer();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        // Create a Facade object to simplify interaction
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, dvdPlayer, soundSystem, lights);

        // Watch a movie
        homeTheater.watchMovie("Inception");

        // End the movie
        homeTheater.endMovie();
    }
}
```

### **Explanation of the Code:**

1. **Subsystem Classes**: 
   - These classes (`Projector`, `DvdPlayer`, `SoundSystem`, `Lights`) represent individual components of the Home Theater system. Each class has methods for turning the device on/off and controlling its specific functionality.

2. **Facade Class (`HomeTheaterFacade`)**:
   - The **Facade** class encapsulates the complex interactions between the different components of the Home Theater system.
   - It provides simple methods like `watchMovie()` and `endMovie()`, which perform a series of actions on the subsystem objects in a predefined order. For example, `watchMovie()` dims the lights, turns on the projector, sets the volume, starts the DVD player, and plays the movie.
   - The client can use these simplified methods without needing to interact with each component directly.

3. **Client Code**:
   - In the `Main` class, the client creates instances of the subsystem classes and passes them to the `HomeTheaterFacade`.
   - The client then simply calls the `watchMovie()` and `endMovie()` methods on the **Facade** to enjoy the entire Home Theater experience, without dealing with the complexity of interacting with each component individually.

### **Output:**

```
Get ready to watch a movie...
Lights dimmed to 10%.
Projector is now ON.
Projector input set to: DVD
Sound system is now ON.
Setting sound system volume to: 5
DVD Player is now ON.
Playing movie: Inception

Shutting down the movie...
Lights are now ON.
Projector is now OFF.
Stopping the movie.
DVD Player is now OFF.
Sound system is now OFF.
```

### **Benefits of the Facade Pattern**:
- **Simplifies Client Code**: The client doesn't need to know the details of how each component works. It just calls a few simple methods on the **Facade**.
- **Reduces Complexity**: The Facade hides the complexity of dealing with multiple subsystems and provides a unified interface.
- **Promotes Loose Coupling**: The client code is decoupled from the individual subsystems. If you need to change the implementation of a subsystem (e.g., use a different projector or sound system), you only need to modify the **Facade**, not the client code.

The **Facade Design Pattern** is ideal for scenarios like this, where there are multiple complex subsystems, but the client needs a simple interface to interact with them. */
