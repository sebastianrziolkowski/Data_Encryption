package main.java.Encryption.Interface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Baudot_code {

    public VBox mainVBox = new VBox();
    public Scene mainScene = new Scene(mainVBox, 200, 400);
    public Stage stage_1 = new Stage();


    public Baudot_code() {




        mainVBox.getChildren().setAll();
        stage_1.setScene(mainScene);
    }
}
