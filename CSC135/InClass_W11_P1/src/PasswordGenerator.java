/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
import java.util.*;
        
public class PasswordGenerator {

    // Password generator
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName, lastName, username; int randNum;
        System.out.println("What is your first name: ");
        firstName = scan.nextLine();
        System.out.println("What is your last name: ");
        lastName = scan.nextLine();
        username = firstName.substring(0,1);
        if (lastName.length() <= 5){
            username += lastName.substring(0, lastName.length());
        } else {
            username += lastName.substring(0,5);
        }
        username += (int)(Math.random()*90 + 10);
        System.out.println(username);
    }
    
}
