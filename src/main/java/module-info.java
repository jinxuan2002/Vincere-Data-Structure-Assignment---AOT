module com.example.aotgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aotgui to javafx.fxml;
    exports com.example.aotgui;
}