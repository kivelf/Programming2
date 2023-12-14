package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Pizza;
import opg1.Controller;

public class PizzaInputWindow extends Stage {

	public PizzaInputWindow(String title, Stage owner) {
		this.initOwner(owner);
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setMinHeight(100);
		this.setMinWidth(200);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

	}

	// -------------------------------------------------------------------------
	private final TextField txfName = new TextField();
	private final TextField txfPrice = new TextField();
	private final Label lblError = new Label();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		Label lblHours = new Label("Price:");
		pane.add(lblHours, 0, 2);

		pane.add(txfPrice, 0, 3);

		Button btnOK = new Button("Opret pizza");
		pane.add(btnOK, 0, 4);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		pane.add(lblError, 0, 5);
		lblError.setStyle("-fx-text-fill: red");
	}
	// -------------------------------------------------------------------------

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.isEmpty()) {
			lblError.setText("Name is empty!");
			return;
		}

		double pris = 0;
		try {
			pris = Double.parseDouble(txfPrice.getText().trim());
		} catch (NumberFormatException ex) {
			System.out.println(ex);
		}
		if (pris <= 0) {
			lblError.setText("Price is not a positive number");
			return;
		}

		Controller.createPizza(name, pris);

		this.hide();
	}
}
