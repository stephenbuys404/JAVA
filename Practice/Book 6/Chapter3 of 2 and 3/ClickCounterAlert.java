import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClickCounterAlert extends Application
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


        BorderPane pane = new BorderPane();
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
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once." );
            a.showAndWait();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "You have clicked "
                + iClickCount + " times.");
            a.showAndWait();
        }
    }
}
