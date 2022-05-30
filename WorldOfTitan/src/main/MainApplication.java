package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApplication extends Application {
    //Start GUI
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/startView.fxml"));
            primaryStage.setTitle("Attack On Titan 進撃の巨人");

            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setWidth(950);
            primaryStage.setHeight(650);
            primaryStage.setResizable(false);
                        primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
