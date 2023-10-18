package JavafxObserverExample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Angel listener - Devil listener");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(100));

        Button btn = new Button("Should I do it?");
        pane.add(btn, 0, 0);
        btn.addEventHandler(ActionEvent.ACTION, event ->
                System.out.println("Angel: Don't do it, you might regret it!"));
        btn.addEventHandler(ActionEvent.ACTION, event ->
                System.out.println("Devil: Come on, do it!"));
    }
}
