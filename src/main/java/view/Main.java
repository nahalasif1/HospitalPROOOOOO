package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import simu.model.Asiakas;

public class Main  {
    // JavaFX-sovelluksen (käyttöliittymän) käynnistäminen
   /* @Override
    public void start(Stage primaryStage) {
        // Create a canvas
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a pane and add the canvas to it
        Pane pane = new Pane(canvas);

        // Create a scene and set it on the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Asiakkaat");
        primaryStage.show();

        // Create an instance of Asiakas and draw it on the canvas
        Asiakas asiakas = new Asiakas();
        asiakas.draw(gc, 50, 50);
    }
*/
    public static void main(String[] args) {
        SimulaattorinGUI.launch(SimulaattorinGUI.class);
    }
}
