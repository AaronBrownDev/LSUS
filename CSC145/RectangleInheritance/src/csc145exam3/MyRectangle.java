package csc145exam3;

import java.awt.Point;
import java.awt.Rectangle;
import java.lang.Math;
/*
  * Inheriting from the java.awt.Rectangle class
 * See: https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
 */

/**
 *
 * @author Aaron
 */
public class MyRectangle extends Rectangle {
  public int x2;  // x + width or p2.x or
  public int y2;  // y + height or p2.y or
  
  /**
   * TODO
   * @param p1
   * @param p2
   */
  public MyRectangle(Point p1, Point p2) {
    // Store p1.x, p1.y, p2.x, p2.y in x, yt, x2, y2t
    this.x = p1.x;
    this.y = p1.y;
    this.x2 = p2.x;
    this.y2 = p2.y;
  }

  /**
   * TODO
   * @param x
   * @param y
   * @param x2
   * @param y2
   */
  public MyRectangle(int x, int y, int x2, int y2) {
    this.x = x;
    this.y = y;
    this.x2 = x2;
    this.y2 = y2;
  }
  
  /**
   * TODO
   * @param scaleX
   * @param scaleY
   */
  public void scaleIt(float scaleX, float scaleY) {
    //width = (TODO)(TODO * scaleX);
    //height = (TODO)(TODO * scaleY);
    this.width = (int)(Math.abs(this.x - this.x2) * scaleX);
    this.height = (int)(Math.abs(this.y - this.y2) * scaleY);
    this.x2 = (this.x + this.width);
    this.y2 = (this.y + this.height);
  }

  /**
   * TODO
   * @param scale
   */
  public void scaleIt(float scale) {
    // TODO: Scales both width and height
    //width = (TODO)(TODO * scale);
    //height = (TODO)(TODO * scale);
    this.scaleIt(scale, scale);
  }

  
  // --- Add the following methods, along with JavaDoc. Use existing methods from Rectangle when implementing the
  // --- methods below.
  // --- public int getPerimeter()
  public int getPerimiter(){
      return this.width * 2 + this.height * 2;
  }
  
  // --- public int getArea()
  public int getArea(){
      return this.width * this.height;
  }
  
  // --- public int getCombinedArea(Rectangle rect)
  public int getCombinedArea(Rectangle rect){
      if (this.touching(rect)) {
          return this.getArea() + rect.height * rect.width;
      } else {
          return -1;
      }
  }
  // --- public int getCombinedArea(MyRectangle rect)
  public int getCombinedArea(MyRectangle rect){
      return this.getCombinedArea((Rectangle)rect);
  }
  // ---   Two methods above calculate the combined area if the two rectanges are overlapping or at least touching
  // ---   (have a common edge). If the rectangles are not overlapping or touching, return -1.
  // ---   Note that you should not duplicate your code. Implement getCombinedArea(MyRectangle rect) method and have
  // ---   the other call the getCombinedArea(Rectangle rect) method. (Hint: use the data in Rectangle to create an
  // ---   object of type MyRectangle)
  // --- public int getIntersectArea(Rectangle rect)
  public int getIntersectArea(Rectangle rect){
      Rectangle intersectRect = this.intersection(rect);
      return intersectRect.width * intersectRect.height;
  }
  // --- public int getIntersectArea(MyRectangle rect)
  public int getIntersectArea(MyRectangle rect){
      return this.getIntersectArea((Rectangle)rect);
  }
  // ---   Two methods above calculate the intersect area if the two rectanges are overlapping. If the rectangles
  // ---   are not overlapping or touching, return -1. See the note about not duplicating the code above.
  // --- public float getPercentIntersect(Rectangle rect)
  public float getPercentIntersect(Rectangle rect){
      return 0;
  }
  // --- public float getPercentIntersect(MyRectangle rect)
  public float getPercentIntersect(MyRectangle rect){
      return this.getPercentIntersect((Rectangle)rect);
  }
  // ---   Two methods above calculate the percent intersect area if the two rectanges are overlapping. If the rectangles
  // ---   are not overlapping or touching, return -1. See the note about not duplicating the code above.
  // --- public boolean touching(Rectangle rect)
  public boolean touching(Rectangle rect){
     return false;
  }
  // --- public boolean touching(MyRectangle rect)
  public boolean touching(MyRectangle rect){
      return this.touching((Rectangle)rect);
  }
  // ---   Two methods above determine if the two rectanges are touching (sharing one of the edges). If the rectangles
  // ---   are touching, return true, false otherwise. See the note about not duplicating the code above.
  // --- public boolean isLandscape()
  public boolean isLandscape(){
      if (this.width > this.height){
        return true;
      } else {
        return false;  
      }
  }
  // ---   Returns true if the rectangle is wider than taller, false otherwise.
  
  // --- public boolean isSquare()
    public boolean isSquare(){
      if (this.width == this.height){
          return true;
      } else {
          return false;
      }
  }
  // ---   Returns true if the width and height of the rectangle are the same, false otherwise.
  

  @Override
  public String toString() {
    return "x1: " + x + "  y1: " + y + "  x2: " + x2 + "  y2: " + y2;
  }
}
