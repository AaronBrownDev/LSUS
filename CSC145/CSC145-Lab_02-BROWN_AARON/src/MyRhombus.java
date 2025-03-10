/**
 * File: MyRhombus.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/0982024
 * Java class description: Calculates a rhombus shape
 */
public class MyRhombus implements Measurable{
    private float base, height;
    
    public MyRhombus(float b, float h) {
        base = b;
        height = h;
    }
    
    @Override
    public float getWidth() {
        return base;
    }
    
    @Override
    public float getHeight() {
        return height;
    }
    
    @Override
    public void setWidth(float width) {
        base = width;
    }
    
    @Override
    public void setHeight(float height) {
        this.height = height;
    }
    
        @Override
    public float getArea() {
        return base * height;
    }
    
    @Override
    public float getPerimeter() {
        return base * 4;
    }
    @Override
   public String toString(){
       return String.format("Base: %f, Height: %f", base, height);
   }
}
