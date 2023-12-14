package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Pizza;
import opg1.Controller;
import opg1.gui.Observer;

public class PizzaWindow extends Application implements Observer {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Pizzaer");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void init() {
		Controller.addObserver(this);
	}

	// -------------------------------------------------------------------------
	private final ListView<Pizza> lvwPizzas = new ListView<>();
	private final Button btnAdd = new Button("Opret ny pizza");
	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblComp = new Label("Liste over pizzaer");
		pane.add(lblComp, 0, 0);

		pane.add(lvwPizzas, 0, 1, 1, 4);
		lvwPizzas.setPrefWidth(300);
		lvwPizzas.setPrefHeight(250);
		lvwPizzas.getItems().setAll(Controller.getPizzas());

		ChangeListener<Pizza> listener = (ov, o, n) -> this.selectedPizzaChanged();
		lvwPizzas.getSelectionModel().selectedItemProperty().addListener(listener);

		pane.add(btnAdd, 0, 6);
		HBox hBox = new HBox(btnAdd);
		pane.add(hBox, 0, 6);
		hBox.setAlignment(Pos.CENTER);
		btnAdd.setOnAction(event -> this.addAction());
	}

	private void selectedPizzaChanged() {
		Pizza pizza = lvwPizzas.getSelectionModel().getSelectedItem();
		if (pizza == null) return;
	}

	@Override
	public void update() {
		lvwPizzas.getItems().setAll(Controller.getPizzas());
	}

	private void addAction() {
		gui.PizzaInputWindow dialog = new gui.PizzaInputWindow("Opret pizza", null);
		dialog.showAndWait();

		// Wait for the modal dialog to close

		lvwPizzas.getItems().setAll(Controller.getPizzas());
		int index = lvwPizzas.getItems().size() - 1;
		lvwPizzas.getSelectionModel().select(index);
	}
}
