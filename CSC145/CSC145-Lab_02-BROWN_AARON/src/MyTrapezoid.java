/**
 * File: MyTrapezoid.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/08/2024
 * Java class description: Calculates a trapezoid shape
 */
public class MyTrapezoid implements Measurable{
    float shortBase, longBase, height, side1, side2;
    
    public MyTrapezoid(float sB, float lB, float h, float s1, float s2) {
        shortBase = sB;
        longBase = lB;
        side1 = s1;
        side2 = s2;
        height = h;
    }
    
    
    @Override
    public void setWidth(float width) {
        shortBase = width;
    }
    
    public void setLongBase(float base) {
        longBase = base;
    }    
    
    public void setSide1(float side) {
        side1 = side;
    }
    
    public void setSide2(float side) {
        side2 = side;
    }
    
    @Override
    public void setHeight(float height) {
        this.height = height;
    }
    
    @Override
    public float getWidth() {
        return shortBase;
    }
    
    @Override
    public float getHeight() {
        return height;
    }    
    @Override
    public float getArea() {
        return ((shortBase + longBase)/2)*height; 
    }
    
    @Override
    public float getPerimeter() {
        return shortBase + longBase + side1 + side2;     
    }
    
    @Override
   public String toString(){
       return String.format("Short Base: %f, Long Base %f Height: %f", shortBase, longBase, height);
   }
}
