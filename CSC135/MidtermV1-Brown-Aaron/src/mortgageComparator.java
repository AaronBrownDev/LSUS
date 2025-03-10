/* 
Name: Aaron Brown
Course: CSC 135
Project: CSC Midterm V1
File name: mortgageComparator.javaz
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class mortgageComparator {

    // I feel like I definetly made this overcomplicated but it was satisfying to solve
    // I tried to make it as organized and readable as possible
    // calculates monthly payments and returns as a double
    public static double monthlyPayment(double annualInterest, int numYears, int amountBorrowed) {
        double monthlyInterest, monthlyPayment; // declaration
        monthlyInterest = annualInterest / 12; // initialization
        monthlyPayment = (((monthlyInterest) * amountBorrowed) / (1 - (1 / Math.pow(1 + monthlyInterest, 12 * numYears)))); // initializes
        return monthlyPayment; // returns monthly payment as a double
    }

    // calculates total payment
    public static double totalPayment(double annualInterest, int numYears, int amountBorrowed) {
        double monthlyInterest, totalCost;
        int numMonths; // declaration
        monthlyInterest = annualInterest / 12; // initialization
        numMonths = numYears * 12; // initialization
        totalCost = ((monthlyInterest * amountBorrowed) / (1 - Math.pow(1 + monthlyInterest, -numMonths))) * numMonths; //initializes
        return totalCost; // returns total cost as a double
    }

    // finds out how much space is needed and returns a string to use as spacing
    public static String spacingFunc(String section, String spaceTaken) {
        String spacing = " "; // has an initial spacing because of the | dividers
        int remainingSpace, spaceAvailable; // declaration
        // sections are iR, mPay, tPay, oPay, oPayPercent(Not used)
        if (section == "mPay") { // has 15 characters in length
            spaceAvailable = 15;
        } else { // all the other strings coincidentally are 13 characters in length so no need to do rest
            spaceAvailable = 13;
        }
        remainingSpace = spaceAvailable - spaceTaken.length();
        for (int i = 0; i < remainingSpace; i++) { // adds a space character for every remaining space available
            spacing += " ";
        }
        return spacing;
    }

    // compares loans with various interest rates
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // creates scanner to take inputs from user

        DecimalFormat oPfmt = new DecimalFormat("0.00%"); // forces the number into a format
        DecimalFormat aIfmt = new DecimalFormat("0.0%");
        NumberFormat currencyConv = NumberFormat.getCurrencyInstance(); // converts number into a dollar amount

        double aI;
        int nOY;
        int aB; // Declaration | aI = annual interest | nOY = number of years | aB = amount borrowed
            
        System.out.println("what is the annual interest rate? (Ex: 7% is inputted as 7)");
        aI = (scan.nextDouble()) / 100; // makes it where the number inputted is converted into a decimal

        System.out.println("What is the number of years the loan would be paid off in?");
        nOY = scan.nextInt(); // initialization

        System.out.println("What is the amount borrowed in the mortgage? (Ex: $5 is inputted as 5)");
        aB = scan.nextInt(); // initialization

        // creating variables to avoid repeating code
        double tPay1, tPay2, tPay3, tPay4, tPay5, mPay1, mPay2, mPay3, mPay4, mPay5;
        // not sure what to name so just reference for context
        tPay1 = totalPayment(aI - .01, nOY, aB);
        mPay1 = monthlyPayment(aI - .01, nOY, aB); // this is for the aI - 1%
        tPay2 = totalPayment(aI - .005, nOY, aB);
        mPay2 = monthlyPayment(aI - .005, nOY, aB);// this is for the aI - .5%
        tPay3 = totalPayment(aI, nOY, aB);
        mPay3 = monthlyPayment(aI, nOY, aB);// this is for the inputted aI
        tPay4 = totalPayment(aI + .005, nOY, aB);
        mPay4 = monthlyPayment(aI + .005, nOY, aB); // this is for the aI + .5%
        tPay5 = totalPayment(aI + .01, nOY, aB);
        mPay5 = monthlyPayment(aI + .01, nOY, aB); // this is for the aI + 1%

        // outputs on terminal
        System.out.println(
                "***********************************************************************"
                + "\nLoan Amount: " + currencyConv.format(aB)
                + "\nNumber of years: " + nOY
                + "\nRange of interest rates: " + aIfmt.format(aI - .01) + "-" + aIfmt.format(aI + .01)
                + "\n***********************************************************************"
                + "\nInterest Rate|Monthly Payment|Total Payment|$ Overpayment|% Overpayment"
                + // Annual interest rate inputted - 1%
                "\n" + aIfmt.format(aI - .01) + spacingFunc("iR", aIfmt.format(aI - .01))
                + // Interest rate
                currencyConv.format(mPay1) + spacingFunc("mPay", currencyConv.format(mPay1))
                + // Monthly payment
                currencyConv.format(tPay1) + spacingFunc("tPay", currencyConv.format(tPay1))
                + // Total payment
                currencyConv.format(tPay1 - aB) + spacingFunc("oPay", currencyConv.format(tPay1 - aB))
                + // $ Overpayment
                oPfmt.format((tPay1 / aB) - 1)
                + // % Overpayment
                // Annual interest rate inputted - .5%
                "\n" + aIfmt.format(aI - .005) + spacingFunc("iR", aIfmt.format(aI - .005))
                + // Interest rate
                currencyConv.format(mPay2) + spacingFunc("mPay", currencyConv.format(mPay2))
                + // Monthly payment
                currencyConv.format(tPay2) + spacingFunc("tPay", currencyConv.format(tPay2))
                + // Total payment
                currencyConv.format(tPay2 - aB) + spacingFunc("oPay", currencyConv.format(tPay2 - aB))
                + // $ Overpayment
                oPfmt.format((tPay2 / aB) - 1)
                + // % Overpayment
                // Annual interest rate inputted
                "\n" + aIfmt.format(aI) + spacingFunc("iR", aIfmt.format(aI))
                + // Interest rate
                currencyConv.format(mPay3) + spacingFunc("mPay", currencyConv.format(mPay3))
                + // Monthly payment
                currencyConv.format(tPay3) + spacingFunc("tPay", currencyConv.format(tPay3))
                + // Total payment
                currencyConv.format(tPay3 - aB) + spacingFunc("oPay", currencyConv.format(tPay3 - aB))
                + // $ Overpayment
                oPfmt.format((tPay3 / aB) - 1)
                + // % Overpayment
                // Annual interest rate inputted + .5%
                "\n" + aIfmt.format(aI + .005) + spacingFunc("iR", aIfmt.format(aI + .005))
                + // Interest rate
                currencyConv.format(mPay4) + spacingFunc("mPay", currencyConv.format(mPay4))
                + // Monthly payment
                currencyConv.format(tPay4) + spacingFunc("tPay", currencyConv.format(tPay4))
                + // Total payment
                currencyConv.format(tPay4 - aB) + spacingFunc("oPay", currencyConv.format(tPay4 - aB))
                + // $ Overpayment
                oPfmt.format((tPay4 / aB) - 1)
                + // % Overpayment
                // Annual interest rate inputted + 1%
                "\n" + aIfmt.format(aI + .01) + spacingFunc("iR", aIfmt.format(aI + .01))
                + // Interest rate
                currencyConv.format(mPay5) + spacingFunc("mPay", currencyConv.format(mPay5))
                + // Monthly payment
                currencyConv.format(tPay5) + spacingFunc("tPay", currencyConv.format(tPay5))
                + // Total payment
                currencyConv.format(tPay5 - aB) + spacingFunc("oPay", currencyConv.format(tPay5 - aB))
                + // $ Overpayment
                oPfmt.format((tPay5 / aB) - 1)); // % Overpayment
    }
}
