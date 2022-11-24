import javafx.application.*;	
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClickCounter extends Application	
{
    public static void main(String[] args)	
    {
        launch(args);	
    }

    Button btn;	
    Label lbl;	
	
    int iClickCount = 0;	

    @Override public void start(Stage primaryStage)	
    {
        btn = new Button();	
        btn.setText("Click me please!");	
        btn.setOnAction(e -> buttonClick());	

        lbl = new Label();	
        lbl.setText("You have not clicked the button.");	

        BorderPane pane = new BorderPane();	
        pane.setTop(lbl);	
        pane.setCenter(btn);	

        Scene scene = new Scene(pane, 250, 150);	

        primaryStage.setScene(scene);	
        primaryStage.setTitle("Click Counter");	
        primaryStage.show();	
    }

    public void buttonClick()	
    {
        iClickCount++;	
        if (iClickCount == 1)	
        {
            lbl.setText("You have clicked once.");	
        }
        else
        {
            lbl.setText("You have clicked "	
                + iClickCount + " times." );
        }
    }

}
