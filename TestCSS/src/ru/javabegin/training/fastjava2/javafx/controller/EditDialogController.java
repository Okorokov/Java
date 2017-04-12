package ru.javabegin.training.fastjava2.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.javabegin.training.fastjava2.javafx.objects.Person;

/**
 * Created by Sintek on 23.03.2017.
 */
public class EditDialogController {
    @FXML
    public Label labelFamale;

    @FXML
    public Label labelPhone;

    @FXML
    public TextField txtFamale;

    @FXML
    public TextField txtPhone;

    @FXML
    public Button btnOk;

    @FXML
    public Button btnCancel;

    private Person person;
    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        stage.hide();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;

        txtFamale.setText(person.getFio());
        txtPhone.setText(person.getPhone());
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setPhone(txtPhone.getText());
        person.setFio(txtFamale.getText());
        actionClose(actionEvent);
    }
}
