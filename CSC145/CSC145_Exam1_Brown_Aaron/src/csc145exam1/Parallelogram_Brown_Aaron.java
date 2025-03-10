package csc145exam1;
import java.awt.Point;
/**
 * File: Parallelogram_Brown_Aaron.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Creates a parallelogram object and calculates its measurements
 */
public class Parallelogram_Brown_Aaron implements Calculable{
    // Declares the variables
    float area, perimeter;
    float width, height, side;
    Point location;
    // Default constructor 
    public Parallelogram_Brown_Aaron() {
        
    }
    // Constructor with parameters
    public Parallelogram_Brown_Aaron(float w, float h, float s, Point l) {
        width = w;
        height = h;
        side = s;
        location = l;
        
    }
        // Assigns a float value to width
    public void setWidth(float w) {
        width = w;
    } 
    
    // Assigns a float value to height
    public void setHeight(float h) {
        height = h;
    }
    
    public void setSide(float s) {
        side = s;
    }
    
    // Assigns a Point object to location
    public void setLocation(Point l) {
        location = l;
    }
    // returns the area value
    @Override
    public float getArea() {
        area = width*height;
        return area;
    }
    // returns the perimeter value
    @Override
    public float getPerimeter() {
        perimeter = side * 2 + width * 2;
        return perimeter;
    }
    // returns the location as a Point object
    @Override
    public Point getLocation() {
        return location;
    }
        // Overrides the print statement to print triangle specifications
    @Override
    public String toString() {
        // This way the area and perimeter will always be updated
        area = width*height;
        perimeter = side * 2 + width * 2;
        // Return statement
        return String.format("""
        *** Parallelogram
        Width: %.1f
        Height: %.1f
        Side: %.1f
        Area (w * h): %.2f
        Perimeter: %.2f    
        Location: (%.2f, %.2f)   
        """, width, height, side, area, perimeter, location.getX(), location.getY());
    }
}


