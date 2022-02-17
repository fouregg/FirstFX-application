package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class MainController {
    LinkedList<Book> listBook = new LinkedList<>();

    public void initialize()
    {
        for (int i = 0; i < 10; i++)
        {
            listBook.add(new Book("nameOfBook" + i, "authorOfBook" + i,
                    "publishingOfHouse" + i, "isbn" + i, "review" + i,
                    "annotationText" + i, "Harry.jpg", "Harry2.jpg", 5));
        }
    }
    @FXML
    public MenuBar menuBar;

    @FXML
    public void clickOnListBook(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((Node)menuBar).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("list-view.fxml"));
        ListController controller = new ListController(listBook);
        root.setController(controller);
        AnchorPane pane = root.load();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clickOnAddBook(ActionEvent event) throws Exception
    {
        Stage stage = (Stage)((Node)menuBar).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("add_view.fxml"));
        AddController controller = new AddController(listBook);
        root.setController(controller);
        AnchorPane pane = root.load();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();

    }
}
