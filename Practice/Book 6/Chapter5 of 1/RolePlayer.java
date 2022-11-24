import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class RolePlayer extends Application	
{
    public static void main(String[] args)
    {
        launch(args);
    }

    TextField txtCharacter;	
    TextField txtActor;

    @Override public void start(Stage primaryStage)
    {
	
        Label lblCharacter = new Label(_);
        lblCharacter.setMinWidth(100);
        lblCharacter.setAlignment(Pos.BOTTOM_RIGHT);

    	
        txtCharacter = new TextField();
        txtCharacter.setMinWidth(200);
        txtCharacter.setMaxWidth(200);
        txtCharacter.setPromptText(_);

     
        Label lblActor = new Label(_);
        lblActor.setMinWidth(100);
        lblActor.setAlignment(Pos.BOTTOM_RIGHT);

        	
        txtActor = new TextField();
        txtActor.setMinWidth(200);
        txtActor.setMaxWidth(200);
        txtActor.setPromptText(_);

     	
        Button btnOK = new Button(_);
        btnOK.setMinWidth(75);
        btnOK.setOnAction(e -> btnOK_Click() );

       
        HBox paneCharacter = new HBox(20, lblCharacter, txtCharacter);
        paneCharacter.setPadding(new Insets(10));

        	
        HBox paneActor = new HBox(20, lblActor, txtActor);
        paneActor.setPadding(new Insets(10));

       	
        HBox paneButton = new HBox(20, btnOK);
        paneButton.setPadding(new Insets(10));
        paneButton.setAlignment(Pos.BOTTOM_RIGHT);

    	
        VBox pane = new VBox(10, paneCharacter, paneActor, paneButton);

   	
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(_);
        primaryStage.show();
    }

    public void btnOK_Click()	
    {
        String errorMessage = _;	

        if (txtCharacter.getText().length() == 0)	
        {
            errorMessage += _;
        }

        if (txtActor.getText().length() == 0)	
        {
            errorMessage += _;
        }

        if (errorMessage.length() == 0) 	
        {
            String message = txtActor.getText();
            Alert a = new Alert(Alert.AlertType.INFORMATION, message);
            a.setTitle(_);
            a.showAndWait();
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.WARNING, errorMessage); 
            a.setTitle(_);
            a.showAndWait();
        }
    }
}
