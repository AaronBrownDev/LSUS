package csc145exam1;
import java.awt.Point;
/**
 * File: Triangle_Brown_Aaron.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Creates a triangle object and calculates it measurements
 */
public class Triangle_Brown_Aaron implements Calculable{
    // Declaration of variables
    float area, perimeter;
    float width, height;
    Point location;
    
    // Default constructor
    public Triangle_Brown_Aaron() {
        // Otherwise throws error
        location = new Point(0, 0);
    }
    
    // Override constructors with paramaters
    public Triangle_Brown_Aaron(float w, float h, Point l){
        width = w;
        height = h;
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
    
    // Assigns a Point object to location
    public void setLocation(Point l) {
        location = l;
    }
    
    // returns the area value
    @Override
    public float getArea() {
        area = (width * height) / 2;
        return area ;
    }

    // returns the perimeter value
    @Override
    public float getPerimeter() {
        // assuming it is a right triangle
        perimeter = width + height + (float)Math.sqrt(width*width + height*height);
        return perimeter;
    }
    
    // returns the location as a Point Object
    @Override
    public Point getLocation() {
        return location.getLocation();
    }
    
    // Overrides the print statement to print triangle specifications
    @Override
    public String toString() {
        // This way the area and perimeter will always be updated
        area = (width * height) / 2;
        perimeter = width + height + (float)Math.sqrt(width*width + height*height);
        // Return statement
        return String.format("""
        *** Triangle
        Width: %.1f
        Height: %.1f
        Area ((w * h) / 2): %.2f
        Perimeter: %.2f    
        Location: (%.2f, %.2f)   
        """, width, height, area, perimeter, location.getX(), location.getY());
    }
}
