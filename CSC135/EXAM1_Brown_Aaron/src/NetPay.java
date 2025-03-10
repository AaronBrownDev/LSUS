/*
Name: Aaron Brown
Course: CSC 135
Project: EXAM 1
File Name: NetPay.java
*/
import java.util.*; import java.text.*; // imports Scanner, NumberConverter, and more
public class NetPay {

    // Calculates net pay of the employee
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // creates scanner variable
        NumberFormat currencyConv = NumberFormat.getCurrencyInstance(); // creates currency converter variable
        NumberFormat percentConv = NumberFormat.getPercentInstance(); // creates percent converter variable
        String name; float numHours, hourlyPay, fedTax, stateTax; // declaration of variables part 1
        double grossPay, fedWithhold, stateWithhold, totalDeduct, netPay; // declaration of variables part 2
        // gets user input
        System.out.println("Enter employee's full name:");
        name = scan.nextLine();
        System.out.println("Enter the number of hours worked in a week:");
        numHours = scan.nextFloat();
        System.out.println("Enter the hourly pay rate in dollars and cents:");
        hourlyPay = scan.nextFloat();
        System.out.println("Enter the federal tax withholding rate (ex: 10% would be entered as 0.10):");
        fedTax = scan.nextFloat();
        System.out.println("Enter the state tax withholding rate (ex: 5% would be entered as 0.05%):");
        stateTax = scan.nextFloat();
        // calculates answers
        grossPay = hourlyPay * numHours;
        fedWithhold = grossPay * fedTax;
        stateWithhold = grossPay * stateTax;
        totalDeduct = fedWithhold + stateWithhold;
        netPay = grossPay - totalDeduct;
        // outputs the end product
        System.out.println(
"*******************************************************"+
"\nEmployee name: " + name +
"\nHours worked: " + numHours +
"\nPay rate: " + currencyConv.format(hourlyPay) +
"\nGross pay: " + currencyConv.format(grossPay) +
"\nDeduction:" +
"\n      Federal witholding (" + percentConv.format(fedTax) + "): " + currencyConv.format(fedWithhold) +
"\n      State withholding (" + percentConv.format(stateTax) + "): " + currencyConv.format(stateWithhold) +
"\n      Total deduction: " + currencyConv.format(totalDeduct) +
"\nNet pay: " + currencyConv.format(netPay) +
"\n*******************************************************");
        }
    
}
