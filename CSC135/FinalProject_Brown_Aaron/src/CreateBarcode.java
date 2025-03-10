import java.util.Scanner;
public class CreateBarcode {
    // : short bar
    // | full bar
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // loop until user decides to stop entering zip codes
        do {
            System.out.println("Enter a valid(5 or 9 digit) zip code:");
            // gets zipCode from user and initializes it in CreateBarcode class
            Barcode.setZipCode(scan.nextLine());
            // checks validity of zipCode
            if (!Barcode.checkValid()){
                continue;
            }
            // print statements
            System.out.println("BARCODE " + Barcode.getBarcode());
            System.out.println("Do you want to enter another ZIP code? (YES/NO)");
        } while ("YES".equalsIgnoreCase(scan.nextLine()));
        scan.close();
    }
    
}
