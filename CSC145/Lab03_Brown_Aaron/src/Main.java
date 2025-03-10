/**
 * File: Main.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Uses the MyStringUtility class to concatenate strings repeatedly
 */
public class Main {
    public static void main(String[] args) {
        MyStringUtility strUtil = new MyStringUtility();
        System.out.println(strUtil.multiConcat("Hello"));
        System.out.println(strUtil.multiConcat("Hello", -3));
        System.out.println(strUtil.multiConcat("Hello", 3));
        System.out.println(strUtil.multiConcat("Hello", "Whats", "Up", 1, 3, 5, 2));
    }
    
}
