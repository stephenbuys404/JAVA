import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;

public class BouncingBall extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override public void start(Stage primaryStage)
    {

        RadialGradient g = new RadialGradient(	
            0, 0,
            0.35, 0.35,
            0.5,
            true,
            CycleMethod.NO_CYCLE,
            new Stop(0.0, Color.WHITE),
            new Stop(1.0, Color.RED));

        Circle ball = new Circle(0,0,20);	
        ball.setFill(g);

        Group root = new Group(); 	
        root.getChildren().add(ball);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.show();

        TranslateTransition t = new TranslateTransition(	
            Duration.millis(2000), ball);
        t.setFromX(ball.getRadius());	
        t.setToX(scene.getWidth() - ball.getRadius());	
        t.setFromY(scene.getHeight() / 2);	
        t.setToY(scene.getHeight() / 2);
        t.setCycleCount(Transition.INDEFINITE);	
        t.setAutoReverse(true);	
        t.setInterpolator(Interpolator.LINEAR);	
        t.play();	
    }

}
