import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.util.*;

public class HardBouncingBall extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    private Circle ball;	
    private double x_speed = 2;
    private double y_speed = 3;
    final private int WIDTH = 600;
    final private int HEIGHT = 500;
    final private int BALL_SIZE = 20;

    @Override public void start(final Stage primaryStage)
    {
        Group root = new Group();

        RadialGradient g = new RadialGradient(	
            0, 0,
            0.35, 0.35,
            0.5,
            true,
            CycleMethod.NO_CYCLE,
            new Stop(0.0, Color.WHITE),
            new Stop(1.0, Color.RED));

        ball = new Circle(BALL_SIZE, g);	
        ball.setCenterX(BALL_SIZE);
        ball.setCenterY(BALL_SIZE);

        root.getChildren().addAll(ball);	
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();

        KeyFrame k = new KeyFrame(Duration.millis(10),	
            e ->
            {
                ball.setCenterX(ball.getCenterX() + x_speed);	
                ball.setCenterY(ball.getCenterY() + y_speed);

                if (ball.getCenterX() <= BALL_SIZE ||	
                    ball.getCenterX() >= WIDTH - BALL_SIZE)
                    x_speed = -x_speed;

                if (ball.getCenterY() <= BALL_SIZE ||	
                    ball.getCenterY() >= HEIGHT - BALL_SIZE)
                    y_speed = -y_speed;
            } );

        Timeline t = new Timeline(k);	
        t.setCycleCount(Timeline.INDEFINITE);	
        t.play();	
    }

}
