package csc145exam3;

import java.awt.Point;

public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    MyRectangle rect1 = new MyRectangle(0, 0, 10, 10);
    MyRectangle rect2 = new MyRectangle(new Point(5, 5), new Point(15, 15));
    
    System.out.println(rect1.isSquare());
    System.out.println(rect2.isSquare());
  }
}
