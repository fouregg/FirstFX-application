package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainController {
    static LinkedList<Book> listBook;
    static String pathCSV = "C:\\FirstFX-application\\src\\main\\resources\\data.csv";

    public MainController() throws Exception {
      listBook = ParseCSV(pathCSV);
    }

    private static LinkedList<Book> ParseCSV(String path) throws Exception
    {
        LinkedList<Book> books = new LinkedList();
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line : lines)
        {
            String[] splited = line.split(";");
            ArrayList<String> column = new ArrayList<>();
            for (String s : splited) {
                if (CheckColumn(s)) {
                    String lastText = column.get(column.size());
                    column.set(column.size() - 1, lastText + ";" + s);
                } else {
                    column.add(s);
                }
            }
                Book book = new Book(
                                    column.get(0), column.get(1), column.get(2),column.get(3),
                                    column.get(4), column.get(5), column.get(6), column.get(7),
                                    Integer.parseInt(column.get(8).substring(1,column.get(8).length()-1)),
                                    column.get(9).substring(1, column.get(9).length()-1)
                                    );
                books.add(book);
        }
        return books;
    }

    private static boolean CheckColumn(String text)
    {
        String trimText = text.trim();
        //Если в тексте одна ковычка или текст на неё заканчивается, то это часть предыдушей колонки
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"");
    }

    private static String deleteQuotes(String text)
    {
        while (text.charAt(0) == '\"' && text.charAt(text.length()-1)=='\"')
        {
            text = text.replaceFirst("\"", "");
            text = text.substring(0,text.length()-1);
        }
        return text;
    }

    public static boolean addInCSV()
    {
        try (PrintWriter writer = new PrintWriter(pathCSV)){
            for (Book book : listBook) {
                String line = "";
                line += "\"" + deleteQuotes(book.getNameOfBook()) + "\";";
                line += "\"" + deleteQuotes(book.getAuthorOfBook()) + "\";";
                line += "\"" + deleteQuotes(book.getPublishingOfHouse()) + "\";";
                line += "\"" + deleteQuotes(book.getIsbn()) + "\";";
                line += "\"" + deleteQuotes(book.getReview()) + "\";";
                line += "\"" + deleteQuotes(book.getAnnotationText()) + "\";";
                line += "\"" + deleteQuotes(book.getImg1()) + "\";";
                line += "\"" + deleteQuotes(book.getImg2()) + "\";";
                line += "\"" + deleteQuotes(String.valueOf(book.getRate())) + "\";";
                line += "\"" + deleteQuotes(String.valueOf(book.getState())) + "\"";
                line += "\n";
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @FXML
    public MenuBar menuBar;


    @FXML
    public void clickOnReadingBook() throws Exception
    {
        clickOnListBook(2);
    }

    @FXML
    public void clickOnReadBook() throws Exception
    {
        clickOnListBook(0);
    }

    @FXML
    public void clickOnWillReadBook() throws Exception
    {
        clickOnListBook(1);
    }

    public void clickOnListBook(int i) throws Exception
    {
        System.out.println(Thread.currentThread().getStackTrace()[2]);
        Stage stage = (Stage)(menuBar).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("list-view.fxml"));
        ListController controller = new ListController(i);
        root.setController(controller);
        AnchorPane pane = root.load();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clickOnAddBook() throws Exception
    {
        Stage stage = (Stage)(menuBar).getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("add_view.fxml"));
        AddController controller = new AddController();
        root.setController(controller);
        AnchorPane pane = root.load();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }


}
