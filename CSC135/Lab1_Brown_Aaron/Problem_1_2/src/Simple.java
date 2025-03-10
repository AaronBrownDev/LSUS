/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 1.2
File name: Simple.java
 */

public class Simple {

    // This program prints a list of class names
    // and adds comments about their validity
    public static void main(String[] args) {
        System.out.println("""                  
        simple // works but usually capitalize
        SimpleProgram // works
        1 Simple // doesn't because of the space and starting w/ number
        _Simple_ // works but usually do not start or end with underscore
        *Simple* // doesn't because of asterick
        $123_45 // works but starting with $ isn't recommended
        Simple! // doesn't because of exclamation
        """);
    }
}