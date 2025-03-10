package myinheritanceexample;

/**
 *
 * @author mtrutsch
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    MyPoint3D argument3DPoint =  new MyPoint3D();
    MyPoint3D p1 = new MyPoint3D();
    MyPoint3D p2 = new MyPoint3D(argument3DPoint);
    MyPoint3D p3 = new MyPoint3D(3, 14, 23);

    System.out.println("p1 and p2 are the same: " + p1.equals(p2));
    System.out.println("p2 and p3 are the same: " + p2.equals(p3));
    System.out.println("p1 and p3 are the same: " + p3.equals(p1));
    
    System.out.println();
    
    System.out.println("The location of p1: " + p1.getLocation());
    System.out.println("The location of p2: " + p2.getLocation());
    System.out.println("The location of p3: " + p3.getLocation());
    
    System.out.println();
    
    System.out.println("The X of p1: " + p1.getX());
    System.out.println("The Y of p1: " + p1.getY());
    System.out.println("The Z of p1: " + p1.getZ());
    
    p1.move(7, 9);
    p2.move(2, 3, 6);
    p3.move(9, 4);
    
    System.out.println();
    
    System.out.println("p1 after move: " + p1);
    System.out.println("p2 after move: " + p2);
    System.out.println("p3 after move: " + p3);
    
    p2.setLocation(p1);
    p1.setLocation(15, 10, 5);
    
    System.out.println();
    
    System.out.println("p1 after set: " + p1);
    System.out.println("p2 after set: " + p2);
    //System.out.println("p3 after set: " + p3);
    
    System.out.println();
    
    System.out.println("p1 toString: " + p1);
    
    System.out.println();
    
    p1.translate(10, 10, 10);
    
    System.out.println("p1 after translate (10, 10, 10): " + p1);
    
    System.out.println();
    
    System.out.println("Distance Squared between (0, 0, 0) and (10, 10, 10): " + p1.distanceSq(0, 0, 0, 10, 10, 10));
    System.out.println("Distance Squared between p1 and (10, 10, 10): " + p1.distanceSq(10, 10, 10));
    System.out.println("Distance Squared between p1 and p2: " + p1.distanceSq(p2));
    
    System.out.println();
    
    System.out.println("Distance between (0, 0, 0) and (10, 10, 10): " + p1.distance(0, 0, 0, 10, 10, 10));
    System.out.println("Distance between p1 and (10, 10, 10): " + p1.distance(10, 10, 10));
    System.out.println("Distance between p1 and p2: " + p1.distance(p2));
    
  }
}
