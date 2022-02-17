package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    private LinkedList<Book> listBook;
    @FXML
    private VBox vBoxRead;

    @FXML
    private TabPane tabPane;

    @FXML
    private AnchorPane book;

    public ListController(LinkedList<Book> listBook) {

        this.listBook = listBook;
    }

    @Override
    public void initialize(URL location, ResourceBundle resource){
        System.out.println("Initialize");
        final int countOfBook = 10;
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

            createChildrenAnchorElement(pane, i);
        }
    }

    public void createChildrenAnchorElement(AnchorPane book, int i)
    {
        Label name_of_book = new Label("Name of Book");
        name_of_book.minWidth(100);
        name_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_book,30.0);
        AnchorPane.setLeftAnchor(name_of_book,10.0);
        AnchorPane.setRightAnchor(name_of_book,500.0);
        AnchorPane.setTopAnchor(name_of_book,10.0);

        Label curname_of_book = new Label(listBook.get(i).getNameOfBook());
        curname_of_book.minWidth(120);
        curname_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(curname_of_book,30.0);
        AnchorPane.setLeftAnchor(curname_of_book,110.0);
        AnchorPane.setRightAnchor(curname_of_book,500.0);
        AnchorPane.setTopAnchor(curname_of_book,10.0);

        Label name_of_author = new Label("Author");
        name_of_book.minWidth(100);
        name_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_author,10.0);
        AnchorPane.setLeftAnchor(name_of_author,10.0);
        AnchorPane.setRightAnchor(name_of_author,514.0);
        AnchorPane.setTopAnchor(name_of_author,30.0);

        Label curname_of_author = new Label(listBook.get(i).getAuthorOfBook());
        curname_of_book.minWidth(120);
        curname_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(curname_of_author,10.0);
        AnchorPane.setLeftAnchor(curname_of_author,110.0);
        AnchorPane.setRightAnchor(curname_of_author,514.0);
        AnchorPane.setTopAnchor(curname_of_author,30.0);

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

        book.getChildren().addAll(name_of_book, curname_of_book, name_of_author, curname_of_author, hBox);


        info.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    infoAboutBook(i);
                }
                catch (Exception e)
                {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        });

        markAsRead.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { markAsRead(i); }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteBook(i);
            }
        });
        System.out.println();
    }

    public void infoAboutBook(int index) throws Exception
    {
        Stage stage = new Stage();
        FXMLLoader root = new FXMLLoader(getClass().getResource("info-view.fxml"));
        ViewController controller = new ViewController(
                listBook.get(index).getAnnotationText(),
                listBook.get(index).getNameOfBook(),
                listBook.get(index).getAuthorOfBook(),
                listBook.get(index).getPublishingOfHouse(),
                listBook.get(index).getIsbn(),
                listBook.get(index).getReview(),
                listBook.get(index).getImg1(),
                listBook.get(index).getImg2()
                );
        root.setController(controller);
        SplitPane splitPane = root.load();

        Scene scene = new Scene(splitPane, 800, 600);
        stage.setScene(scene);
        Stage main = (Stage)((Node)tabPane).getScene().getWindow();
        stage.showAndWait();

    }

    public void markAsRead(int index)
    {

    }

    public void deleteBook(int index)
    {

    }
}
