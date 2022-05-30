package controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class StartController {

    private Stage stage;
    private Scene scene;
    private Parent home;

    public void switchToHome(javafx.event.ActionEvent actionEvent)throws IOException {
        home= FXMLLoader.load(getClass().getResource("/views/killingPriorityView.fxml"));
        stage= (Stage)((Node)actionEvent.getSource()).getScene().getWindow();  // Obtain the current stage
        scene=new Scene(home);
        stage.setScene(scene); // Set the scene of the obtained stage into the new scene
        stage.show();
    }

}
