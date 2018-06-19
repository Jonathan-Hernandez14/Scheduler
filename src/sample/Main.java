package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    // file that the program will "run off"

    private int numBrothers = 0;
    private int numSisters = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Scheduler");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


    }

    private ArrayList countBrothers() {
        return null;
    }

    private ArrayList countSisters() {
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
