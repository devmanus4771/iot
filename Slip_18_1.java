// Q.1 Write a JAVA Program to implement built-in support (java.util.Observable) Weather
// station with members temperature, humidity, pressure and methods
// mesurmentsChanged(), setMesurment(), getTemperature(), getHumidity(),
// getPressure() 
public class Slip_18_1 {
    
}
/*In this task, we will implement the **Observer Design Pattern** using Java's built-in support for the pattern. Java provides the `java.util.Observable` class, which allows an object to notify other objects (observers) when its state changes.

In this scenario, we will create a **WeatherStation** class that implements `Observable`. It will have member variables such as `temperature`, `humidity`, and `pressure`. We will also implement methods like `measurementsChanged()`, `setMeasurement()`, `getTemperature()`, `getHumidity()`, and `getPressure()`.

### Key Components:
1. **WeatherStation (Observable)**: The class that holds the weather data and notifies observers when it changes.
2. **WeatherDisplay (Observer)**: The observer class that gets updated when the weather data changes.
3. **Main Class**: To test the implementation by creating instances of `WeatherStation` and `WeatherDisplay`.

### Java Program:

#### 1. **WeatherStation (Observable)**

```java
import java.util.Observable;

public class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    // Method to set the measurements
    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Method to notify observers when data changes
    public void measurementsChanged() {
        setChanged();  // Marks this Observable as changed
        notifyObservers();  // Notifies all registered observers
    }

    // Getters for the weather data
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
```

#### 2. **WeatherDisplay (Observer)**

```java
import java.util.Observer;
import java.util.Observable;

public class WeatherDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    // Constructor
    public WeatherDisplay(Observable weatherStation) {
        weatherStation.addObserver(this);  // Registers this display as an observer
    }

    // Update method called when the observed object changes
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherStation) {
            WeatherStation weatherStation = (WeatherStation) o;
            this.temperature = weatherStation.getTemperature();
            this.humidity = weatherStation.getHumidity();
            this.pressure = weatherStation.getPressure();
            display();  // Update the display with new data
        }
    }

    // Method to display the weather data
    public void display() {
        System.out.println("Current Weather Conditions:");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + "hPa");
        System.out.println();
    }
}
```

#### 3. **Main Class (Test the Application)**

```java
public class Main {
    public static void main(String[] args) {
        // Create a WeatherStation (Observable)
        WeatherStation weatherStation = new WeatherStation();
        
        // Create a WeatherDisplay (Observer) that observes the WeatherStation
        WeatherDisplay weatherDisplay = new WeatherDisplay(weatherStation);
        
        // Simulate new measurements
        weatherStation.setMeasurement(25.0f, 65.0f, 1013.0f);  // New weather data
        weatherStation.setMeasurement(30.0f, 70.0f, 1012.5f);  // Another update
        weatherStation.setMeasurement(22.5f, 60.0f, 1014.0f);  // Another update
    }
}
```

### Explanation of the Code:

1. **WeatherStation (Observable)**:
   - The `WeatherStation` class extends `Observable` and has three private member variables: `temperature`, `humidity`, and `pressure`.
   - `setMeasurement(float temperature, float humidity, float pressure)` method is used to update the weather data and then call `measurementsChanged()` to notify all observers.
   - The `measurementsChanged()` method marks the object as "changed" and calls `notifyObservers()` to notify all observers.

2. **WeatherDisplay (Observer)**:
   - The `WeatherDisplay` class implements the `Observer` interface and overrides the `update()` method.
   - The `update()` method is automatically called whenever the observed `WeatherStation` object calls `notifyObservers()`.
   - Inside `update()`, the display is updated with the latest weather data and displayed using the `display()` method.

3. **Main Class**:
   - In the `Main` class, we create an instance of `WeatherStation` and `WeatherDisplay`.
   - We simulate some weather data changes using `setMeasurement()` and observe the automatic updates on the display.

### Sample Output:

```
Current Weather Conditions:
Temperature: 25.0°C
Humidity: 65.0%
Pressure: 1013.0hPa

Current Weather Conditions:
Temperature: 30.0°C
Humidity: 70.0%
Pressure: 1012.5hPa

Current Weather Conditions:
Temperature: 22.5°C
Humidity: 60.0%
Pressure: 1014.0hPa
```

### Explanation:
- Whenever the weather data in the `WeatherStation` is updated using `setMeasurement()`, the `WeatherDisplay` is notified of the change.
- The `WeatherDisplay` then updates and displays the latest weather data each time.

### Important Notes:
- The `java.util.Observable` class has been deprecated in newer versions of Java (Java 9 and above), but it is still widely used in educational examples and legacy systems. For modern implementations, it is recommended to use other observer frameworks like `java.beans.PropertyChangeListener` or third-party libraries like **RxJava**. */