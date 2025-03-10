
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aaron
 */
public class UserInfo extends Application{
        TextField nameField = new TextField("Name");
        TextField favColorField = new TextField("Favorite Color");
        TextField hobbyField = new TextField("Hobby");
        
    public void start(Stage primaryStage){
        
        Button printButton = new Button("Print!");
        printButton.setOnAction(this::printContents);
        
        FlowPane pane = new FlowPane(nameField, favColorField, hobbyField, printButton);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setStyle("-fx-background-color: cyan");
        
        Scene scene = new Scene(pane, 600, 100);
        
        primaryStage.setTitle("User Info");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    public void printContents(ActionEvent event) {
        String name, favColor, hobby;
        name = nameField.getText();
        favColor = favColorField.getText();
        hobby = hobbyField.getText();
        System.out.println("Name: " + name + "\nFavorite Color: " + favColor + "\nHobby: " + hobby);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
