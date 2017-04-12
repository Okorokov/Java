package ru.javabegin.training.fastjava2.javafx.controller;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import ru.javabegin.training.fastjava2.javafx.interfaces.impls.CollectionAddressBook;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

import java.io.IOException;

public class Controller {

    private CollectionAddressBook addressBookImpl= new CollectionAddressBook();
    private Stage mainStage;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSeach;

    @FXML
    private TableView tableAdressBook;

    @FXML
    private Label labelCount;
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader= new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private void  initialize(){
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        initListeners();

        fillData();

        initLoader();
    }

    private void fillData() {
        addressBookImpl.fillTestData();
        tableAdressBook.setItems(addressBookImpl.getPersonList());
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit=fxmlLoader.load();
            editDialogController=fxmlLoader.getController();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void initListeners(){
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();}
            });
        tableAdressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount()==2){
                    System.out.println("2click");
                    editDialogController.setPerson((Person)tableAdressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }
    private void updateCountLabel(){
        labelCount.setText("Количество записей "+addressBookImpl.getPersonList().size());
    }


    public void ShowDialog(ActionEvent actionEvent) {

    }

    public void actionButtonPressed(ActionEvent actionEvent) {
        Object source=actionEvent.getSource();

        if(!(source instanceof Button)){
            return;
        }

        Button clickedButton = (Button) source;



        switch (clickedButton.getId()){

            case "btnAdd":
                //System.out.println("add "+selectedPerson);
                editDialogController.setPerson(new Person());
                showDialog();
                addressBookImpl.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                System.out.println("edit");
                editDialogController.setPerson((Person)tableAdressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "btnDelete":
                System.out.println("delete");
                addressBookImpl.delete((Person)tableAdressBook.getSelectionModel().getSelectedItem());
                break;
        }

    }
    private void showDialog(){
        if(editDialogStage==null){
            editDialogStage= new Stage();
            editDialogStage.setTitle("Редактирование записи");

            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
                    }
        editDialogStage.showAndWait();
    }



    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
