package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class MainController {

    @FXML

    public Label mainLabel;
    @FXML
    public void clickOnListBook() throws Exception
    {
        Stage stage = (Stage)((Node)mainLabel).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("list-view.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
