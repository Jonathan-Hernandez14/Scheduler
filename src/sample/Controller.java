package sample;

import javafx.fxml.FXML;

// class that controls what the UI does when interacted with
public class Controller {

    @FXML
    public void printSomething() {
        System.out.println("button pressed");
    }
}
