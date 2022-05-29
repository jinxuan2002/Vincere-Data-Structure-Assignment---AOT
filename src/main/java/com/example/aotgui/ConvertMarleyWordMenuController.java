package com.example.aotgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ConvertMarleyWordMenuController implements Initializable {
    @FXML
    private Text enterMarleySentence;
    @FXML
    private TextField marleySentencedEnteredByUser;
    @FXML
    private Button btBackToPrevious;
    @FXML
    private Button btTranslate;
    private MainApplication main;

    public void setApp(MainApplication main) {
        this.main = main;
        System.out.println("Hello");
    }

    public void backToPrevious() throws Exception {
        main.goToLoginMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
