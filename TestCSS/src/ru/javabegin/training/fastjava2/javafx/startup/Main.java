package ru.javabegin.training.fastjava2.javafx.startup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.javabegin.training.fastjava2.javafx.controller.Controller;
import ru.javabegin.training.fastjava2.javafx.objects.Person;
import ru.javabegin.training.fastjava2.javafx.interfaces.impls.CollectionAddressBook;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader= new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/main.fxml"));
        Parent fxmlMain=fxmlLoader.load();
        Controller mainController=fxmlLoader.getController();
        mainController.setMainStage(primaryStage);
        primaryStage.setTitle("Адресная книга");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(355);
        Scene scene= new Scene(fxmlMain, 300,375);
        scene.getStylesheets().add(0, "ru/javabegin/training/fastjava2/javafx/styles/my.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        testData();
    }

    private void testData(){
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
