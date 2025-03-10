import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//************************************************************************
//  PushCounter.java       Author: Lewis/Loftus
//
//  Demonstrates JavaFX buttons and event handlers.
//************************************************************************

public class PushCounter extends Application
{
    private int count;
    private Text countText;
    private Button increment, decrement;
    
    //--------------------------------------------------------------------
    //  Presents a GUI containing a button and text that displays
    //  how many times the button is pushed.
    //--------------------------------------------------------------------
    public void start(Stage primaryStage)
    {
        count = 0;
        countText = new Text("Counter: 0");

        increment = new Button("Increment");
        increment.setOnAction(this::eventHandler);
        
        decrement = new Button("Decrement");
        decrement.setOnAction(this::eventHandler);

        FlowPane pane = new FlowPane(decrement, countText, increment);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setStyle("-fx-background-color: cyan");

        Scene scene = new Scene(pane, 300, 100);
        
        primaryStage.setTitle("Push Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    //--------------------------------------------------------------------
    //  Updates the counter and text when the button is pushed.
    //--------------------------------------------------------------------
    public void eventHandler(ActionEvent event)
    {   
        if (event.getSource() == increment){
            count++;
        } else {
            count--;
        }
        countText.setText("Counter: " + count);
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
