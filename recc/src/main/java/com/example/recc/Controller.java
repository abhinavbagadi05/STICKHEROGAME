package com.example.recc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Text lsttxt;

    public void mainMenu(ActionEvent event) throws IOException {
        GameState.setPresent_score(0);
        GameState.setPresent_cherries(0);
        Parent root = FXMLLoader.load(getClass().getResource("entry.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startGame(ActionEvent event) throws IOException {
        GameState.setPresent_score(0);
        GameState.setPresent_cherries(0);
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void revive(ActionEvent event) throws IOException {
        int presentScore = GameState.getPresent_score();
        int presentCherries = GameState.getPresent_cherries();

        if (presentCherries >= 3) {
            GameState.setPresent_cherries(presentCherries - 3);
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            showInsufficientCherriesAlert();
        }
    }

    private void showInsufficientCherriesAlert() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Insufficient Cherries");
        alert.setHeaderText(null);
        alert.setContentText("You do not have enough cherries for revival.");

        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lsttxt.setText("Present Score: " + GameState.getPresent_score()+"\n"+"Present Cherries: " + GameState.getPresent_cherries());
    }
}
