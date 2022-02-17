package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController extends MainController implements Initializable {
    StringProperty authorOfBook = new SimpleStringProperty();
    StringProperty annotationText = new SimpleStringProperty();
    StringProperty nameOfBook = new SimpleStringProperty();
    StringProperty publishingofHouse = new SimpleStringProperty();
    StringProperty isbn = new SimpleStringProperty();
    StringProperty review = new SimpleStringProperty();
    StringProperty img1 = new SimpleStringProperty();
    StringProperty img2 = new SimpleStringProperty();

    public ViewController(String annotationText, String nameOfBook, String authorOfBook, String publishingofHouse, String isbn, String review, String img1, String img2) {
        this.annotationText.set(annotationText);
        this.authorOfBook.set(authorOfBook);
        this.nameOfBook.set(nameOfBook);
        this.publishingofHouse.set(publishingofHouse);
        this.isbn.set(isbn);
        this.review.set(review);
        this.img1.set(img1);
        this.img2.set(img2);
    }

    @FXML
    private AnchorPane leftPanel;

    @FXML
    private Label nameBook;

    @FXML
    private Label authorBook;

    @FXML
    private Label publishingHouse;

    @FXML
    private Label ISBN;

    @FXML
    private TextArea reviewArea;

    @FXML
    private TextArea annotation;

    @FXML
    private ImageView imgOne;

    @FXML
    private ImageView imgTwo;
    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resource)
    {
        Image image1 = new Image(img1.get());
        Image image2 = new Image(img2.get());
        nameBook.setText(nameOfBook.get());
        authorBook.setText(authorOfBook.get());
        publishingHouse.setText(publishingofHouse.get());
        ISBN.setText(isbn.get());
        annotation.setPrefColumnCount(2);
        annotation.setText(annotationText.get());
        reviewArea.setText(review.get());
        imgOne.setImage(image1);
        imgTwo.setImage(image2);
    }

    public void backToList()
    {
        nameBook.getScene().getWindow().hide();
    }
}