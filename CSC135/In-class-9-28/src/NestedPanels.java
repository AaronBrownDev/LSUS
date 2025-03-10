//**************************************************************
//  Author: Lewis/Loftus
//  Project: Nested Panes-Problem
//  Filename: NestedPanels.java
//  Demonstrates a basic component hierarchy.
//**************************************************************
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NestedPanels extends Application {

    //-----------------------------------------------------------
    // Main method to launch the application.
    // Not required for IDE that supports JavaFX.
    //-----------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }

    //-----------------------------------------------------------
    // Adding nodes to the JavaFX layout.
    //-----------------------------------------------------------
    public void start(Stage stage) throws Exception {

        // Create a first pane.
        Pane pane1 = new Pane();
        // Size of the pane.
        pane1.setPrefSize(150, 100);
        // Max Size set to pref size, to prevent auto resize of
        // pane in JavaFX.
        pane1.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        // Color of the pane.
        pane1.setStyle("-fx-background-color: green;");
        // Create a label.
        Label lbl1 = new Label("One");
        // Add label to the pane.
        pane1.getChildren().add(lbl1);

        // Create second pane.
        Pane pane2 = new Pane();
        pane2.setPrefSize(150, 100);
        pane2.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        pane2.setStyle("-fx-background-color: red;");
        Label lbl2 = new Label("Two");
        pane2.getChildren().add(lbl2);
       
        // Create third pane.
        Pane pane3 = new Pane();
        pane3.setPrefSize(300, 100);
        pane3.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        pane3.setStyle("-fx-background-color: yellow;");
        Label lb13 = new Label("Three");
        pane3.getChildren().add(lb13);
        
        // Create fourth pane.
        Pane myPane = new Pane();
        myPane.setPrefSize(320,20);
        myPane.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        myPane.setStyle("-fx-background-color: blue;");
        Label lb14 = new Label("My Pane");
        myPane.getChildren().add(lb14);
        
        
        // Creates a primary FlowPane Layout.
        // FlowPane lays out its children in a flow that wraps
        // at the flowpane's boundary.
        FlowPane root = new FlowPane();

        // Set padding, gaps, alignment and color.
        root.setPadding(new Insets(10));
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: blue;");
        root.setPrefSize(320, 260);

        // Add both pane1 and pane2 to root FlowPane Layout as
        // its children.
        root.getChildren().addAll(myPane, pane1, pane2, pane3);

        // Create the scene and pass the root node to the scene.
        Scene scene = new Scene(root);

        // Set title and display the scene.
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();
    }
}