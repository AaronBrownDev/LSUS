/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 2.8
File name: TimeConverter.Java
 */
import java.util.*;
public class TimeConverter {
        // Converts time into seconds
    public static void main(String[] args) {
        Scanner getTime = new Scanner(System.in);
        int hours, minutes, seconds, totalSeconds;
        System.out.println("What is the total hours:");
        hours = getTime.nextInt();
        System.out.println("What is the total minutes:");
        minutes = getTime.nextInt();
        System.out.println("What is the total seconds:");
        seconds = getTime.nextInt();
        totalSeconds = hours * 3600 + minutes * 60 + seconds;
        System.out.println(hours + " hour(s) " + minutes + " minute(s) and " + seconds + " second(s) is "
        + "equivalent to " + totalSeconds + " second(s)");
    }
    
}
