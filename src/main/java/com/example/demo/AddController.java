package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AddController extends MainController implements Initializable {

    private LinkedList listOfBook;
    private String img1, img2;

    @FXML
    TextField nameBook;

    @FXML
    TextField authorBook;

    @FXML
    TextField publishingHouse;

    @FXML
    TextField ISBN;

    @FXML
    TextArea reviewArea;

    @FXML
    TextArea annotation;

    @FXML
    TextField rate;

    @FXML
    Button btnImg1;

    @FXML
    Button btnImg2;

    public AddController(LinkedList listOfBook) {
        this.listOfBook = listOfBook;
    }

    @Override
    public void initialize(URL location, ResourceBundle resource)
    {
        btnImg1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) { addImg(); }
        });
        btnImg2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { addImg(); }
        });
    }

    public void addImg()
    {
        final FileChooser fileChooser = new FileChooser();
        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);
        Button button1 = new Button("Select file");

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                File file = fileChooser.showOpenDialog(btnImg1.getScene().getWindow());
                if (file != null)
                {
                    if (this.equals(btnImg1)) {
                        img1 = file.getAbsolutePath();
                        System.out.println(img1);
                    }
                    else {
                        img2 = file.getAbsolutePath();
                        System.out.println(img2);
                    }
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("File is empty!");
                    alert.setHeaderText(null);
                    alert.setContentText("File is empty!");
                }
            }
        });

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);
        root.getChildren().addAll(textArea, button1);

        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();
    }
    public void addBook()
    {
        int r;
        try{
            r = Integer.parseInt(rate.getText());
            Book book = new Book(
                    nameBook.getText(),
                    authorBook.getText(),
                    publishingHouse.getText(),
                    ISBN.getText(),
                    reviewArea.getText(),
                    annotation.getText(),
                    img1,
                    img2,
                    r
                    );
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong info");
            alert.setHeaderText(null);
            alert.setContentText("In rate wrote not number!");
        }
    }
}
