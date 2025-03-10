
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class CellPhoneCollection {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CellPhone phone1, phone2, phone3, phone4;
        phone1 = new CellPhone("Foxconn", "IPhone 15", 1500);
        phone2 = new CellPhone("Samsung", "Galaxy S23 Ultra", 1200);
        phone3 = new CellPhone("Foxconn", "Google Pixel 6", 402.08);
        phone4 = new CellPhone();
        
        System.out.println("Who manufacturerd the cellphone: ");
        phone4.setManufacturer(scan.nextLine());
        System.out.println("What model is the cellphone: ");
        phone4.setModel(scan.nextLine());
        System.out.println("How much is the retail price: ");
        phone4.setPrice(scan.nextDouble());
        
        System.out.println(phone1);
        System.out.println();
        System.out.println(phone2);
        System.out.println();
        System.out.println(phone3);
        System.out.println();
        System.out.println(phone4);
        
    }
    
}
