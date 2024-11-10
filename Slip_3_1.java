// Q.1 Write a JAVA Program to implement built-in support (java.util.Observable) Weather
// station with members temperature, humidity, pressure and methods
// mesurmentsChanged(), setMesurment(), getTemperature(), getHumidity(),
// getPressure()

import java.util.Observable;
import java.util.Observer;

// Observable class: WeatherStation
class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    // Method to set new measurements
    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Method to notify observers
    public void measurementsChanged() {
        setChanged(); // Marks this Observable object as changed
        notifyObservers(); // Notify all observers
    }

    // Getter methods
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

// Observer class: WeatherDisplay
class WeatherDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    // Constructor to register the observer
    public WeatherDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    // Method called when Observable notifies observers
    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherStation) {
            WeatherStation weatherStation = (WeatherStation) obs;
            this.temperature = weatherStation.getTemperature();
            this.humidity = weatherStation.getHumidity();
            this.pressure = weatherStation.getPressure();
            display();
        }
    }

    // Display the current weather measurements
    public void display() {
        System.out.println("Current Weather Conditions:");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println("------------------------------");
    }
}

// Main class
public class Slip_3_1 {
    public static void main(String[] args) {
        // Create WeatherStation (Observable)
        WeatherStation weatherStation = new WeatherStation();

        // Create WeatherDisplay (Observer)
        WeatherDisplay currentDisplay = new WeatherDisplay(weatherStation);

        // Simulate new weather measurements
        weatherStation.setMeasurement(25.5f, 65.0f, 1013.0f);
        weatherStation.setMeasurement(27.3f, 70.0f, 1010.5f);
        weatherStation.setMeasurement(22.4f, 60.0f, 1015.2f);
    }
}

/*
 Explanation:
WeatherStation (Observable):

This class extends Observable.
It has fields for temperature, humidity, and pressure.
setMeasurement() updates the values and calls measurementsChanged().
measurementsChanged() uses setChanged() and notifyObservers() to inform all registered observers about the update.
WeatherDisplay (Observer):

This class implements the Observer interface.
It registers itself with the WeatherStation observable.
The update() method is called automatically when WeatherStation calls notifyObservers().
It retrieves the updated measurements and displays them.
Main Class (WeatherStationDemo):

Creates an instance of WeatherStation and WeatherDisplay.
Simulates updates to the weather data by calling setMeasurement().
Output:
yaml
Copy code
Current Weather Conditions:
Temperature: 25.5°C
Humidity: 65.0%
Pressure: 1013.0 hPa
------------------------------
Current Weather Conditions:
Temperature: 27.3°C
Humidity: 70.0%
Pressure: 1010.5 hPa
------------------------------
Current Weather Conditions:
Temperature: 22.4°C
Humidity: 60.0%
Pressure: 1015.2 hPa
------------------------------
Additional Notes:
Deprecation: java.util.Observable and java.util.Observer are deprecated in Java 9+. For modern implementations, consider using the Observer pattern manually or Java's PropertyChangeListener.
Usage: This pattern is useful when multiple objects need to be notified about changes in the state of another object.
This Java program demonstrates the use of built-in support for the Observer pattern with a weather station example.
 */