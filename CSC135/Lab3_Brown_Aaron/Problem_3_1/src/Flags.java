/* 
Name: Aaron Brown
Course: CSC 135
Project: Problem 3.1
File name: Flags.java
 */
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate; // for the circle method

public class Flags extends Application{

    // creates the European flag through Javafx
    
    // Attempt at making a star
    public Polygon buildStar(int xCoord, int yCoord) {
        Polygon star = new Polygon();
        star.getPoints().addAll(new Double[]{
        150.0, 200.0,// far left point
        225.0, 200.0,
        250.0, 120.0,// far top point
        275.0, 200.0,
        350.0, 200.0,// far right point
        290.0, 250.0,
        315.0, 350.0,// bottom right point
        250.0, 280.0,
        185.0, 350.0,// bottom left point
        210.0, 250.0
        });
        star.setFill(Color.YELLOW);
        star.setScaleX(.25);
        star.setScaleY(.25);
        // moves the star according to the parameters
        star.setTranslateX(xCoord);
        star.setTranslateY(yCoord);
        
        return star;
    }
    

    public void start(Stage primaryStage)
    {
        // Initialize the stars group
        Group stars = new Group();

        // Manually places the stars on the scene
        Polygon star = buildStar(50,60);
        stars.getChildren().add(star);
        star = buildStar(75,-35);
        stars.getChildren().add(star);
        star = buildStar(150,-110);
        stars.getChildren().add(star);
        star = buildStar(250,-140);//top
        stars.getChildren().add(star);
        star = buildStar(350,-110);
        stars.getChildren().add(star);
        star = buildStar(425,-35);
        stars.getChildren().add(star);
        star = buildStar(450,60); // right
        stars.getChildren().add(star);
        star = buildStar(425,160);
        stars.getChildren().add(star);
        star = buildStar(350,235);
        stars.getChildren().add(star);
        star = buildStar(250,265);
        stars.getChildren().add(star);
        star = buildStar(150,235);
        stars.getChildren().add(star);
        star = buildStar(75,160);
        stars.getChildren().add(star);
        
        // EU Flag but with circles
        /*
        for (int angle=0;angle<12 ; angle++) {
            Circle circle = new Circle(300, 300, 20);
            circle.setFill(Color.YELLOW);
            circle.getTransforms().add(new Rotate(angle*30, 500, 300));
            stars.getChildren().add(circle);
        }
        */
               

        Group root = new Group(stars);
        Scene scene = new Scene(root, 1000, 600, Color.DARKBLUE);
        
        
        
        primaryStage.setTitle("EU Flag");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
