package csc145exam1;
import java.awt.Point;
/**
 * File: Rectangle_Brown_Aaron.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Creates a rectangle object and calculates its measurements
 */
public class Rectangle_Brown_Aaron implements Calculable{
    // Declarations of variables
    float area, perimeter;
    float width, height;
    Point location;
    
    public Rectangle_Brown_Aaron() {
        // Otherwise throws error
        location = new Point(0,0);
    }
    
    public Rectangle_Brown_Aaron(float w, float h, Point l){
        width = w;
        height = h;
        location = l;
    }
    
    public void setWidth(float w) {
        width = w;
    } 
    
    public void setHeight(float h) {
        height = h;
    }
    
    public void setLocation(Point l) {
        location = l;
    }
    
    @Override
    public float getArea() {
        area = (width * height);
        return area;
    }

    @Override
    public float getPerimeter() {
        perimeter = width * 2 + height * 2;
        return perimeter;
    }
    @Override
    public Point getLocation() {
        return location.getLocation();
    }
    
    @Override
    public String toString() {
        area = (width * height);
        perimeter = width * 2 + height * 2;
        return String.format("""
*** Rectangle
Width: %.1f
Height: %.1f
Area (w * h): %.2f
Perimeter(w*2+h*2): %.2f    
Location: (%.2f, %.2f)   
""", width, height, area, perimeter, location.getX(), location.getY());
    }
}
