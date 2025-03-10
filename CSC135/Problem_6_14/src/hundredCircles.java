
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Random;


public class hundredCircles extends Application{
    Random random = new Random();
    public void start(Stage primaryStage){
        Group root = new Group();
        for (int i = 0; i < 100; i++){
            root.getChildren().add(createCircle());
        }
        
        Scene scene = new Scene(root, 500, 350);
        primaryStage.setTitle("Odd, Even, and Zeros Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Circle createCircle(){
        double red, green, blue; int radius;
        Circle circle = new Circle();
        
        red = random.nextDouble();
        green = random.nextDouble();
        blue = random.nextDouble();
        radius = random.nextInt(30);
        
        circle.setFill(Color.color(red, green, blue));
        circle.setRadius(radius);
        circle.setCenterX(random.nextDouble() * (500 - 2 * radius) + radius);
        circle.setCenterY(random.nextDouble() * (350 - 2 * radius) + radius);
        
        return circle;
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
