/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 3.2
File name: EuclideanDistance.java
 */
import java.util.*;

public class EuclideanDistance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userStr;
        int xCoord, yCoord, xCoord2, yCoord2;
        System.out.println("Input the x and y coordinate for the two points (Ex. 10 30 50 70)");
        userStr = scan.nextLine();
        StringTokenizer multiValue = new StringTokenizer(userStr);
        xCoord = Integer.parseInt(multiValue.nextToken());
        yCoord = Integer.parseInt(multiValue.nextToken());
        xCoord2 = Integer.parseInt(multiValue.nextToken());
        yCoord2 = Integer.parseInt(multiValue.nextToken());
        double euclideanFormula = Math.sqrt(Math.pow(xCoord2-xCoord,2) + Math.pow(yCoord2-yCoord,2));
        System.out.println(Math.sqrt(euclideanFormula));
    }
    
}
