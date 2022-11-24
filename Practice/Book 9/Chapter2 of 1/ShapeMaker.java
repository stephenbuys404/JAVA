import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;

public class ShapeMaker extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override public void start(Stage primaryStage)
    {

        Group group1 = new Group();

        
        for (int i = 0; i <600; i+=10)
        {
            Line line1 = new Line(i, 0, i, 600);
            line1.setStroke(Color.LIGHTGRAY);
            Line line2 = new Line(0, i, 600, i);
            line2.setStroke(Color.LIGHTGRAY);
            group1.getChildren().addAll(line1, line2);
        }

        
        Rectangle r1 = new Rectangle(50,25,100,140);
        r1.setStroke(Color.BLACK);
        r1.setFill(null);
        r1.setStrokeWidth(3);
        group1.getChildren().add(r1);

        
        Rectangle r2 = new Rectangle(250,25,100,140);
        r2.setStroke(Color.BLACK);
        r2.setFill(null);
        r2.setStrokeWidth(3);
        r2.setArcWidth(25);
        r2.setArcHeight(25);
        group1.getChildren().add(r2);

        
        Rectangle r3 = new Rectangle(450,25,100,140);
        r3.setStroke(Color.BLACK);
        r3.setFill(null);
        r3.setStrokeWidth(3);
        r3.setArcWidth(75);
        r3.setArcHeight(125);
        group1.getChildren().add(r3);

      
        Circle c1 = new Circle(100, 300, 75);
        c1.setStroke(Color.BLACK);
        c1.setFill(null);
        c1.setStrokeWidth(3);
        group1.getChildren().add(c1);

        
        Ellipse e1 = new Ellipse(300, 300, 75, 40);
        e1.setStroke(Color.BLACK);
        e1.setFill(null);
        e1.setStrokeWidth(3);
        group1.getChildren().add(e1);

        
        Ellipse e2 = new Ellipse(500, 300, 40, 75);
        e2.setStroke(Color.BLACK);
        e2.setFill(null);
        e2.setStrokeWidth(3);
        group1.getChildren().add(e2);

        
        Arc a1 = new Arc(150, 550, 100, 100, 90, 90);
        a1.setType(ArcType.OPEN);
        a1.setStroke(Color.BLACK);
        a1.setFill(null);
        a1.setStrokeWidth(3);
        group1.getChildren().add(a1);

        
        Arc a2 = new Arc(300, 550, 100, 100, 45, 90);
        a2.setType(ArcType.CHORD);
        a2.setStroke(Color.BLACK);
        a2.setFill(null);
        a2.setStrokeWidth(3);
        group1.getChildren().add(a2);

        
        Arc a3 = new Arc(500, 550, 100, 100, 45, 90);
        a3.setType(ArcType.ROUND);
        a3.setStroke(Color.BLACK);
        a3.setFill(null);
        a3.setStrokeWidth(3);
        group1.getChildren().add(a3);

      
        Scene scene = new Scene(group1);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shape Maker");
        primaryStage.show();
    }
}
