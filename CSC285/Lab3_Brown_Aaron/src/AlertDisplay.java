// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #3 (Observer Pattern)
// File Name: AlertDisplay.java
public class AlertDisplay implements Observer, DisplayElement {

    private float temperature;
    private Subject weatherData;

    /**
     * change weatherData var to the given weatherData
     * registers the object to weatherData observer arrayList
     *
     * @param weatherData
     */
    public AlertDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * changes the temperature var to be the parameter temp
     * calls display method
     *
     * @param temp
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        display();
    }

    /**
     * prints "It is too hot!!!" if temperature above 100
     */
    @Override
    public void display() {
        if (temperature > 100) {
            System.out.println("It is too hot!!!");
        }
    }
}
