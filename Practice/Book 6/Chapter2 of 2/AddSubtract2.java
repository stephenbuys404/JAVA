import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class AddSubtract2 extends Application	
{
    public static void main(String[] args)
    {
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label lbl;
    int iCounter = 0;

    @Override public void start(Stage primaryStage)
    {
        ClickHandler ch = new ClickHandler();	

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(ch);	

        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(ch);	

        lbl = new Label();
        lbl.setText(Integer.toString(iCounter));

        HBox pane = new HBox(10);
        pane.getChildren().addAll(lbl, btnAdd, btnSubtract);

        Scene scene = new Scene(pane, 200, 75);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub");
        primaryStage.show();
    }

    private class ClickHandler	
        implements EventHandler <ActionEvent>
    {
        @Override public void handle(ActionEvent e)	
        {
            if (e.getSource()==btnAdd)
            {
                iCounter++;
            }
            else
            {
                if (e.getSource()==btnSubtract)
                {
                    iCounter--;
                }
            }
            lbl.setText(Integer.toString(iCounter));
        }
    }

}
