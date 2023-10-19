package observer_ex4student;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.HashSet;

public class MainFrame extends Application {
    private final GridPane pane = new GridPane();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ex. 4: Observer Pattern");
        this.initContent(stage);

        Scene scene = new Scene(this.pane);
        stage.setScene(scene);
        stage.show();
    }

    // ------------------------------------------------------------------------

    private void initContent(Stage stage) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNumber = new Label("Number");
        pane.add(lblNumber, 0, 0);

        ToggleGroup group = new ToggleGroup();

        RadioButton rbnRed = new RadioButton("Red");
        pane.add(rbnRed, 0, 1);
        rbnRed.setToggleGroup(group);
        rbnRed.setOnAction(event -> this.redAction());

        RadioButton rbnGreen = new RadioButton("Green");
        pane.add(rbnGreen, 0, 2);
        rbnGreen.setToggleGroup(group);
        rbnGreen.setOnAction(event -> this.greenAction());

        RadioButton rbnBlue = new RadioButton("Blue");
        pane.add(rbnBlue, 0, 3);
        rbnBlue.setToggleGroup(group);
        rbnBlue.setOnAction(event -> this.blueAction());

        SubFrame subFrame1 = new SubFrame("SubFrame 1", stage, this);
        Button btnShowFrame1 = new Button("Open SubFrame 1");
        pane.add(btnShowFrame1, 0, 4);
        btnShowFrame1.setOnAction(event -> this.toggleShowSubframe(subFrame1, btnShowFrame1));

        SubFrame subFrame2 = new SubFrame("SubFrame 2", stage, this);
        Button btnShowFrame2 = new Button("Open SubFrame 2");
        pane.add(btnShowFrame2, 0, 5);
        btnShowFrame2.setOnAction(event -> this.toggleShowSubframe(subFrame2, btnShowFrame2));
    }

    // ------------------------------------------------------------------------

    private String color;
    private final static HashSet<ColourObserver> observers = new HashSet<>();

    private void redAction() {
        color = "pink";
        pane.setStyle("-fx-background-color: " + color);
        updateAllObservers(color);
    }

    private void greenAction() {
        color = "lightgreen";
        pane.setStyle("-fx-background-color: " + color);
        updateAllObservers(color);
    }

    private void blueAction() {
        color = "lightskyblue";
        pane.setStyle("-fx-background-color: " + color);
        updateAllObservers(color);
    }

    // ------------------------------------------------------------------------
    private void toggleShowSubframe(SubFrame subFrame, Button button){
        if (subFrame.isShowing()){
            subFrame.hide();
            button.setText("Open " + subFrame.getTitle());
        } else {
            subFrame.show();
            button.setText("Close " + subFrame.getTitle());
        }
    }

    public static void registerObserver(ColourObserver colourObserver){
        observers.add(colourObserver);
    }

    public static void deregisterObserver(ColourObserver colourObserver){
        observers.remove(colourObserver);
    }

    public void updateAllObservers(String colour){
        for (ColourObserver cobs : observers){
            cobs.update(colour);
        }
    }
}
