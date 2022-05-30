package controllers;

import worldOfTitan.PriorityQueue;
import worldOfTitan.Titan;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class killingPriorityController {
    @FXML
    private TextField noOfTitan;
    @FXML
    private Label resultLabel;
    @FXML
    private Label errorLabel;

    private Stage stage;
    private Scene scene;
    private Parent hamiltonian;

    public void switchTohamiltonian(javafx.event.ActionEvent actionEvent)throws IOException {
        hamiltonian= FXMLLoader.load(getClass().getResource("/views/hamiltonianView.fxml"));
        stage= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();  // Obtain the current stage
        scene=new Scene(hamiltonian);
        stage.setScene(scene); // Set the scene of the obtained stage into the new scene
        stage.show();
    }

    public void confirm (javafx.event.ActionEvent actionEvent)throws IOException {
        resultLabel.setText(randomGenerate());
        new Titan().setTitanNo(0);
    }

    public String randomGenerate() {
        int titanNumber;
        if(!isNumeric(noOfTitan.getText())){
            errorLabel.setText("Please input an INTEGER!");
        }else {
            titanNumber = Integer.parseInt(noOfTitan.getText());
            PriorityQueue titanQueue = new PriorityQueue();

            StringBuilder str = new StringBuilder("Generating " + titanNumber + " Titans ....\n");
            for (int i = 1; i <= titanNumber; i++) {
                Titan t = new Titan();
                titanQueue.offer(t);
                str.append(t.toString() + "\n");
            }
            str.append("\n");
            str.append(titanQueue.toString() + "\n");

            return str.toString();
        }
        return "";
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
