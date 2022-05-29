package com.example.aotgui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CarryOutMissionMenuController implements Initializable {
    @FXML
    private Text startingPoint;
    @FXML
    private TextField startingPointEnteredByUser;
    @FXML
    private Button btBackToPrevious;
    @FXML
    private Button btCheck;
    private MainApplication main;

    public void setApp(MainApplication main) {
        this.main = main;
    }

    public void backToPrevious() throws Exception {
        main.goToLoginMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
