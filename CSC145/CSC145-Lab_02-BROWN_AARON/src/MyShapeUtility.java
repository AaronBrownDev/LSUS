/**
 *
 * @author mtrutsch
 */
public class MyShapeUtility {
  public static boolean equalArea(float v1, float v2) {
    if(v1 == v2) {
      return true;
    }
    
    return false;
  }
  
  public static boolean equalArea(Measurable o1, Measurable o2) {
    if(o1.getArea() == o2.getArea()) {
      return true;
    }
    
    return false;
  }  
}
