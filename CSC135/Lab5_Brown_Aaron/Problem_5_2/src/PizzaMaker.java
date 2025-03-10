import java.text.NumberFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class PizzaMaker extends Application{
        private final float INITIAL_COST = 10;
        Text pizzaCost;
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        CheckBox pepperoniBox, hamburgerBox, baconBox, jalapenoBox, mushroomBox, pineappleBox;

    public void start(Stage primaryStage){
        
        //
        pepperoniBox = new CheckBox("Pepperoni");
        hamburgerBox = new CheckBox("Hamburger");
        baconBox = new CheckBox("Bacon");
        jalapenoBox = new CheckBox("Jalapeno");
        mushroomBox = new CheckBox("Mushroom");
        pineappleBox = new CheckBox("Pineapple");
        //
        //
        pepperoniBox.setOnAction(this::processButtonsPressed);
        hamburgerBox.setOnAction(this::processButtonsPressed);
        baconBox.setOnAction(this::processButtonsPressed);
        jalapenoBox.setOnAction(this::processButtonsPressed);
        mushroomBox.setOnAction(this::processButtonsPressed);
        pineappleBox.setOnAction(this::processButtonsPressed);
        //
        
        VBox toppingsColumn1 = new VBox(pepperoniBox, hamburgerBox, baconBox); 
        toppingsColumn1.setSpacing(20);
        VBox toppingsColumn2 = new VBox(jalapenoBox, mushroomBox, pineappleBox); 
        toppingsColumn2.setSpacing(20);
        
        HBox hBox = new HBox(toppingsColumn1, toppingsColumn2);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);
        
        Label pizzaCostLabel = new Label("Pizza Cost: ");
        pizzaCost = new Text(fmt.format(INITIAL_COST));
        HBox pizzaInfo = new HBox(pizzaCostLabel, pizzaCost);
        
        VBox layout = new VBox(hBox, pizzaInfo);
        layout.setSpacing(40);
        layout.setAlignment(Pos.CENTER);
        
        
        Group root = new Group(layout);

        Scene scene = new Scene(root, 500, 350, Color.LIGHTBLUE);
        
        primaryStage.setTitle("Pizza Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void processButtonsPressed(ActionEvent event){
        float cost = INITIAL_COST;
        if (pepperoniBox.isSelected())
            cost += .5;
        if (hamburgerBox.isSelected())
            cost += .5;
        if (baconBox.isSelected())
            cost += .5;
        if (jalapenoBox.isSelected())
            cost += .5;
        if (mushroomBox.isSelected())
            cost += .5;
        if (pineappleBox.isSelected())
            cost += .5;
        pizzaCost.setText(fmt.format(cost));   
    }
    public static void main(String[] args) {
        launch(args);
    }
}
