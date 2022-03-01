package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController extends MainController implements Initializable {
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

    @FXML
    Button btn;

    public AddController() throws Exception {super();}

    @Override
    public void initialize(URL location, ResourceBundle resource)
    {
        btnImg1.setOnAction(event ->  addImg());
        btnImg2.setOnAction(event ->  addImg());
    }

    public void addImg()
    {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(btnImg1.getScene().getWindow());
        if (file != null)
        {
            if (img1 == null || img1.equals("") ) img1 = file.getAbsolutePath();

            else img2 = file.getAbsolutePath();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("File is empty!");
            alert.setHeaderText(null);
            alert.setContentText("File is empty!");
        }
    }

    public void addBook()
    {
        try{
            int r = Integer.parseInt(rate.getText());
            Book book = new Book(
                    nameBook.getText(),authorBook.getText(),
                    publishingHouse.getText(),ISBN.getText(),
                    reviewArea.getText(),annotation.getText(),
                    img1,img2,
                    r,"will_read"
                    );
            listBook.add(book);
            addInCSV();
            btn.setDisable(true);
            clickOnListBook(2);
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
