package com.example.aotgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DisplayAllAlliesMenuController implements Initializable {
    @FXML
    private Button btBackToPrevious;
    private MainApplication main;

    public void setApp(MainApplication main) {
        this.main = main;
    }

    public void backToPrevious() throws Exception {
        main.goToCheckAlliesMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
