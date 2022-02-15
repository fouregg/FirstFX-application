package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ListController {
    @FXML
    private VBox vBoxRead;

    @FXML
    private AnchorPane book;

    @FXML
    public void initialize(){
        final int countOfBook = 55;
        final int heightElement = 60;
        vBoxRead.minHeight(heightElement * countOfBook);
        for (int i = 0; i < countOfBook; i++) {
            AnchorPane pane = new AnchorPane();

            pane.setMinHeight(40);
            pane.setMaxHeight(heightElement);
            pane.prefWidth(800);
            pane.prefHeight(heightElement);
            pane.minWidth(Region.USE_COMPUTED_SIZE);
            pane.maxWidth(Region.USE_COMPUTED_SIZE);
            vBoxRead.getChildren().add(pane);

            createChildrenAnchorElement(pane);
        }
    }

    public void createChildrenAnchorElement(AnchorPane book)
    {
        Label name_of_book = new Label("Name of Book1");
        name_of_book.minWidth(100);
        name_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_book,30.0);
        AnchorPane.setLeftAnchor(name_of_book,10.0);
        AnchorPane.setRightAnchor(name_of_book,500.0);
        AnchorPane.setTopAnchor(name_of_book,10.0);

        Label name_of_author = new Label("Author1");
        AnchorPane.setBottomAnchor(name_of_author,10.0);
        AnchorPane.setLeftAnchor(name_of_author,10.0);
        AnchorPane.setRightAnchor(name_of_author,514.0);
        AnchorPane.setTopAnchor(name_of_author,30.0);

        Button info = new Button("info");
        Button markAsRead = new Button("mark as read");
        Button delete = new Button("Delete");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(200);
        hBox.setMinWidth(350);
        hBox.setMaxHeight(200);
        hBox.setMaxWidth(350);
        hBox.setSpacing(20);
        AnchorPane.setBottomAnchor(hBox,10.0);
        AnchorPane.setLeftAnchor(hBox,500.0);
        AnchorPane.setRightAnchor(hBox,20.0);
        AnchorPane.setTopAnchor(hBox,10.0);
        hBox.getChildren().addAll(info, markAsRead, delete);

        book.getChildren().addAll(name_of_book,name_of_author, hBox);


        info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                infoAboutBook();
            }
        });

        markAsRead.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                markAsRead();
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteBook();
            }
        });
        System.out.println();
    }

    public void infoAboutBook()
    {

    }

    public void markAsRead()
    {

    }

    public void deleteBook()
    {

    }
}
