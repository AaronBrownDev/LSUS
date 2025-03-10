package myinheritanceexample;

import java.awt.Point;
import java.lang.Math;

/**
 * Using the java.awt.Point class source as a template...
 * https://github.com/openjdk-mirror/jdk7u-jdk/blob/master/src/share/classes/java/awt/Point.java
 * 
 * This class represents a 3D point using Cartesian coordinates.
 *
 * @author Marjan Trutschl (mtrutsch@lsus.edu)
 * @since 1.0
 * @status Original version
 */
public class MyPoint3D extends Point {
  /**
   * The z coordinate of this <code>MyPoint3D</code>.
   * If no z coordinate is set, it will default to 0.
   *
   * @serial
   * @see #getLocation()
   * @see #move(int, int, int)
   */
  public int z;

  /**
  * Constructs and initializes a point at the origin
  * (0,0, 0) of the coordinate space.
  */
  public MyPoint3D() {
    this(0, 0, 0);
  }
  
  /**
   * Constructs and initializes a point with the same location as
   * the specified <code>Point</code> object.
   * @param p a point
   */
  public MyPoint3D(MyPoint3D p) {
    this(p.x, p.y, p.z);
  }

  /**
   * Constructs and initializes a point at the specified
   * {@code (x,y,z)} location in the coordinate space.
   * @param x the x coordinate of the newly constructed <code>MyPoint3D</code>
   * @param y the y coordinate of the newly constructed <code>MyPoint3D</code>
   * @param z the z coordinate of the newly constructed <code>MyPoint3D</code>
   */
  public MyPoint3D(int x, int y, int z) {
    super(x, y);
    this.z = z;  
  }

  
  public double getX() {
    return x;
  }
 
  public double getY() {
      return y;
  }
  /**
   * Returns the z coordinate value
   * @return the z coordinate
   */
  public double getZ() {
    return z;
  }
  
  public MyPoint3D getLocation() {
      return this;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  /**
   * Sets the z coordinate value
   * @param z
   * @since 1.0
   */
  public void setZ(int z) {
    this.z = z;
  }
  
//  public void setLocation(double x, double y, double z) {
//    this.x = x;
//    this.y = y;
//    this.z = z;
//  }
  
  public void setLocation(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public void setLocation(MyPoint3D p) {
    this.x = p.x;
    this.y = p.y;
    this.z = p.z;
  }
  
  /**
   * Sets this object's coordinates to the specified values. This method
   * is identical to the <code>setLocation(int, int)</code> method.
   * 
   * @param x the new x coordinate
   * @param y the new y coordinate
   * @param z the new z coordinate
   */
  public void move(int x, int y, int z) {
    super.move(x, y);    
    this.z = z;
  }


  /**
   * Determines whether or not two points are equal. Two instances of
   * <code>MyPoint3D</code> are equal if the values of their
   * <code>x</code>, <code>y</code> and <code>z</code> member fields, representing
   * their position in the coordinate space, are the same.
   * 
   * @param obj an object to be compared with this <code>MyPoint3D</code>
   * @return <code>true</code> if the object to be compared is
   *         an instance of <code>MyPoint3D</code> and has
   *         the same values; <code>false</code> otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof MyPoint3D mp3d) {
      return (x == mp3d.x) && (y == mp3d.y) && (z == mp3d.z);
    }
    
    return super.equals(obj);  
  }
  
  /**
   * Returns a string representation of this object. The format is:
   * <code>getClass().getName() + "[x=" + x + ",y=" + y + ']'</code>.
   *
   * @return a string representation of this object
   */
  @Override
  public String toString() {
    // --- [x=...,y=...,z=...]
    return "[x=" + x + ",y=" + y + ",z=" + z + "]";
  }
  
  public void translate(int dx, int dy, int dz) {
      this.x += dx;
      this.y += dy;
      this.z += dz;
  }
  
  public static double distanceSq(double x1, double y1, double z1, double x2, double y2, double z2) {
      double dx = x1 - x2;
      double dy = y1 - y2;
      double dz = z1 - z2;
      return Math.pow(Math.sqrt(dx * dx + dy * dy + dz * dz), 2);
}
  
  public double distanceSq(double px, double py, double pz) {
      double dx = this.x - px;
      double dy = this.y - py;
      double dz = this.z - pz;
      return Math.pow(Math.sqrt(dx * dx + dy * dy + dz * dz), 2);
  }
  
  public double distanceSq(MyPoint3D pt) {
      double dx = this.x - pt.x;
      double dy = this.y - pt.y;
      double dz = this.z - pt.y;
      return Math.pow(Math.sqrt(dx * dx + dy * dy + dz * dz), 2);
  }
    
  public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
      double dx = x1 - x2;
      double dy = y1 - y2;
      double dz = z1 - z2;
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
  }
  
  public double distance(double px, double py, double pz) {
      double dx = this.x - px;
      double dy = this.y - py;
      double dz = this.z - pz;
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
  }
  
  public double distance(MyPoint3D pt) {
      double dx = this.x - pt.x;
      double dy = this.y - pt.y;
      double dz = this.z - pt.y;
      return Math.sqrt(dx * dx + dy * dy + dz * dz);
  }
}
