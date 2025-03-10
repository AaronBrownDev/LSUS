/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author lruesch
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Text text = new BaseText("This is a sample text");
        System.out.println("Base text: " + text.getText());

        Text boldText = new BoldText(text);
        System.out.println("Bold text: " + boldText.getText());

        Text italicText = new ItalicText(text);
        System.out.println("Italic text: " + italicText.getText());

        Text boldItalicText = new ItalicText(new BoldText(text));
        System.out.println("Bold italic text: " + boldItalicText.getText());
        
        Text boldItalicStrikedThroughText = new StrikedThroughText(boldItalicText);
        System.out.println("Bold italic text that has a line through it: " + boldItalicStrikedThroughText.getText());
    }
    
}
