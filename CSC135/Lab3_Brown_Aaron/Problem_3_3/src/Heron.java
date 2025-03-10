/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 3.3
File name: Heron.java
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Heron {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userStr;
        double sideA, sideB, sideC, s; double area;
        System.out.println("What are the lengths of side a, b, and c: ");
        userStr = scan.nextLine();
        StringTokenizer multiValue = new StringTokenizer(userStr);
        sideA = Float.parseFloat(multiValue.nextToken());
        sideB = Float.parseFloat(multiValue.nextToken());
        sideC = Float.parseFloat(multiValue.nextToken());
        s = (sideA + sideB + sideC)/2;
        area = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC)); // might return NaN, I don't know how to fix
        System.out.println(area); 
    }
    
}
