package view;


import java.text.DecimalFormat;
import controller.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import simu.framework.Trace;
import simu.framework.Trace.Level;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;



public class SimulaattorinGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLloader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
        Parent root = fxmLloader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) { launch(args);}
}




