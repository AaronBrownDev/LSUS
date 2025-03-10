/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class Chair {
    // Declarations
    String seatColor; int numLevers, numWheels; boolean back;
    
    // Constructors
    public Chair(String color, int nLevers, int nWheels, boolean backBool){
        seatColor = color;
        numLevers = nLevers;
        numWheels = nWheels;
        back = backBool;
    }
    public Chair(){}
    
    // Seat color section
    public void setSeatColor(String color){
        seatColor = color;
    }
    public String getSeatColor(){
        return seatColor;
    }
    // Number of levers section
    public void setNumLevers(int num){
        numLevers = num;
    }
    public int getNumLevers(){
        return numLevers;
    }
    // Number of wheels section
    public void setNumWheels(int num){
        numWheels = num;
    }
    public int getNumWheels(){
        return numWheels;
    }
    // Back section
    public void setBack(boolean backBool){
        back = backBool;
    }
    public boolean getBack(){
        return back;
    }
    @Override
    public String toString(){
        String boolTranslate;
        if (back) {
            boolTranslate = "a";
        } else {
            boolTranslate = "no";
        }
        String chairRep = "The chair is the color " + seatColor + ","+
                          " has " + numLevers + " lever(s), " +
                          numWheels + " wheel(s), " + boolTranslate + " back.";
        return chairRep;
    }
}
