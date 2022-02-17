package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
<<<<<<< Updated upstream
=======
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
>>>>>>> Stashed changes
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    private LinkedList<Book> listBook;
    @FXML
    private VBox vBoxRead;

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

<<<<<<< Updated upstream
        Label name_of_author = new Label("Author1");
=======
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
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes

    }

    public void markAsRead()
    {

    }

    public void deleteBook()
    {

    }
}
