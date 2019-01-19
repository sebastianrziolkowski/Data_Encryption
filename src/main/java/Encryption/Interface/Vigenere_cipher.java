package main.java.Encryption.Interface;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.Encryption.Vigenere_algorithm;

public class Vigenere_cipher {

    private VBox mainVBox = new VBox();
    public Scene mainScene = new Scene(mainVBox, 350, 300);


    public Vigenere_cipher() {
        //Input Box
        Button clearInputButton = new Button("Delete ->");
        TextField inputField = new TextField("Type your text here");
        HBox inputBox = new HBox(clearInputButton, inputField);


        //Output Box
        Button clearoutputButton = new Button("Delete ->");
        Label outputLabel = new Label("Decoded:");
        TextField outputField = new TextField("");
        HBox outputBox = new HBox(clearoutputButton, outputLabel, outputField);

        //Radio Button
        final ToggleGroup radioGroup = new ToggleGroup();
        RadioButton keyWord = new RadioButton("Key word");
        RadioButton autoKey = new RadioButton("Autokey");
        RadioButton keyWord_2 = new RadioButton("Key word_2");
        HBox radioBox = new HBox(keyWord, autoKey, keyWord_2);


        //Key
        Button deleteKeyButton = new Button("Delete ->");
        Label keyLabel = new Label("Key:");
        TextField keyWordField = new TextField();
        HBox keyBox = new HBox(deleteKeyButton, keyLabel, keyWordField);


        //Button
        Button codeButton = new Button("Encrypt!");
        Button decodeButton = new Button("Decrypt!");
        HBox buttonBox = new HBox(codeButton, decodeButton);

        codeButton.setPrefSize(100, 30);
        decodeButton.setPrefSize(100, 30);
        buttonBox.setSpacing(50);
        buttonBox.setPadding(new Insets(10, 0, 10, 50));
        outputBox.setSpacing(15);
        outputBox.setPadding(new Insets(20, 0, 10, 35));
        keyBox.setSpacing(20);
        keyBox.setPadding(new Insets(20, 0, 10, 40));
        inputBox.setSpacing(20);
        inputBox.setPadding(new Insets(20, 0, 10, 40));
        radioBox.setSpacing(30);
        radioBox.setPadding(new Insets(10, 0, 10, 30));
        outputBox.setSpacing(20);
        outputBox.setPadding(new Insets(20, 0, 10, 40));


        //Radio Button Group
        keyWord.setToggleGroup(radioGroup);
        keyWord.setUserData("keyWord");
        autoKey.setToggleGroup(radioGroup);
        autoKey.setUserData("autoKey");
        keyWord_2.setToggleGroup(radioGroup);
        keyWord_2.setUserData("keyWord_2");          //have to change this when keyWord_2 will by different.

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (radioGroup.getSelectedToggle() != null) {
                    String button = radioGroup.getSelectedToggle().getUserData().toString();

                    switch (button) {
                        case "keyWord":

                            codeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String message = inputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");
                                    if (message.equals("")) {
                                        message = "Filedcantbyempty";
                                        inputField.setText(message);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(key, message);
                                    String codedText = vigenere.Cipher();
                                    outputField.setText(codedText.toUpperCase());

                                }
                            });

                            decodeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String codeMessage = outputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");

                                    if (codeMessage.equals("")) {
                                        codeMessage = "filedcantbyempty";
                                        outputField.setText(codeMessage);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(key, codeMessage);
                                    String codedText = vigenere.Decipher(outputField.getText());
                                    inputField.setText(codedText.toUpperCase());


                                }
                            });


                            break;
                        case "autoKey":

                            codeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String message = inputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");
                                    if (message.equals("")) {
                                        message = "File cant be empty";
                                        inputField.setText(message);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    keyWordField.setText(Character.toString(key.charAt(0)));
                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(Character.toString(key.charAt(0)), message);
                                    String codedText = vigenere.CipherAutoKey();
                                    outputField.setText(codedText.toUpperCase());

                                }
                            });


                            decodeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String codeMessage = outputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");

                                    if (codeMessage.equals("")) {
                                        codeMessage = "filedcantbyempty";
                                        outputField.setText(codeMessage);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    keyWordField.setText(Character.toString(key.charAt(0)));
                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(Character.toString(key.charAt(0)), codeMessage);
                                    String codedText = vigenere.DecipherAutoKey(outputField.getText());
                                    inputField.setText(codedText.toUpperCase());


                                }
                            });

                            break;
                        case "keyWord_2":

                            codeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String message = inputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");
                                    if (message.equals("")) {
                                        message = "Filedcantbyempty";
                                        inputField.setText(message);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(key, message);
                                    String codedText = vigenere.Cipher();
                                    outputField.setText(codedText.toUpperCase());

                                }
                            });

                            decodeButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    String codeMessage = outputField.getText().toLowerCase().replaceAll("\\s+","");
                                    String key = keyWordField.getText().toLowerCase().replaceAll("\\s+","");

                                    if (codeMessage.equals("")) {
                                        codeMessage = "filedcantbyempty";
                                        outputField.setText(codeMessage);
                                    }
                                    if(key.equals(""))
                                    {
                                        key="a";
                                        keyWordField.setText(key);
                                    }

                                    Vigenere_algorithm vigenere = new Vigenere_algorithm(key, codeMessage);
                                    String codedText = vigenere.DecipherOpposite(outputField.getText());
                                    inputField.setText(codedText.toUpperCase());


                                }
                            });

                            break;
                        default:
                            System.out.println("Button not defined!");
                            break;
                    }

                }

            }
        });


        clearInputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputField.setText("");
            }
        });

        clearoutputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                outputField.setText("");
            }
        });


        deleteKeyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                keyWordField.setText("");
            }
        });

        mainVBox.getChildren().addAll(inputBox, radioBox, keyBox, outputBox, buttonBox);
    }

}
