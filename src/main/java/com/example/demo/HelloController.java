package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HelloController {
    String annotationText = "Гарри Поттера ждет самое страшное испытание в жизни - смертельная схватка с " +
        "Волан-де-Мортом. Ждать помощи не от кого - Гарри одинок как никогда… \nДрузья и враги Гарри предстают " +
        "в совершенно неожиданном свете. Граница между Добром и Злом становится все призрачнее…";

    @FXML
    private Label nameBook;

    @FXML
    private Label authorBook;

    @FXML
    private Label publishingHouse;

    @FXML
    private Label ISBN;

    @FXML
    private TextArea rewiev;

    @FXML
    private TextArea annotation;

    @FXML
    private ImageView imgOne;

    @FXML
    private ImageView imgTwo;
    @FXML
    public void initialize()
    {
        Image image1 = new Image("Harry.jpg");
        Image image2 = new Image("Harry2.jpg");
        nameBook.setText("Гарри Поттер и Дары Смерти");
        authorBook.setText("Гарри Поттер и Дары Смерти");
        publishingHouse.setText("Гарри Поттер и Дары Смерти");
        ISBN.setText("Гарри Поттер и Дары Смерти");
        annotation.setPrefColumnCount(2);
        annotation.setText(annotationText);
        imgOne.setImage(image1);
        imgTwo.setImage(image2);
    }



}