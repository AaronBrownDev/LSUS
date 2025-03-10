/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author aaron
 */
public class ClassRoom {
    
    
    public static void main(String[] args) {
        Chair chair1, chair2;
        chair1 = new Chair("Blue", 2, 8, true); // Color, numLevers, numWheels, back
        chair2 = new Chair();
        
        chair2.setSeatColor("Yellow");
        chair2.setBack(false);
        chair2.setNumLevers(3);
        chair2.setNumWheels(4);
        
        System.out.println(chair1);
        System.out.println(chair2);
        
    }
}
