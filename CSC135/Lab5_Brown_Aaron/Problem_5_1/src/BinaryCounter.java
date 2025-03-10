import java.util.*;
public class BinaryCounter {
    // Counts the number of 1's in the binary input
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long binWord, checkNum, oneCount;
        boolean isBin;
        do {
            oneCount = 0; 
            isBin = true;
            System.out.println("Please enter a binary number (Ex: 10010)");
            binWord = scan.nextLong();
            while (binWord>0){
                checkNum = binWord % 10;
                System.out.println(checkNum + " " + binWord);
                System.out.println("Repeat number: " + oneCount);
                if (checkNum!= 0 && checkNum != 1){
                    isBin = false;
                    break;
                } else if (checkNum == 1){
                    oneCount++;
                }
                binWord = binWord / 10;
            }  
        } while (!isBin);
        System.out.println(oneCount);
    }
}
    

    