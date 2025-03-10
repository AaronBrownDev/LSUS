/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 2.3
File name: MoonEarthCalculator.java
 */
import java.util.Scanner; // imports scanner class


public class MoonEarthCalculator {

    // Converts the weight of something on the Earth to what it would be on the moon.
    public static void main(String[] args) {
        System.out.println("Input the weight of your object(the unit measurement remains the same):");
        Scanner getWeight = new Scanner(System.in);
        float weightEarth = getWeight.nextFloat();
        double weightMoon = (weightEarth/9.81)*1.622; // conversion formula
        System.out.println("The weight of your object would be " + weightMoon + " on the moon");
    }
    
}
