
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;


public class CountOddEvenZero extends Application{
        TextField userInput;
        Text odd, even, zero;
        int oNum, eNum, zNum;
        
    public void start(Stage primaryStage){
        // text field setup
        userInput = new TextField();
        Label statementLabel = new Label("Integer: ");
        userInput.setOnAction(this::processTextUpdate);
        
        HBox inputInfo = new HBox(statementLabel, userInput);
        inputInfo.setAlignment(Pos.CENTER);
        
        // odd info setup
        Label oddLabel = new Label("# of Odds: ");
        odd = new Text(Integer.toString(oNum));
        HBox oddInfo = new HBox(oddLabel, odd);
        oddInfo.setAlignment(Pos.CENTER);
        
        // even info setup
        Label evenLabel = new Label("# of Evens: ");
        even = new Text(Integer.toString(eNum));
        HBox evenInfo = new HBox(evenLabel, even);
        evenInfo.setAlignment(Pos.CENTER);
        
        // zero info setup
        Label zeroLabel = new Label("# of Zeros: ");
        zero = new Text(Integer.toString(zNum));
        HBox zeroInfo = new HBox(zeroLabel, zero);
        zeroInfo.setAlignment(Pos.CENTER);
        
        VBox stats = new VBox(inputInfo, oddInfo, evenInfo, zeroInfo);
        stats.setSpacing(40);
        stats.setAlignment(Pos.CENTER);
        StackPane root = new StackPane(stats);
        Scene scene = new Scene(root, 500, 350);
        primaryStage.setTitle("Odd, Even, and Zeros Counter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void count(){
        // counts the number of odd, even, and zeros and changes their respective variable
        String sNum;
        sNum = userInput.getText();
        oNum = 0; eNum = 0; zNum = 0;
        for (int i = 0, digit; i < (sNum).length() ;i++){
            digit = Integer.parseInt(sNum.substring(i, i+1));
            if (digit == 0){
                zNum++;
            } else if (digit % 2 == 0) {
                eNum++;
            } else {
                oNum++;
            }
        }
    }
    
    public void processTextUpdate(ActionEvent event){
        count();
        odd.setText(Integer.toString(oNum));
        even.setText(Integer.toString(eNum));
        zero.setText(Integer.toString(zNum));
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
