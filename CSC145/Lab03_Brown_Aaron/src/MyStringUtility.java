/**
 * File: MyStringUtility.java
 * Author: Aaron Brown
 * Concentration: SD
 * Date: 02/19/2024
 * Java class description: Returns concatenations of strings
 */
public class MyStringUtility {
    String concat_string;
    public String multiConcat(String s, int n) {
        if (n < 2) { 
            return s;
        }
        concat_string = "";
        for (int i = 0;i < n; i++) {
            concat_string += s;
        }
        return concat_string;
    }
    
    public String multiConcat(String s) {
        return s + s;
    }
    
    public String multiConcat(String s1, String s2, String s3, int n1, int n2, int n3, int times){
        concat_string = "";
        // Loops x times
        for (int i = 0; i < times; i++) {
            concat_string += multiConcat(s1, n1);
            concat_string += multiConcat(s2, n2);
            concat_string += multiConcat(s3, n3);
        }
        return concat_string;
    }
}
