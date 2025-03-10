public class Barcode {
    // Declares variables
    private static String zipCode, barcode;

    // Creates Barcode from user input 5 digit zip code
    public static String digitBar(int digit){
        switch (digit){
            case 0 -> {return "||:::";}
            case 1 -> {return ":::||";}
            case 2 -> {return "::|:|";}
            case 3 -> {return "::||:";}
            case 4 -> {return ":|::|";}
            case 5 -> {return ":|:|:";}
            case 6 -> {return ":||::";}
            case 7 -> {return "|:::|";}
            case 8 -> {return "|::|:";}
            case 9 -> {return "|:|::";}
            default -> {return "";} // prevents error
        }
    }
    // Report and error part
    public static boolean checkValid(){
        boolean isValid;
        if (zipCode.length() == 5|| zipCode.length() == 9 ) {
            isValid = makeBarcode();
        } else {
            System.out.println("ZIP Code was invalid: " + zipCode.length() + " digits\nDo you want to enter another ZIP code? (YES/NO)");
            isValid = false;
        }
        return isValid;
    }
    // initializes zipCode var
    public static void setZipCode(String z){
        zipCode = z;
    }
    // returns the zipCode var
    public static String getZipCode(){
        return zipCode;
    }
    // makes the barcode with zipcode
    public static boolean makeBarcode(){
        int digit, sum, correctionNum;
        sum = 0;
        if (zipCode.length() == 5){
            zipCode += "0000"; // since it says to add 4 0s
        }
        barcode = "|"; // initial frame bar
        // loops through ZIP code
        for (int i = 0; i < zipCode.length(); i++){
            try {   
                digit = Integer.parseInt(zipCode.substring(i, i+1));
                sum += digit;
                barcode += digitBar(digit);
            } catch(NumberFormatException e) {
                System.out.println("ZIP Code was invalid: contained non-numeric characters\nDo you want to enter another ZIP code? (YES/NO)");
                return false;
            }
        }
        correctionNum = 10 - sum % 10; // Correction Character Number
        barcode += digitBar(correctionNum) + "|"; // correction bar + ending frame bar
        return true;
    }
    // returns barcode
    public static String getBarcode(){
        return barcode;
    }
}
