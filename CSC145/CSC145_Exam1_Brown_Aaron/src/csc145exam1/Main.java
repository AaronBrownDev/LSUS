package csc145exam1;
import java.awt.Point;
/**
 * File: Main.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Creates the shape objects and prints their specifications
 */
public class Main {

    public static void main(String[] args) {
        Circle_Brown_Aaron circle = new Circle_Brown_Aaron(1, new Point(10, 30));
        Triangle_Brown_Aaron triangle = new Triangle_Brown_Aaron(15, 20, new Point(-50, 70));
        Parallelogram_Brown_Aaron parallelogram = new Parallelogram_Brown_Aaron(5, 10, 7, new Point(20, 15));
        Rectangle_Brown_Aaron rectangle = new Rectangle_Brown_Aaron(20, 45, new Point(25, 35));
        
        System.out.printf("***** AARON BROWN (SOFTWARE DEVELOPMENT)\n\n");
        System.out.println(circle);
        System.out.println(triangle);
        System.out.println(parallelogram);
        System.out.println(rectangle);
        
    }
    
}
