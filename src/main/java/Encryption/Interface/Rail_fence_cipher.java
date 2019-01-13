package main.java.Encryption.Interface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.java.Encryption.NumberTextField;
import main.java.Encryption.Rail_algorithm;

public class Rail_fence_cipher {

    //Main
    VBox mainVBox = new VBox();
    public Scene mainScene = new Scene(mainVBox, 285, 250);
    Stage stage_1 = new Stage();


    //Input Parametrs
    Label labelLevel = new Label("Level:");
    NumberTextField numberTextLevel = new NumberTextField();
    HBox levelHBox = new HBox(labelLevel, numberTextLevel);

    Label labelPosition = new Label("Position:");
    NumberTextField numberTextPosition = new NumberTextField();
    HBox positionHBox = new HBox(labelPosition, numberTextPosition);


    //Input String
    Button encryptClear = new Button("Clear ->");
    TextField encryptField = new TextField("Type your text here!");
    HBox encryptBox = new HBox(encryptClear, encryptField);

    Button decryptClear = new Button("Clear ->");
    TextField decryptField = new TextField();
    HBox decryptBox = new HBox(decryptClear, decryptField);



    //Run
    private Button encodeButton = new Button("Encode!");
    private Button decodeButton = new Button("Decode!");
    HBox codeBox = new HBox(encodeButton, decodeButton);



    public Rail_fence_cipher() {

        //Set Parametrs input
        levelHBox.setPadding(new Insets(10,0,5,10));
        levelHBox.setSpacing(10);
        positionHBox.setPadding(new Insets(10,0,5,10));
        positionHBox.setSpacing(10);
        numberTextLevel.setPrefWidth(65);
        numberTextPosition.setPrefWidth(50);
        numberTextPosition.setText("1");
        numberTextLevel.setText("1");
        codeBox.setPadding(new Insets(10,0,0,10));
        codeBox.setSpacing(30);
        encodeButton.setPrefSize(100,30);
        decodeButton.setPrefSize(100,30);


        encodeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


            }
        });

        decodeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });


        encryptClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                encryptField.setText("");
            }
        });


        decryptClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                decryptField.setText("");
            }
        });


        mainVBox.getChildren().setAll(levelHBox, positionHBox, encryptBox, decryptBox, codeBox);
        stage_1.setScene(mainScene);
    }
}
