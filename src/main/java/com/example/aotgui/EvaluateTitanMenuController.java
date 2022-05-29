package com.example.aotgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EvaluateTitanMenuController implements Initializable {
    @FXML
    private Text numberOfTitans;
    @FXML
    private TextField numberOfTitansEnteredByUser;
    @FXML
    private Button btBackToPrevious;
    @FXML
    private Button btEnter;
    private MainApplication main;

    public void setApp(MainApplication main){
        this.main = main;
    }

    public void backToPrevious() throws Exception {
        main.goToLoginMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
