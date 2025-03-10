import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class House extends Application{
    // Creates a House through Javafx
    public void start(Stage primaryStage) {
        // Main Wall
        Rectangle mainWall = new Rectangle(500,220);
        mainWall.setTranslateX(250);
        mainWall.setTranslateY(220);
        mainWall.setFill(Color.DARKRED);
        
        // Roof
        Rectangle roof = new Rectangle(520,70);
        roof.setTranslateX(240);
        roof.setTranslateY(220);
        roof.setFill(Color.LIGHTSALMON);
        
        // Windows
        Rectangle window1 = new Rectangle(70,50);
        window1.setFill(Color.ANTIQUEWHITE);
        window1.setTranslateX(325);
        window1.setTranslateY(330);
        Rectangle window2 = new Rectangle(70,50);
        window2.setFill(Color.ANTIQUEWHITE);
        window2.setTranslateX(620);
        window2.setTranslateY(330);
        
        // Door
        Rectangle doorFrame = new Rectangle(70,110);
        doorFrame.setFill(Color.BURLYWOOD);
        doorFrame.setTranslateX(480);
        doorFrame.setTranslateY(330);
        Circle doorKnob = new Circle(5);
        doorKnob.setTranslateX(535);
        doorKnob.setTranslateY(390);
        Group door = new Group(doorFrame, doorKnob);
        
        // Chimney w/ smoke
        Rectangle chimney = new Rectangle(50,100);
        chimney.setFill(Color.DARKRED);
        chimney.setTranslateX(620);
        chimney.setTranslateY(150);
        
        Circle smoke1 = new Circle(15);
        smoke1.setFill(Color.DARKGRAY);
        smoke1.setTranslateX(660);
        smoke1.setTranslateY(120);
        Circle smoke2 = new Circle(15);
        smoke2.setFill(Color.DARKGRAY);
        smoke2.setTranslateX(670);
        smoke2.setTranslateY(105);
        
        Group chimneyGroup = new Group(chimney, smoke1, smoke2);
        
        // House group
        Group house = new Group(mainWall, roof, door, window1, window2, chimneyGroup);
      
        // Grass
        Rectangle grass = new Rectangle(1000,200);
        grass.setTranslateY(400);
        grass.setFill(Color.DARKGREEN);
        
        // Clouds
        Ellipse cloud1 = new Ellipse();
        cloud1.setCenterX(200);
        cloud1.setCenterY(150);
        cloud1.setRadiusY(50);
        cloud1.setRadiusX(100);
        cloud1.setFill(Color.WHITE);
        Ellipse cloud2 = new Ellipse();
        cloud2.setCenterX(250);
        cloud2.setCenterY(100);
        cloud2.setRadiusY(60);
        cloud2.setRadiusX(90);
        cloud2.setFill(Color.WHITE);
        Group cloud = new Group(cloud1, cloud2);
        
        
        Group root = new Group(grass, cloud, house);
        Scene scene = new Scene(root, 1000, 600, Color.LIGHTBLUE);
        
        
        
        primaryStage.setTitle("House");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }   
}
