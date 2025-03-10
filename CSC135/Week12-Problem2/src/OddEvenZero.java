
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class OddEvenZero {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sNum; int oNum, eNum, zNum;
        sNum = scan.nextLine();
        oNum = 0; eNum = 0; zNum = 0;
        for (int i = 0, digit; i < (sNum).length() ;i++){
            digit = Integer.parseInt(sNum.substring(i, i+1));
            if (digit == 0){
                zNum++;
            } else if (digit % 2 == 0) {
                eNum++;
            } else {
                oNum++;
            }
        }
        System.out.println("Odd digits: " +oNum + "\nEven digits: " + eNum + "\nZero digits: " + zNum);
    }
    
}   
