package csc145exam1;
import java.awt.Point;
import java.lang.Math;
/**
 * File: Circle_Brown_Aaron.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Creates a circle object and calculates its measurements
 */
public class Circle_Brown_Aaron implements Calculable{
    // Declares variables
    float radius, area, perimeter;
    Point location;
    // Default constructors
    public Circle_Brown_Aaron () {
        // Otherwise throws error
        location = new Point(0,0);
    }
    // Override constructors with parameters
    public Circle_Brown_Aaron (float r, Point l){
        radius = r;
        location = l;
    }
    
    // returns the area value
    @Override
    public float getArea() {
        area = (float)(Math.PI * (radius*radius));
        return area;
    }
    // returns the perimeter value
    @Override
    public float getPerimeter() {
        perimeter = (float)(Math.PI * 2 * radius);
        return perimeter;
    }
    // returns the location as a Point Object
    @Override
    public Point getLocation() {
        return location.getLocation();
    }
    // Overrides the print statement to print circle specificactions
    @Override
    public String toString(){
        // This way the area and perimeter will always be updated
        perimeter = (float)(Math.PI * 2 * radius);
        area = (float)(Math.PI * (radius*radius));
        return String.format("""                       
        *** Circle
        Radius: %.1f
        Area (PI * r^2): %.2f
        Perimeter (2 * PI * r): %.2f
        Location: (%.2f, %.2f) 
        """, radius, area, perimeter, location.getX(), location.getY());
    }
        
}
