package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Encryption.Interface.Baudot_code;
import main.java.Encryption.Interface.Rail_fence_cipher;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainVBox = new VBox();
        Scene scene = new Scene(mainVBox, 300, 275);
        primaryStage.setTitle("Data Encryption");

        //VBox setting
        mainVBox.setPadding(new Insets(30, 50, 0, 50));
        mainVBox.setSpacing(35);

        //Label
        Label descriptionLabel = new Label("Choose encryption option!");

        //Buttons
        Button railButton = new Button("Rail fence cipher");
        Button baudotButton = new Button("Baudot code");
        mainVBox.getChildren().addAll(descriptionLabel, railButton, baudotButton);
        railButton.setPrefSize(200, 35);
        baudotButton.setPrefSize(200, 35);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


        railButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Rail_fence_cipher rail_fence_cipher = new Rail_fence_cipher();

                primaryStage.setScene(rail_fence_cipher.mainScene);
                primaryStage.setTitle("DE - Rail_fence_cipher");
            }
        });


        baudotButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Baudot_code baudot_code = new Baudot_code();

                primaryStage.setScene(baudot_code.mainScene);
                primaryStage.setTitle("Data Encryption - Baudot_code");


            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
