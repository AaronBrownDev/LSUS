/* 
Name: Aaron Brown
Course: CSC 135
Project: P2_14_Brown_Aaron
File name: CartCalculator.java
 */
import java.util.*;
public class CartCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int itemQuantity; float itemPrice; float taxRate;
        System.out.println("Input the quantity of the item (Ex:5): ");
        itemQuantity = scan.nextInt();
        System.out.println("Input the price of the item (Ex:1.05): ");
        itemPrice = scan.nextFloat();
        System.out.println("Input the tax rate of the area (Ex:9.45% as 9.45): ");
        taxRate = 1 + (scan.nextFloat()/100);
        System.out.println("The total cost of your Cart: "+(itemQuantity*itemPrice)*taxRate);
    }
    
}


