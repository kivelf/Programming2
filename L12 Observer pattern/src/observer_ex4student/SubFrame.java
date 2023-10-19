package observer_ex4student;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubFrame extends Stage implements ColourObserver{
    private final GridPane pane = new GridPane();
    private final MainFrame mainFrame;

    public SubFrame(String title, Stage owner, MainFrame mainFrame) {
        this.initOwner(owner);
        this.mainFrame = mainFrame;
        this.initStyle(StageStyle.UTILITY);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        this.initContent();

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final Label lblInfo =  new Label("State: Unsubscribed");

    private void initContent() {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHeader = new Label("Computer Science is colorful");
        pane.add(lblHeader, 0, 0);

        Button btnSubscribe = new Button("Subscribe");
        pane.add(btnSubscribe, 0, 1);
        btnSubscribe.setOnAction(event -> this.subscribe());

        Button btnUnsubscribe = new Button("Unsubscribe");
        pane.add(btnUnsubscribe, 0, 2);
        btnUnsubscribe.setOnAction(event -> this.unsubscribe());

        pane.add(this.lblInfo, 0, 3);
    }

    // -------------------------------------------------------------------------
    public void subscribe(){
        this.lblInfo.setText("State: subscribed");
        MainFrame.registerObserver(this);
    }

    public void unsubscribe(){
        this.lblInfo.setText("State: unubscribed");
        MainFrame.deregisterObserver(this);
    }

    // -------------------------------------------------------------------------
    @Override
    public void update(String colour){
        this.pane.setStyle("-fx-background-color: " + colour);
    }
}
