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
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class MainController {

    @FXML

    public Label mainLabel;
    @FXML
    public void clickOnListBook(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((Node)mainLabel).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("list-view.fxml"));
        LinkedList<Book> listBook = new LinkedList<>();
        for (int i = 0; i < 10; i++)
        {
            listBook.add(new Book("nameOfBook" + i, "authorOfBook" + i,
                    "publishingOfHouse" + i, "isbn" + i, "review" + i,
                    "annotationText" + i, "Harry.jpg", "Harry2.jpg", 5));
        }
        ListController controller = new ListController(listBook);
        root.setController(controller);
        TabPane pane = root.load();
        Scene scene = new Scene(pane, 800, 600);

        stage.setScene(scene);
        stage.show();
    }
}
