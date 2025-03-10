// Name: Aaron Brown
// Course: CSC 285
// Project: Lab #3 (Observer Pattern)
// File Name: WeatherStation.java
public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		AlertDisplay alertDisplay = new AlertDisplay(weatherData);

		System.out.println("First");
		weatherData.setMeasurements(80, 65, 30.4f);
	  	System.out.println("Second");
		weatherData.setMeasurements(82, 70, 29.2f);
		System.out.println("Third");
		weatherData.setMeasurements(78, 90, 29.2f);

		// Showing off alertDisplay
		System.out.println("Fourth");
		weatherData.setMeasurements(101, 90, 29.2f);
	}
}
