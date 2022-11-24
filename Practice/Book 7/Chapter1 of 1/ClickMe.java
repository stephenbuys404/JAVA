import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClickMe extends Application
{
    public static void main(String[] args)
    {
        launch(args);
        System.out.println("Done");
    }

    Button btn;

    @Override public void start(Stage primaryStage)
    {
        
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());

        
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);

        
        Scene scene = new Scene(pane, 300, 250);

        
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Click Me App");
        primaryStage.show();
    }

    public void buttonClick()
    {
        if (btn.getText() == "Click me please!")
        {
            btn.setText("You clicked me!");
        }
        else
        {
             btn.setText("Click me please!");
        }
    }

}
