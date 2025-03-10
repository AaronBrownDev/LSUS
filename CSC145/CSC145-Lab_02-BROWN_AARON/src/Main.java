/**
 * File: Main.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/08/2024
 * Java class description: The main class that will call the other class methods
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyRhombus r = new MyRhombus(3.56f, 12.432f);
        System.out.println("=== My Rhombus ===");
        System.out.println(r);
        System.out.println("Area: " + r.getArea());
        System.out.println("Perimeter: " + r.getPerimeter());
        System.out.println();
        
        MyTrapezoid t = new MyTrapezoid(3.56f, 5.31f, 3.432f, 5.56f, 6.32f);
        System.out.println("=== My Trapezoid ===");
        System.out.println(t);
        System.out.println("Area: " + t.getArea());
        System.out.println("Perimeter: " + t.getPerimeter());
        System.out.println();
        
        // --- MyShapeUtility
        System.out.println("=== MyRhombus ===");
        System.out.println(MyShapeUtility.equalArea(r.getArea(), t.getArea()));
        System.out.println(MyShapeUtility.equalArea(r, t));
        System.out.println(MyShapeUtility.equalArea(r, r));
        System.out.println(MyShapeUtility.equalArea(t, t));
    }
}