/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
import java.util.*;
public class ParseIntSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String sNum; int iNum;
        sNum = scan.nextLine();
        iNum = 0;
        for (int i = 0, digit; i < (sNum).length() ;i++){
            digit = Integer.parseInt(sNum.substring(i, i+1));
            iNum += digit;
            System.out.println(digit);
        }
        System.out.println(iNum);
    }
}
