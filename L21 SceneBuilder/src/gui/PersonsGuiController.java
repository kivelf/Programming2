package gui;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Person;

public class PersonsGuiController {
    @FXML
    public CheckBox chbSenior;

    @FXML
    private Button btnAddPerson;

    @FXML
    private Label lblPersons;

    @FXML
    private Label lblTitel;

    @FXML
    private ListView<Person> lvwPersons;

    @FXML
    private TextField txfName;

    @FXML
    private TextField txfTitle;

    public void initialize() {
        lvwPersons.getItems().addAll(Controller.getAllPersons());
    }

    @FXML
    private void addPersonAction() {
        String name = txfName.getText();
        String title = txfTitle.getText();
        boolean senior = chbSenior.isSelected();
        Controller.opretPerson(name, title, senior);

        lvwPersons.getItems().setAll(Controller.getAllPersons());
        System.out.println(name + " " + title);
    }
}
