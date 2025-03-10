/**
 * File: Shuffle.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 01/09/2024
 * Java class description: Shuffles an array in random order
 */
import java.util.ArrayList;
import java.util.Random;

public class Shuffle {  
        static Random rand = new Random();
    public static void steps(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        /* Problem 5
        // adds 12 random numbers in array
        for (int i = 0;i<12; i++){
            array.add(rand.nextInt(40) + 10);
        }
        */
        // Problem 8
        // adds 1-12 to array
        for (int i = 1;i<=12; i++){
            array.add(i);
        }
        // Problem 6
        // print the values in the array
        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
        // Problem 7
        // Remove the values in random order
        System.out.println("Removed Values:");
        for (int i = 0, len = array.size(); i < 10; i++, len--){
            int index = rand.nextInt(len);
            System.out.print(array.get(index) + " ");
            array.remove(index);
        }
        System.out.println();
        System.out.println("Remaining Values:");
        for (int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
    public static void finalResult(){
        // Problem 9
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> shuffledArray = new ArrayList<Integer>();
        // adds 1-12 to array
        for (int i = 1;i<=12; i++){
            array.add(i);
        }
        System.out.println("Ordered Array: ");
        // prints all numbers in array
        for (int i = 0;i<array.size();i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
        // Transfers values from array to shuffledArray in random order
        for (int i = 0, len = array.size();len > 0; i++, len--){
            int index = rand.nextInt(len);
            shuffledArray.add(array.get(index));
            array.remove(index);
        }
        System.out.println("Random Order Array: ");
        // prints all numbers in shuffledArray
        for (int i = 0;i<shuffledArray.size();i++){
            System.out.print(shuffledArray.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        
        steps();
        
        finalResult();
        
    }
    
}
