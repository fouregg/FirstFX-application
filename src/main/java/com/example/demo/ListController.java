package com.example.demo;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ListController extends MainController implements Initializable {
    private int indexTab = 0;

    @FXML
    private VBox vBoxRead;

    @FXML
    private VBox vBoxReading;

    @FXML
    private VBox vBoxWillRead;

    @FXML
    private TabPane tabPane;

    @FXML
    private AnchorPane book;

    @FXML
    private TextField searchField;

    @FXML
    private AnchorPane listBookPane;

    public ListController() throws Exception {
        super();
        MainController.ParseCSV(MainController.pathCSV);
    }

    public ListController(int i) throws Exception {
        super();
        indexTab = i;
    }

    @Override
    public void initialize(URL location, ResourceBundle resource){
        generateList(listBook);
    }

    public void createChildrenAnchorElement(AnchorPane book, int i)
    {
        Book curBook = listBook.get(i);
        Label name_of_book = new Label("Name of Book");
        name_of_book.minWidth(100);
        name_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_book,30.0);
        AnchorPane.setLeftAnchor(name_of_book,10.0);
        AnchorPane.setRightAnchor(name_of_book,500.0);
        AnchorPane.setTopAnchor(name_of_book,10.0);

        Label curname_of_book = new Label(curBook.getNameOfBook());
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

        Label curname_of_author = new Label(curBook.getAuthorOfBook());
        curname_of_book.minWidth(120);
        curname_of_book.minHeight(50);
        AnchorPane.setBottomAnchor(curname_of_author,10.0);
        AnchorPane.setLeftAnchor(curname_of_author,110.0);
        AnchorPane.setRightAnchor(curname_of_author,514.0);
        AnchorPane.setTopAnchor(curname_of_author,30.0);

        Button info = new Button("info");
        Button delete = new Button("Delete");

        InputStream input = HelloApplication.class.getResourceAsStream("icon-done.png");
        Image imgIcon1 = new Image(input);
        input = HelloApplication.class.getResourceAsStream("icon-open-book.png");
        Image imgIcon2 = new Image(input);
        input = HelloApplication.class.getResourceAsStream("will-read-icon.png");
        Image imgIcon3 = new Image(input);

        ImageView imageView1 = new ImageView(imgIcon1);
        ImageView imageView2 = new ImageView(imgIcon2);
        ImageView imageView3 = new ImageView(imgIcon3);
        ImageView imageViewMain = new ImageView();

        MenuItem menuItem1 = new MenuItem("Read", imageView1);
        menuItem1.setOnAction(event -> {
            Book tmp = listBook.get(i);
            tmp.setState(State.READ);
            listBook.set(i,tmp);
            addInCSV();
            try {
                clickOnListBook(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        MenuItem menuItem2 = new MenuItem("Reading", imageView2);
        menuItem2.setOnAction(event -> {
            Book tmp = listBook.get(i);
            tmp.setState(State.READING);
            listBook.set(i,tmp);
            addInCSV();
            try {
                clickOnListBook(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        MenuItem menuItem3 = new MenuItem("Will Read", imageView3);
        menuItem3.setOnAction(event -> {
            Book tmp = listBook.get(i);
            tmp.setState(State.WILL_READ);
            listBook.set(i,tmp);
            addInCSV();
            try {
                clickOnListBook(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        MenuButton markAsRead = new MenuButton("Choise mark", imageViewMain, menuItem1, menuItem2, menuItem3);


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(200);
        hBox.setMinWidth(300);
        hBox.setMaxHeight(200);
        hBox.setMaxWidth(350);
        hBox.setSpacing(20);
        AnchorPane.setBottomAnchor(hBox,10.0);
        AnchorPane.setLeftAnchor(hBox,500.0);
        AnchorPane.setRightAnchor(hBox,20.0);
        AnchorPane.setTopAnchor(hBox,10.0);

        markAsRead.setStyle("-fx-background-color: #F2E7DC; -fx-text-fill: #0D0D0D;");
        info.setStyle("-fx-background-color: #F2E7DC; -fx-text-fill: #0D0D0D;");
        delete.setStyle("-fx-background-color: #F2E7DC; -fx-text-fill: #0D0D0D;");
        hBox.getChildren().addAll(info, markAsRead, delete);



        book.getChildren().addAll(name_of_book, curname_of_book, name_of_author, curname_of_author, hBox);

        info.setOnAction(event ->  {
            try {
                infoAboutBook(i);
            }
            catch (Exception e)
            {
                System.err.println(e.getLocalizedMessage());
            }
        });
        delete.setOnAction(event ->  deleteBook(i));
    }

    private void clearVBoxInList()
    {
        for (int i = 0; i < 3; i++) {
            Tab tmp = tabPane.getTabs().get(i);
            ScrollPane t = (ScrollPane) tmp.getContent();
            VBox childrenScroll = (VBox) t.getContent();
            childrenScroll.getChildren().clear();
        }
    }
    private void generateList(LinkedList<Book> list)
    {
        clearVBoxInList();
        final int countOfBook = list.size();
        final int heightElement = 60;
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(indexTab);
        vBoxRead.minHeight(heightElement * countOfBook);
        vBoxWillRead.minHeight(heightElement * countOfBook);
        vBoxReading.minHeight(heightElement * countOfBook);
        for (int i = 0; i < countOfBook; i++) {
            Book curBook = list.get(i);

            AnchorPane pane = new AnchorPane();

            pane.setMinHeight(40);
            pane.setMaxHeight(heightElement);
            pane.prefWidth(800);
            pane.prefHeight(heightElement);
            pane.minWidth(Region.USE_COMPUTED_SIZE);
            pane.maxWidth(Region.USE_COMPUTED_SIZE);
            switch (curBook.getState()){
                case READ -> {vBoxRead.getChildren().add(pane);
                    System.out.println("Read case");}
                case READING -> {vBoxReading.getChildren().add(pane);
                    System.out.println("Reading case");}
                case WILL_READ -> {vBoxWillRead.getChildren().add(pane);
                    System.out.println("Will read");}
            }
            createChildrenAnchorElement(pane, i);
        }
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
                listBook.get(index).getRate(),
                listBook.get(index).getImg1(),
                listBook.get(index).getImg2()
                );
        root.setController(controller);
        AnchorPane splitPane = root.load();

        Scene scene = new Scene(splitPane, 800, 600);
        stage.setScene(scene);
        stage.showAndWait();

    }

    public void deleteBook(int index)
    {
        listBook.remove(index);
        addInCSV();
        try {
            clickOnListBook(tabPane.getSelectionModel().getSelectedIndex());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void buttonSearchBook()
    {
        searchField.setVisible(true);
    }

    public void searchBook()
    {
        indexTab = tabPane.getSelectionModel().getSelectedIndex();
        System.out.println(searchField.getText());
        if (searchField.getText().equals(""))
        {
            generateList(listBook);
        }
        else
        {
            String search = searchField.getText();
            LinkedList<Book> searchList = new LinkedList<>();
            for (Book cur : listBook) {
                if (cur.getNameOfBook().toLowerCase(Locale.ROOT).contains(search.toLowerCase(Locale.ROOT)))
                    searchList.add(cur);
            }
            generateList(searchList);
        }
    }
}
